package co.simplon.itp3.storageapi.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.storageapi.dtos.Storage;
import co.simplon.itp3.storageapi.services.StorageServiceImpl;

@RestController
@RequestMapping("/store-file")
public class ControllerStorage {

    private StorageServiceImpl service;

    public ControllerStorage(StorageServiceImpl service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void upload(
	    @ModelAttribute @Valid Storage inputs) {
	service.mailSender(inputs);
    }

}
