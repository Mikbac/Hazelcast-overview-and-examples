package pl.mikbac.sampleembeddedmodeapp.runnable;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * Created by MikBac on 05.11.2023
 */

@AllArgsConstructor
public class EchoTask implements Runnable, Serializable {

    private Integer taskNumber;

    @Override
    public void run() {
        System.out.println("Execution taks: " + taskNumber);
    }

}
