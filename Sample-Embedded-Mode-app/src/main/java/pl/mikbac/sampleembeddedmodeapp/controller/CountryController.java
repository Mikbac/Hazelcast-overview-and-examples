package pl.mikbac.sampleembeddedmodeapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mikbac.sampleembeddedmodeapp.data.CountryData;
import pl.mikbac.sampleembeddedmodeapp.service.CountryService;

import java.util.List;
import java.util.Objects;

/**
 * Created by MikBac on 07.10.2023
 */

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;
    private final CacheManager cacheManager;

    @GetMapping("/v1/country")
    public ResponseEntity<List<CountryData>> getAllCountries(@RequestParam(defaultValue = "0") final int pageNumber,
                                                             @RequestParam(defaultValue = "5") final int pageSize) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(countryService.getAllCountries(pageNumber, pageSize));
    }

    @GetMapping("/v1/country/{code}")
    public ResponseEntity<CountryData> getCountryByCode(@PathVariable final String code) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(countryService.getCountryByCode(code));
    }

    @GetMapping("/v1/country/cache/{code}")
    public ResponseEntity<CountryData> getCountryByCodeFromCache(@PathVariable final String code) {
        final CountryData response = Objects.requireNonNull(cacheManager.getCache("countryDetailsCache"))
                .get(code, CountryData.class);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

}
