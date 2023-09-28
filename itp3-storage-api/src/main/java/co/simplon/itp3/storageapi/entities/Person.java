package co.simplon.itp3.storageapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person extends AbstractEntity {

    @Column(name = "name")
    private String name;

    public Person() {

    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "{name=" + name + "}";
    }

}
