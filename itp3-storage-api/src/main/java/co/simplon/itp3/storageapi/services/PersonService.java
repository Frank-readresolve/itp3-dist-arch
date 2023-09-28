package co.simplon.itp3.storageapi.services;

import java.util.List;

import co.simplon.itp3.storageapi.dtos.PersonView;

public interface PersonService {

    List<PersonView> getAllPerson();
}
