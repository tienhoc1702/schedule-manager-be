package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.NoteType;
@Repository
public interface NoteTypeDAO extends JpaRepository<NoteType, Integer> {

}
