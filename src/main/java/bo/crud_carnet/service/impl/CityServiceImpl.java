package bo.crud_carnet.service.impl;

import bo.crud_carnet.domain.City;
import bo.crud_carnet.exception.CityNotFoundException;
import bo.crud_carnet.exception.CountryNotFoundException;
import bo.crud_carnet.repository.ICityRepository;
import bo.crud_carnet.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private ICityRepository cityRepository;


    @Override
    public City createCity(City city) throws CityNotFoundException {
        return cityRepository.save(city);
    }

    @Override
    public City getByCityId(Long id) throws CityNotFoundException {
        return cityRepository.findById(id).orElseThrow(()-> new CityNotFoundException(id));
    }

    @Override
    public City getByCityName(String name) throws CityNotFoundException {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> getAllCities() throws CityNotFoundException{
        List<City> cities = cityRepository.findAll();
        return cities;
    }

    /*
    @Override
    public City updateCity(Long cityId, City city) {
        City citId = cityRepository.findById(cityId).get();
        if (citId.getId() != null) {
            citId.setId(city.getId());
            citId.setName(city.getName());
            citId.setCountry(city.getCountry());
        }
        return cityRepository.save(citId);
    }

     */

    @Override
    public City updateCity(City city) throws CountryNotFoundException {
        return cityRepository.save(city);
    }

    @Override
    public void deleteByCityId(Long id) throws CityNotFoundException{
        City city = cityRepository.findById(id).orElseThrow(()-> new CountryNotFoundException(id));
        cityRepository.deleteById(city.getId());
    }
}
