package co.simplon.itp3.supportrequest.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.supportrequest.dtos.CreateSupportRequestDto;

@RestController
@RequestMapping("/support-request")
public class SupportRequestController {
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @RequestBody @Valid CreateSupportRequestDto inputs) {

	CreateSupportRequestDto supportRequestDto = new CreateSupportRequestDto();
	supportRequestDto.setEmail(inputs.getEmail());
	supportRequestDto.setSubject(inputs.getSubject());
	supportRequestDto
		.setDescription(inputs.getDescription());
	System.out.println(supportRequestDto);

    }

}
