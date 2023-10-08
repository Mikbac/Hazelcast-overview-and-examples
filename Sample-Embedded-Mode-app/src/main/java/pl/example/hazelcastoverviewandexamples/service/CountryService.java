package pl.example.hazelcastoverviewandexamples.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.example.hazelcastoverviewandexamples.data.CountryData;
import pl.example.hazelcastoverviewandexamples.repository.CountryRepository;

import java.util.List;

/**
 * Created by MikBac on 07.10.2023
 */

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    @Cacheable("countriesCache")
    public List<CountryData> getAllCountries(final int pageNumber, final int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return countryRepository.findAll(pageable)
                .map(c -> CountryData.builder()
                        .code(c.getCode())
                        .name(c.getName())
                        .build())
                .toList();
    }

}
