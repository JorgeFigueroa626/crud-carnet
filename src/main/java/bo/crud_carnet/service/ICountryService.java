package bo.crud_carnet.service;

import bo.crud_carnet.domain.Country;
import bo.crud_carnet.exception.CountryNotFoundException;
import bo.crud_carnet.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ICountryService {

    public Country createCountry(Country country) throws CountryNotFoundException;

    public List<Country> findAllCountry() throws CountryNotFoundException;

    public Country findByCountryId(Long id) throws CountryNotFoundException;

    public Country getByCountryName(String name) throws CountryNotFoundException;

    public Country updateCountry(Country country) throws CountryNotFoundException;

    public void deleteByCountryId(Long id) throws CountryNotFoundException;

}
