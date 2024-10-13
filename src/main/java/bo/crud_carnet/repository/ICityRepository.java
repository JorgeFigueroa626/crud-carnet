package bo.crud_carnet.repository;

import bo.crud_carnet.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {

    public City findByName(String name);
}
