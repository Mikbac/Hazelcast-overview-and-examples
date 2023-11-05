/*
 * Created by MikBac on 7.10.2023
 */

package pl.mikbac.sampleembeddedmodeapp.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by MikBac on 07.10.2023
 */

@Data
@Builder
@AllArgsConstructor
public class SampleData implements Serializable {

    private String key;
    private String value;

}
