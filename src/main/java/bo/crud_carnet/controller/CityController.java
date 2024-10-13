package bo.crud_carnet.controller;

import bo.crud_carnet.domain.City;
import bo.crud_carnet.domain.Country;
import bo.crud_carnet.exception.CityNotFoundException;
import bo.crud_carnet.exception.CountryNotFoundException;
import bo.crud_carnet.service.ICityService;
import bo.crud_carnet.shared.JsonResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @PostMapping
    public JsonResult createCity(@Valid @RequestBody City city) throws CityNotFoundException {
        cityService.createCity(city);
        return new JsonResult(true, null, "Ciudad registrado con exitosamente");
    }

    @GetMapping("/{cityId}")
    public City getByCityId(@Valid @PathVariable Long cityId) throws CityNotFoundException{
        return cityService.getByCityId(cityId);
    }


    @GetMapping("/search/{name}")
    public City findByCityName(@PathVariable String name) throws CityNotFoundException{
        return cityService.getByCityName(name);
    }


    @GetMapping
    public ResponseEntity<?> getAllCities() throws CityNotFoundException{
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @PutMapping
    public JsonResult updateByCityId(@Valid @RequestBody City city) throws CityNotFoundException{
        City response = cityService.updateCity(city);
        return new JsonResult(true, response, "Ciudad se actualizo correctamente");
    }

    @DeleteMapping("/{cityId}")
    public JsonResult  deleteByIdCity(@PathVariable Long cityId) throws CityNotFoundException{
        cityService.deleteByCityId(cityId);
        return new JsonResult(true, null, "Ciudad se elimino exitosamente.");
    }
}
