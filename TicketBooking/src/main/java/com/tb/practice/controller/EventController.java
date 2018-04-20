package com.tb.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tb.practice.entity.Event;
import com.tb.practice.entity.Users;
import com.tb.practice.service.EventService;

@RestController
public class EventController {
	
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/allEvents")
	public List<Event> showAllEvents(){
		
		return eventService.allEvents();
	}
	
	@GetMapping("/event/id/{id}")
	public Event findEvent(@PathVariable("id") int id){
		
		return eventService.findEvent(id);
	}
	
	@GetMapping("/event/delete/{id}")
	public void deleteEvent(@PathVariable("id") int id){
		
		eventService.deletEvent(id);
			
	}
	
	@RequestMapping(value="/event/add", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Event saveEvent(@RequestBody Event event){
		
		return eventService.createEvent(event);
		
	}
	
	@RequestMapping(value="/event/{id}" , method=RequestMethod.GET)
	public List<Users> getUserByEvent(@PathVariable("id") int id){
		
		return eventService.findEventByUsers(id);
	}

}
