package com.tb.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tb.practice.entity.Event;
import com.tb.practice.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	List<Users> findByEvent(Event event);
	
}
