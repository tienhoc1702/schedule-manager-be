package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.TeachFor;
@Repository
public interface TeachForDAO extends JpaRepository<TeachFor, Integer> {

}
