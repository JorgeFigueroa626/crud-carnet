package bo.crud_carnet.service.impl;

import bo.crud_carnet.domain.Country;
import bo.crud_carnet.exception.CountryNotFoundException;
import bo.crud_carnet.exception.UserNotFoundException;
import bo.crud_carnet.repository.ICountryRepository;
import bo.crud_carnet.service.ICountryService;
import bo.crud_carnet.shared.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public Country createCountry(Country country) throws CountryNotFoundException{
        return countryRepository.save(country);
    }

    @Override
    public List<Country> findAllCountry() throws CountryNotFoundException {
        List<Country> countries = countryRepository.findAll();
        return countries;
    }

    @Override
    public Country findByCountryId(Long id) throws CountryNotFoundException {
        return countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
    }

    @Override
    public Country getByCountryName(String name) throws CountryNotFoundException {
        return countryRepository.findByName(name);
    }

    @Override
    public Country updateCountry(Country country) throws CountryNotFoundException{
        return countryRepository.save(country);
    }

    @Override
    public void deleteByCountryId(Long id) throws CountryNotFoundException{
        Country countryId = countryRepository.findById(id).orElseThrow(()-> new CountryNotFoundException(id));
        countryRepository.deleteById(countryId.getId());
    }
}
