package co.simplon.itp3.storageapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.itp3.storageapi.dtos.PersonView;
import co.simplon.itp3.storageapi.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repo;

    public PersonServiceImpl(PersonRepository repo) {
	this.repo = repo;
    }

    @Override
    public List<PersonView> getAllPerson() {
	return repo.findAllProjectedBy();
    }

}