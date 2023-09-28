package co.simplon.itp3.supportrequest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.supportrequest.dtos.LanguageDTO;
import co.simplon.itp3.supportrequest.services.LanguageServiceImpl;

@RestController
@RequestMapping("/languages")
public class LanguageControlleur {

    private LanguageServiceImpl service;

    public LanguageControlleur(
	    LanguageServiceImpl service) {
	this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LanguageDTO> getAllLanguages() {

	return service.getAllLanguages();
    }

}
