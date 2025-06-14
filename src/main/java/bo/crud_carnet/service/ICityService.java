package bo.crud_carnet.service;

import bo.crud_carnet.domain.City;
import bo.crud_carnet.exception.CityNotFoundException;


import java.util.List;

public interface ICityService {

    public City createCity(City city) throws CityNotFoundException;

    public City getByCityId(Long id) throws CityNotFoundException;

    public City getByCityName(String name) throws CityNotFoundException;

    public List<City> getAllCities() throws CityNotFoundException;

    public City updateCity(City city) throws CityNotFoundException;

    public void deleteByCityId(Long id) throws CityNotFoundException;
}
