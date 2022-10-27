package dev.bigstack.springboot.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.bigstack.springboot.config.CustomFeignClientConfiguration;


@FeignClient(name = "student-rest-service", configuration = CustomFeignClientConfiguration.class)
public interface StudentRestService{
	 @RequestMapping(method = RequestMethod.GET, value = "/api/v1/students/{studentId}/marks")
	 ResponseEntity<?> retrieveMarksForStudent(@PathVariable("studentId") String studentId);
	 
//	 @RequestMapping(method = RequestMethod.GET, value = "/api/v1/rest/{studentId}/marks")
//	 ResponseEntity<?> retrieveCourses(@PathVariable("studentId") String studentId);
	 
}