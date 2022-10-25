package dev.bigstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.bigstack.components.DIServiceComponent;

@RestController
public class TestController {

	@Autowired
	DIServiceComponent diServiceComponent;
	  
	@GetMapping("/")  
    public String control() {
        return diServiceComponent.serveMessage();
    }

}
