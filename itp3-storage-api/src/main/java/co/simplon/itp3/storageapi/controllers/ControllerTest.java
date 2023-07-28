package co.simplon.itp3.storageapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class Controller {

    private String profil = "Ca marche !";

    @GetMapping("/profile")
    public String getprofile() {
	return profil;
    }

}