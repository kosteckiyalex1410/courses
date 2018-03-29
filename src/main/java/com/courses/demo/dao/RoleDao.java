package com.courses.demo.dao;


import com.courses.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long>{
}
