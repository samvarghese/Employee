package com.myspent.myspent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myspent.myspent.model.Departement;
import com.myspent.myspent.model.User;

public interface DepartementDao extends JpaRepository<Departement, Integer> {

}
