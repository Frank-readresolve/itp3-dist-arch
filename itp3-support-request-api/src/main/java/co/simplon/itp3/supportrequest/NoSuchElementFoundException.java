package co.simplon.itp3.supportrequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException
	extends ResponseStatusException {

    public NoSuchElementFoundException(String message) {
	super(HttpStatus.NOT_FOUND, message);
    }

}
