package com.suresh.blog;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.suresh.blog.entity.User;
import com.suresh.blog.repository.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest() {
		String name = this.userRepo.getClass().getName();
		String packageName = this.userRepo.getClass().getPackageName();
		List<User> findAll = this.userRepo.findAll();
		System.out.println(name);
		System.out.println(packageName);
		System.out.println(findAll);

	}

}
