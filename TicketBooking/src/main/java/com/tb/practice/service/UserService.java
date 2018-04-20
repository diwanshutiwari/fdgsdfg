package com.tb.practice.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tb.practice.entity.Event;
import com.tb.practice.entity.Users;
import com.tb.practice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Users> allUsers(){
		
		return userRepository.findAll();
	}
	
	public Users createUser(Users user) {

		return userRepository.save(user);
	}

	public Users updateUser(Users user) {
		System.out.println("============================================>>>>>>>>>>>>>>>>>1111");
		Users updateUser = userRepository.getOne(user.getId());
		updateUser.setEmail(user.getEmail());
		/*Set<Event> events=user.getEvent();
		updateUser.getEvent().addAll(events);*/
		System.out.println("============================================>>>>>>>>>>>>>>>>>2222");
		//updateUser.setEvent(user.getEvent());
		
		updateUser.setEvent(user.getEvent());
		updateUser.setName(user.getName());
		updateUser.setPassword(user.getPassword());
		System.out.println("============================================>>>>>>>>>>>>>>>>>3333");
		return userRepository.save(updateUser);
	}

	public Users findUser(int id) {

		Optional<Users> op = userRepository.findById(id);

		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public void deletUser(int id) {

		userRepository.deleteById(id);
	}


}
