package co.simplon.itp3.storageapi.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

// Package visible class (only this package)
@MappedSuperclass
abstract class AbstractEntity {
    // Package (default) visible = no keyword
    // (vs public, private, protected)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    AbstractEntity() { // Package (default) visible
	// Required no-arg constructor
    }

    public Long getId() {
	return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
	// Prevents from accidental assignment (set by DB)
	this.id = id;
    }
}
