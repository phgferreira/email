package org.hst.email.controller;

import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
	private ResponseEntity<String> sendEmail(@RequestBody Map<String, String> body) {
		// Propriedades do envio de e-mail (TLS Protocol)
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.office365.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");

		// Autenticação de e-mail
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("intranet@hst.org.br", "#st477*rj");
			}
		};

		try {
			// Consolidação e preparo do e-mail
			Session sessao = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(sessao);
			msg.setFrom(new InternetAddress("intranet@hst.org.br"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(body.get("recipient")));
			//msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse("paulo.ferreira@hst.org.br"));
			msg.setSubject(body.get("title"));
			msg.setText(body.get("content"), "utf-8", "html");

			// Envia e-mail
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
