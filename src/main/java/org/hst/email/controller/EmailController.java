package org.hst.email.controller;

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
	private ResponseEntity<?> sendEmail(@RequestBody String content) {
		System.out.println("Sucess: " + content);
		return ResponseEntity.ok(content);
	}
}
