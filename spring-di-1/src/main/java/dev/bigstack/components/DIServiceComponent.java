package dev.bigstack.components;

import org.springframework.beans.factory.annotation.Autowired;


public class DIServiceComponent {
    
    @Autowired
    DIComponent diComponent;
    
    public String serveMessage() {
    	diComponent.getMessage();
        return "success";
    }

}
