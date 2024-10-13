package bo.crud_carnet.exception;

import jakarta.persistence.EntityNotFoundException;


public class CountryNotFoundException extends EntityNotFoundException {

    public CountryNotFoundException(String message) {
        super(message);
    }

    public CountryNotFoundException(Long countryId) {
        this(String.format("No se pudo encontrar el Pais con id: %d", countryId));
    }

}
