package co.simplon.itp3.storageapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.storageapi.dtos.PersonView;
import co.simplon.itp3.storageapi.services.PersonServiceImpl;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonServiceImpl service;

    public PersonController(PersonServiceImpl service) {
	this.service = service;
    }

    @GetMapping
    public List<PersonView> getAllPerson() {
	return service.getAllPerson();

    }

}
