package pl.example.hazelcastoverviewandexamples.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.example.hazelcastoverviewandexamples.model.CountryModel;

/**
 * Created by MikBac on 07.10.2023
 */

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, Long> {

    Page<CountryModel> findAll(Pageable pageable);

}
