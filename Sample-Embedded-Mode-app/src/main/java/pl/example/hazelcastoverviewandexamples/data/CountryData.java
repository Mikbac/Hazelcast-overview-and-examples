/*
 * Created by MikBac on 7.10.2023
 */

package pl.example.hazelcastoverviewandexamples.data;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by MikBac on 07.10.2023
 */

@Data
@Builder
public class CountryData implements Serializable {

    private String code;
    private String name;

}
