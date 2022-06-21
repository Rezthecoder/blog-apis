package com.suresh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.blog.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
