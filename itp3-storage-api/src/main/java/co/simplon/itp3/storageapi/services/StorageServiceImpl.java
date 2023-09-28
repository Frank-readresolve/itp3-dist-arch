package co.simplon.itp3.storageapi.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.simplon.itp3.storageapi.dtos.Storage;

@Service
public class StorageServiceImpl implements StorageService {

    private RestTemplate restTemplate;

    private final String fileStorageUrl = "http://localhost:8083/anonymous-files";

    public StorageServiceImpl(RestTemplate restTemplate) {
	this.restTemplate = restTemplate;
    }

    @Override
    public String mailSender(Storage inputs) {

	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);

	Storage storage = new Storage();
	storage.setFile(inputs.getFile());

	HttpEntity<Storage> requestEntity = new HttpEntity<Storage>(
		storage, headers);

	ResponseEntity<String> responseEntity = restTemplate
		.postForEntity(fileStorageUrl,
			requestEntity, String.class);

	String response = responseEntity.getBody();

	return response;

    }

}