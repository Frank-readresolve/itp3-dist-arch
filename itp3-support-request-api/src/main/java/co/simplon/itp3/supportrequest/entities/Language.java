package co.simplon.itp3.supportrequest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Language extends AbstractEntity {

    @Column(name = "name")
    private String name;

    public Language() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
