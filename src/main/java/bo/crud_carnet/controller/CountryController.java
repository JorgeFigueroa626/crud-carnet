package bo.crud_carnet.controller;

import bo.crud_carnet.domain.Country;
import bo.crud_carnet.exception.CountryNotFoundException;
import bo.crud_carnet.service.ICountryService;
import bo.crud_carnet.shared.JsonResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private ICountryService countryService;

    @PostMapping
    public JsonResult createCountry(@Valid @RequestBody Country country) throws CountryNotFoundException{
            countryService.createCountry(country);
            return new JsonResult(true, null, "País creado exitosamente.");
    }

    @GetMapping("/{countryId}")
    public Country getByCountryId(@Valid @PathVariable Long countryId)throws CountryNotFoundException {
        return countryService.findByCountryId(countryId);
    }

    @GetMapping("/search/{name}")
    public Country findByCountryName(@PathVariable String name)throws CountryNotFoundException {
        return countryService.getByCountryName(name);
    }

    @GetMapping
    public ResponseEntity<?> findAllCountry() throws CountryNotFoundException{
        List<Country> countries = countryService.findAllCountry();
        return ResponseEntity.ok(countries);
    }

    @PutMapping
    public JsonResult updateCountry(@Valid @RequestBody Country country) throws CountryNotFoundException{
        countryService.updateCountry(country);
        return new JsonResult(true, null, "Pais se actualizo exitosamente");
    }

    @DeleteMapping("/{countryId}")
    public JsonResult deleteByCountry(@Valid @PathVariable Long countryId)throws CountryNotFoundException{
        countryService.deleteByCountryId(countryId);
        return new JsonResult(true, null, "Pais se elimino correctamente.");
    }

}
