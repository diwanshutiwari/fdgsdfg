package com.tb.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tb.practice.entity.Event;
import com.tb.practice.entity.Users;
import com.tb.practice.repository.EventRepository;
import com.tb.practice.repository.UserRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<Event> allEvents() {

		return eventRepository.findAll();
	}

	public Event createEvent(Event event) {

		return eventRepository.save(event);
	}

	public Event updateEvent(Event event) {

		Event updateEvent = eventRepository.getOne(event.getId());
		updateEvent.setActive(event.isActive());
		updateEvent.setDescription(event.getDescription());
		updateEvent.setEndDate(event.getEndDate());
		updateEvent.setName(event.getName());
		updateEvent.setStartDate(event.getStartDate());
		//updateEvent.setUser(event.getUser());

		return eventRepository.save(updateEvent);
	}

	public Event findEvent(int id) {

		Optional<Event> op = eventRepository.findById(id);

		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public void deletEvent(int id) {

		eventRepository.deleteById(id);
	}
	
	
	public List<Users> findEventByUsers(int id){
		Event event=eventRepository.getOne(id);
		
		return userRepository.findByEvent(event);
		
	}

}
