package co.simplon.itp3.supportrequest.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.simplon.itp3.supportrequest.dtos.CreateSupportRequestDto;
import co.simplon.itp3.supportrequest.dtos.MailSenderDto;

@Service
public class EmailService {

    private final RestTemplate restTemplate;

    private final String emailSenderUrl = "http://localhost:8083/send-mail";

    public EmailService(RestTemplate restTemplate) {
	this.restTemplate = restTemplate;
    }

    public String mailSender(
	    CreateSupportRequestDto inputs) {

	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);

	MailSenderDto mailSenderDto = new MailSenderDto();
	mailSenderDto
		.setSender("no-reply.dev@readresolve.io");
	mailSenderDto.setBody(inputs.getDescription());
	mailSenderDto.setSubject(inputs.getSubject());
	mailSenderDto
		.setPrimaryRecipient(inputs.getEmail());

	HttpEntity<MailSenderDto> requestEntity = new HttpEntity<MailSenderDto>(
		mailSenderDto, headers);

	ResponseEntity<String> responseEntity = restTemplate
		.postForEntity(emailSenderUrl,
			requestEntity, String.class);

	String response = responseEntity.getBody();

	return response;

    }

}
