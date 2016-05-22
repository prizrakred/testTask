package ru.kolvah.web.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kolvah.entity.Indicator;
import ru.kolvah.entity.Measurement;
import ru.kolvah.service.MeasurementService;
import ru.kolvah.service.serviceImpl.MeasurementServiceImpl;

import java.util.List;

/**
 * Created by dmitriik on 22.05.2016.
 */
@RestController
public class MeasurementController {

    //    @Autowired
    private MeasurementService measurementService = new MeasurementServiceImpl();

    @RequestMapping(value = "/measurements", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Measurement>> getAll() {
        measurementService.beginWork();
        List<Measurement> measurements = measurementService.getAll();
        measurementService.endWork();
        return new ResponseEntity<List<Measurement>>(measurements, HttpStatus.OK);
    }

    @RequestMapping(value = "/measurements/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Measurement> getById(@PathVariable("id") Long id) {
        measurementService.beginWork();
        Measurement measurement = measurementService.getById(id);
        measurementService.endWork();
        return new ResponseEntity<Measurement>(measurement, HttpStatus.OK);
    }

    @RequestMapping(value = "/measurements", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insert(@RequestBody Measurement measurement) {
        measurementService.insert(measurement);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/measurements", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Measurement measurement) {
        measurementService.update(measurement);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/measurements/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        measurementService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
