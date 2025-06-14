package bo.crud_carnet.exception;

import bo.crud_carnet.shared.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JsonResult> handleGenericException(Exception ex) {
        JsonResult response = new JsonResult(false, null, "Error interno del servidor: " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<JsonResult> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        JsonResult response = new JsonResult(false, null, errorMessage);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<JsonResult> handleCountryNotFoundException(CountryNotFoundException ex) {
        JsonResult response = new JsonResult(false, null, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<JsonResult> handleCityNotFoundException(CityNotFoundException ex) {
        JsonResult response = new JsonResult(false, null, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<JsonResult> handleUserNotFoundException(UserNotFoundException ex) {
        JsonResult response = new JsonResult(false, null, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}