package com.myspent.myspent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspent.myspent.model.Roles;
import com.myspent.myspent.model.User;

public interface RolesDao extends JpaRepository<Roles, Integer> {

}
