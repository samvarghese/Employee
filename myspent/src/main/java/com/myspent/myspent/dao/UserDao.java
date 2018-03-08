package com.myspent.myspent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspent.myspent.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
  User findByUserNameAndPassword(String name,String password);
}
