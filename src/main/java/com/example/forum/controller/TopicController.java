package com.example.forum.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.forum.model.Topic;
import com.example.forum.model.User;
import com.example.forum.repository.TopicRepository;
import com.example.forum.service.ClientService;

@Controller
public class TopicController {
	
	@Autowired
	ClientService clientService;

	@Autowired
	TopicRepository topicRepository;
	
	
	@RequestMapping(value="/addTopic", method=RequestMethod.GET)
	public String readersBooks(Model model) {
		model.addAttribute("newTopic", new Topic());
		return "addTopic";
	}
	
	@RequestMapping(value="/addTopic", method=RequestMethod.POST)
	public String addToReadingList( Topic newTopic) {
		newTopic.setDateOfCreation(new Date());
		User user = new User();
		user.setUserId(1);
		newTopic.setUser(user);
		topicRepository.save(newTopic);
		return "redirect:/addTopic";
	}
}