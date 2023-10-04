package pl.example.hazelcastoverviewandexamples.controller;

import com.hazelcast.map.IMap;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.hazelcastoverviewandexamples.model.SampleModel;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final IMap<String, String> namesMap;

    @GetMapping("/v1/sample/{key}")
    public ResponseEntity<String> addValue(@PathVariable final String key) {
        return ResponseEntity.status(HttpStatus.OK).body(namesMap.get(key));
    }

    @PostMapping("/v1/sample")
    public ResponseEntity<SampleModel> addValue(@RequestBody() final SampleModel sampleModel) {
        namesMap.put(sampleModel.getKey(), sampleModel.getValue());
        return ResponseEntity.status(HttpStatus.CREATED).body(sampleModel);
    }

}
