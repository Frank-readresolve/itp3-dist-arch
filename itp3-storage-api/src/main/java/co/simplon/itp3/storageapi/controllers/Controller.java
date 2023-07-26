package co.simplon.itp3.storageapi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class Controller {

    @Value("${supportrequest-api.env}")
    private String profile;

    @Value("${supportrequest-api.commun}")
    private String commun;

    @GetMapping("/profile")
    public String getProfile() {
	String result = profile + " " + commun;
	return result;
    }

}