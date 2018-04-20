package com.tb.practice.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tb.practice.entity.Event;
import com.tb.practice.entity.Users;
import com.tb.practice.repository.UserRepository;
import com.tb.practice.service.EventService;
import com.tb.practice.service.UserService;

@RestController
public class BookingTicketController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EventService eventService;
	
	
	@RequestMapping(value="/event/{eid}/user/{uid}",method=RequestMethod.POST)
	public Users bookTicket(@PathVariable("eid") int eventId, @PathVariable("uid") int userId){
			Event event=eventService.findEvent(eventId);
			event.setSeats(event.getSeats()-1);
			
			Users users=userRepo.getOne(userId);
			List<Event> li=users.getEvent();
			li.add(eventService.findEvent(eventId));
			users.setEvent(li);
			//users.getEvent().add(eventService.findEvent(eventId));
			
		//return	userService.updateUser(users);
		
			return userRepo.save(users);
	}
	
	
	@RequestMapping(value="delete/event/{eid}/user/{uid}",method=RequestMethod.POST)
	public Users deleteTicket(@PathVariable("eid") int eventId, @PathVariable("uid") int userId){
		
		Users users=userService.findUser(userId);
		Event event=eventService.findEvent(eventId);
		
		users.getEvent().remove(event);
		event.setSeats(event.getSeats()+1);
		
		
		
		return userRepo.save(users);
			
	}
	

}
