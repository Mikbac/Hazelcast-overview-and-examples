package pl.mikbac.hazelcastoverviewandexamples.controller;

import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.PredicateBuilder.EntryObject;
import com.hazelcast.query.Predicates;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mikbac.hazelcastoverviewandexamples.data.SampleData;
import pl.mikbac.hazelcastoverviewandexamples.model.SampleModel;

import java.util.List;
import java.util.UUID;

/**
 * Created by MikBac on 07.10.2023
 */

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final IMap<String, SampleModel> namesMap;

    @GetMapping("/v1/sample/{key}")
    public ResponseEntity<SampleData> getValueById(@PathVariable final String key) {
        SampleModel response = namesMap.get(key);
        return ResponseEntity.status(HttpStatus.OK).body(new SampleData(response.getCode(), response.getValue()));
    }

    @GetMapping("/v1/sample")
    public ResponseEntity<List<SampleData>> getCountriesByQueryFromCache(@RequestParam final String value) {
        final EntryObject entryObject = Predicates.newPredicateBuilder().getEntryObject();
        final Predicate<String, SampleModel> predicate = entryObject.get("value").equal(value);
        final List<SampleData> response = namesMap.values(predicate).stream()
                .map(s -> new SampleData(s.getCode(), s.getValue()))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/v1/sample")
    public ResponseEntity<SampleData> addValue(@RequestBody() final SampleData sampleData) {
        namesMap.put(sampleData.getKey(), new SampleModel(UUID.randomUUID().toString(), sampleData.getValue()));
        return ResponseEntity.status(HttpStatus.CREATED).body(sampleData);
    }

}
