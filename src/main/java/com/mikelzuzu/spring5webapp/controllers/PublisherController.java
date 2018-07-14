package com.mikelzuzu.spring5webapp.controllers;

import com.mikelzuzu.spring5webapp.repository.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/publishers")
    public String gettPublishers(Model model) {
        model.addAttribute("publishers", publisherRepository.findAll());

        return "publishers";
    }
 }
