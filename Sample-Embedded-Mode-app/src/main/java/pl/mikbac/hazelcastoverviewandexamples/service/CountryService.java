package pl.mikbac.hazelcastoverviewandexamples.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.mikbac.hazelcastoverviewandexamples.data.CountryData;
import pl.mikbac.hazelcastoverviewandexamples.repository.CountryRepository;

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

    @Cacheable("countryDetailsCache")
    public CountryData getCountryByCode(final String code) {
        return countryRepository.findCountryModelByCode(code)
                .map(c -> CountryData.builder()
                        .code(c.getCode())
                        .name(c.getName())
                        .build())
                .orElse(null);
    }

}
