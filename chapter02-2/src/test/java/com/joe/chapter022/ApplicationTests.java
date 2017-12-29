package com.joe.chapter022;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.joe.chapter022.domain.User;
import com.joe.chapter022.domain.UserExample;
import com.joe.chapter022.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private UserMapper userMapper;


	@Test
	public void test() {
		User user = new User();
		user.setName("张三01");
		user.setAge(28);
		Assert.assertEquals(1,userMapper.insert(user));
	}

	@Test
	public void testAnotation() {
		User user = new User();
		user.setName("注解01");
		user.setAge(18);
		Assert.assertEquals(1,userMapper.insertUserByAnotation(user));
		Assert.assertEquals(Integer.valueOf(18),userMapper.getUserByAnotation(user.getName()).getAge());

		user.setName("注解01");
		user.setAge(28);
		userMapper.updateUserByAnotation(user);

		user.setName("注解02");
		user.setAge(38);
		userMapper.insertUserByAnotation(user);
		userMapper.deleteUserByAnotation(user.getName());
	}

	@Test
	public void testBatch(){
		User user = new User();
		user.setName("tom1");
		user.setAge(21);
		User user2 = new User();
		user2.setName("tom2");
		user2.setAge(22);
		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user2);

		userMapper.insertUsersBatch(users);
	}

	@Test
	public void testUpdateSql(){
		User user = new User();
		user.setName("tom111");
		user.setAge(211);

		userMapper.updateUsers(user);
	}

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

}
