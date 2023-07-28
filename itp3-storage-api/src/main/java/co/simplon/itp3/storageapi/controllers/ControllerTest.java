package co.simplon.itp3.storageapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ControllerTest {

    private String profil = "Ca marche !";

    @GetMapping("/profile")
    public String getProfile() {
	return profil;
    }

    @PostMapping("/profile")
    public void postProfile(@RequestBody String profile) {
	System.out.println(profile);
    }

}