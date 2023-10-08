package pl.example.hazelcastoverviewandexamples.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.example.hazelcastoverviewandexamples.data.CountryData;
import pl.example.hazelcastoverviewandexamples.service.CountryService;

import java.util.List;

/**
 * Created by MikBac on 07.10.2023
 */

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/v1/country")
    public ResponseEntity<List<CountryData>> getAllCountries(@RequestParam(defaultValue = "0") final int pageNumber,
                                                             @RequestParam(defaultValue = "5") final int pageSize) {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getAllCountries(pageNumber, pageSize));
    }

}
