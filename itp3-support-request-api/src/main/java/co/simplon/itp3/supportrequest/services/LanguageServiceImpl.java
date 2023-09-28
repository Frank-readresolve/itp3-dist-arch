package co.simplon.itp3.supportrequest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.itp3.supportrequest.dtos.LanguageDTO;
import co.simplon.itp3.supportrequest.repositories.LanguageRepository;

@Service
public class LanguageServiceImpl
	implements LanguageService {

    private final LanguageRepository repo;

    public LanguageServiceImpl(LanguageRepository repo) {
	this.repo = repo;
    }

    @Override
    public List<LanguageDTO> getAllLanguages() {

	return repo.findAllProjectedBy();
    }

}
