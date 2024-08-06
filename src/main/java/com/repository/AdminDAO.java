package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Admin;
@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {

}
