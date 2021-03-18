package org.hst.email.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("localhost://43002")
@RestController
@RequestMapping("/email")
public class EmailController {

	@PostMapping("/send")
	private void sendEmail(@RequestBody Map<String, String> body) {
		System.out.println("Sucess: " + body.toString());
		
		//return ResponseEntity.status(HttpStatus.OK).body("Success");
	}
}
