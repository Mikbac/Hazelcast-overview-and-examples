package pl.mikbac.sampleembeddedmodeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by MikBac on 07.10.2023
 */

@SpringBootApplication
@EnableCaching
public class SampleEmbeddedModeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleEmbeddedModeAppApplication.class, args);
    }

}
