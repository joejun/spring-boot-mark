# spring boot整合 mybatis

## 1. 模型生成实体类
* 用户表
```
CREATE TABLE `user` (
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
* mybatis-generator-db2java 工具  
** 生成带中文注释实体类 github: joejun/spring-boot-mark/mybatis-generator-db2java/  
** config.xml主要配置
```
<jdbcConnection driverClass="com.mysql.jdbc.Driver"
        connectionURL="jdbc:mysql://localhost:3306/test" userId="root"
        password="">
</jdbcConnection>
<!-- targetProject:生成PO类的位置 -->
<javaModelGenerator targetPackage="com.joe.chapter022.domain"
                   targetProject="F:/db2javaGenerate/java">
                   
   <!-- enableSubPackages:是否让schema作为包的后缀 -->
   <property name="enableSubPackages" value="false" />
   <!-- 从数据库返回的值被清理前后的空格 -->
   <property name="trimStrings" value="true" />
</javaModelGenerator> 
<!-- targetProject:mapper映射文件生成的位置
   如果maven工程只是单独的一个工程，targetProject="src/main/java"
   若果maven工程是分模块的工程，targetProject="所属模块的名称"，例如：
   targetProject="ecps-manager-mapper"，下同-->
<sqlMapGenerator targetPackage="mapper"
                 targetProject="F:/db2javaGenerate/resources">
    <!-- enableSubPackages:是否让schema作为包的后缀 -->
    <property name="enableSubPackages" value="true" />
</sqlMapGenerator>

<!-- targetPackage：mapper接口生成的位置 -->
<javaClientGenerator type="XMLMAPPER"
                     targetPackage="com.joe.chapter022.mapper"
                     targetProject="F:/db2javaGenerate/java">
    <!-- enableSubPackages:是否让schema作为包的后缀 -->
    <property name="enableSubPackages" value="true" />
</javaClientGenerator>   
        
<table schema="mysql" tableName="user" domainObjectName="User"
           enableCountByExample="true"
           enableUpdateByExample="true" enableDeleteByExample="true"
           enableSelectByExample="true" selectByExampleQueryId="true" >
</table>
```

## 2. spring boot 注入
* application.yml  
```
spring:
    datasource:
        driver-class-name: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost:3306/test?allowMultiQueries=true&zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8&useSSL=false
        username: root
        password:
```
* MybatisConfig.java 主要点
```
@Configuration
@EnableTransactionManagement
@MapperScan("com.joe.chapter022.mapper")
public class MybatisConfig implements TransactionManagementConfigurer {

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //resources目录下生成的mapper文件夹
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            bean.setConfigLocation(resolver.getResource("classpath:mybatis.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
```
* mybatis.xml 主要点
```
<configuration>
    <settings>
        <setting name="cacheEnabled" value="true"/>
        <setting name="lazyLoadingEnabled" value="true"/>
        <setting name="multipleResultSetsEnabled" value="true"/>
        <setting name="useColumnLabel" value="true"/>
        <setting name="useGeneratedKeys" value="true"/>
        <setting name="defaultExecutorType" value="SIMPLE"/>
        <setting name="defaultStatementTimeout" value="25000"/>
    </settings>

    <plugins>
        <!-- com.github.pagehelper为PageHelper类所在包名 -->
        <plugin interceptor="com.github.pagehelper.PageHelper">
            <!-- 4.0.0以后版本可以不设置该参数 -->
            <property name="dialect" value="mysql"/>
            .......
```
## 3 单元测试
```
	@Test
	public void test() {
		User user = new User();
		user.setName("张三01");
		user.setAge(28);
		Assert.assertEquals(1,userMapper.insert(user));
	}
```  

## 4 增加sql注解 增删改查
```
    @Select("select * from user where name = #{name}")
    User getUserByAnotation(@Param("name") String name);

    @Insert("insert into user(name,age) values(#{name},#{age})")
    int insertUserByAnotation(User user);

    @Update("update user set name= #{name}, age = #{age} where name = #{name}")
    void updateUserByAnotation(User user);

    @Delete("delete from user where name = #{name}")
    void deleteUserByAnotation(String name);
```  

## 5 批量操作 insert
* UserMapper.java
```
    void insertUsersBatch(@Param("users") List<User> userList);
```
* UserMapper.xml
```
     <!-- 批量插入用户sql -->
     <insert id="insertUsersBatch">
       insert into user (name,age)
       VALUES
       <foreach collection="users" item="row" separator="," >
         (#{row.name},#{row.age})
       </foreach>
     </insert>
```

## 6 自定义sql注解  
* UserMapper.java
```
    void updateUsers(@Param("data") User user);
```
* UserMapper.xml
```
 <!-- 更新年龄小于30的用户 -->
  <update id="updateUsers">
    update user set name= #{data.name},
      age = #{data.age}
    where age &lt; 30;
  </update>
```

## 7 分页 pagehelper  
* pom中引入依赖
```
    <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper</artifactId>
        <version>4.1.4</version>
    </dependency>
```
* resources/mybatis.xml
```
<plugins>
    <!-- com.github.pagehelper为PageHelper类所在包名 -->
    <plugin interceptor="com.github.pagehelper.PageHelper">
        <!-- 4.0.0以后版本可以不设置该参数 -->
        <property name="dialect" value="mysql"/>
        <!-- 该参数默认为false -->
        <!-- 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用 -->
        <!-- 和startPage中的pageNum效果一样-->
        <property name="offsetAsPageNum" value="true"/>
        <!-- 该参数默认为false -->
        <!-- 设置为true时，使用RowBounds分页会进行count查询 -->
        <property name="rowBoundsWithCount" value="true"/>
        <!-- 设置为true时，如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果 -->
        <!-- （相当于没有执行分页查询，但是返回结果仍然是Page类型）-->
        <property name="pageSizeZero" value="true"/>
        <!-- 3.3.0版本可用 - 分页参数合理化，默认false禁用 -->
        <!-- 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页 -->
        <!-- 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据 -->
        <property name="reasonable" value="false"/>
        <!-- 3.5.0版本可用 - 为了支持startPage(Object params)方法 -->
        <!-- 增加了一个`params`参数来配置参数映射，用于从Map或ServletRequest中取值 -->
        <!-- 可以配置pageNum,pageSize,count,pageSizeZero,reasonable,orderBy,不配置映射的用默认值 -->
        <!-- 不理解该含义的前提下，不要随便复制该配置 -->
        <property name="params" value="pageNum=pageHelperStart;pageSize=pageHelperRows;"/>
        <!-- 支持通过Mapper接口参数来传递分页参数 -->
        <property name="supportMethodsArguments" value="false"/>
        <!-- always总是返回PageInfo类型,check检查返回类型是否为PageInfo,none返回Page -->
        <property name="returnPageInfo" value="none"/>

    </plugin>
</plugins>  
```
    
* 测试类
```
@Test
public void testPageInfo(){
        int start = 1; //开始条数
        int length = 5; //每页条数
        int page = start / length + 1; //查询的是 第几页

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        PageHelper.startPage(page,length); //分页查询

        List<User> userList = userMapper.selectByExample(example);

        PageInfo info = new PageInfo<>(userList);
        System.out.print(info);

}   
```	 