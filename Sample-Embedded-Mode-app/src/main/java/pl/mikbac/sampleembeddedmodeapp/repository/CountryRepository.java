package pl.mikbac.sampleembeddedmodeapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mikbac.sampleembeddedmodeapp.model.CountryModel;

import java.util.Optional;

/**
 * Created by MikBac on 07.10.2023
 */

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, Long> {

    Page<CountryModel> findAll(Pageable pageable);

    Optional<CountryModel> findCountryModelByCode(String code);

}
