package co.simplon.itp3.supportrequest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.itp3.supportrequest.dtos.LanguageDTO;
import co.simplon.itp3.supportrequest.entities.Language;

public interface LanguageRepository
	extends JpaRepository<Language, Long> {
    List<LanguageDTO> findAllProjectedBy();

}
