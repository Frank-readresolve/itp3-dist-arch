package co.simplon.itp3.storageapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Itp3StorageApiApplication {

    public static void main(String[] args) {
	SpringApplication
		.run(Itp3StorageApiApplication.class, args);
	System.out.println("environement de " + args[0]);
    }

}
