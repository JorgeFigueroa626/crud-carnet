package bo.crud_carnet.exception;


import jakarta.persistence.EntityNotFoundException;

public class CityNotFoundException extends EntityNotFoundException {

    public CityNotFoundException(String message) {
        super(message);
    }

    public CityNotFoundException(Long cityId) {
        this(String.format("No se pudo encontrar la Ciudad con id: %d", cityId));
    }
}
