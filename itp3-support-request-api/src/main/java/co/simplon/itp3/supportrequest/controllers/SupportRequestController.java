package co.simplon.itp3.supportrequest.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.supportrequest.dtos.CreateSupportRequestDto;
import co.simplon.itp3.supportrequest.services.EmailService;

@RestController
@RequestMapping("/support-request")
public class SupportRequestController {

    private final EmailService emailService;

    public SupportRequestController(
	    EmailService emailService) {
	this.emailService = emailService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @RequestBody @Valid CreateSupportRequestDto inputs) {

	emailService.mailSender(inputs);

    }

}
