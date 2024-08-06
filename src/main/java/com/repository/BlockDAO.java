package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Block;
@Repository
public interface BlockDAO extends JpaRepository<Block, Integer> {

}
