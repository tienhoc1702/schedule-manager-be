package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.ApplyFor;
@Repository

public interface ApplyForDAO extends JpaRepository<ApplyFor, Integer> {

}
