package co.simplon.itp3.storageapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.itp3.storageapi.dtos.PersonView;
import co.simplon.itp3.storageapi.entities.Person;

public interface PersonRepository
	extends JpaRepository<Person, Long> {

    List<PersonView> findAllProjectedBy();
}
