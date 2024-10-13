package bo.crud_carnet.repository;

import bo.crud_carnet.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Long> {

    Country findByName(String name);
}
