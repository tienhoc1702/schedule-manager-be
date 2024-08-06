package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Room;
@Repository
public interface RoomDAO extends JpaRepository<Room, Integer>{

}
