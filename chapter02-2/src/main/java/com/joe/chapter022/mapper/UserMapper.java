package com.joe.chapter022.mapper;

import com.joe.chapter022.domain.User;
import com.joe.chapter022.domain.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    /**
     *
     * @mbggenerated 2017-12-29
     */
    int countByExample(UserExample example);

    /**
     *
     * @mbggenerated 2017-12-29
     */
    int deleteByExample(UserExample example);

    /**
     *
     * @mbggenerated 2017-12-29
     */
    int insert(User record);

    /**
     *
     * @mbggenerated 2017-12-29
     */
    int insertSelective(User record);

    /**
     *
     * @mbggenerated 2017-12-29
     */
    List<User> selectByExample(UserExample example);

    /**
     *
     * @mbggenerated 2017-12-29
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbggenerated 2017-12-29
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    //自定义sql注解

    @Select("select * from user where name = #{name}")
    User getUserByAnotation(@Param("name") String name);

    @Insert("insert into user(name,age) values(#{name},#{age})")
    int insertUserByAnotation(User user);

    @Update("update user set name= #{name}, age = #{age} where name = #{name}")
    void updateUserByAnotation(User user);

    @Delete("delete from user where name = #{name}")
    void deleteUserByAnotation(String name);

    /**
     * 批量insert
     * @param userList
     */
    void insertUsersBatch(@Param("users") List<User> userList);

    void updateUsers(@Param("data") User user);

}