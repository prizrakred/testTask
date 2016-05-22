package ru.kolvah.web.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kolvah.entity.Indicator;
import ru.kolvah.service.IndicatorService;
import ru.kolvah.service.serviceImpl.IndicatorServiceImpl;

import java.util.List;

/**
 * Created by dmitriik on 20.05.2016.
 */
@RestController
public class IndicatorControler {

//    @Autowired
    private IndicatorService indicatorService = new IndicatorServiceImpl();

    @RequestMapping(value = "/indicators", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Indicator>> getAll() {
        List<Indicator> indicators = indicatorService.getAll();
        return new ResponseEntity<List<Indicator>>(indicators, HttpStatus.OK);
    }

    @RequestMapping(value = "/indicators/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Indicator> getById(@PathVariable("id") Long id) {
        Indicator indicator = indicatorService.getById(id);
        return new ResponseEntity<Indicator>(indicator, HttpStatus.OK);
    }

    @RequestMapping(value = "/indicators", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insert(@RequestBody Indicator indicator) {
        indicatorService.insert(indicator);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/indicators", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Indicator indicator) {
        indicatorService.update(indicator);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/indicators/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        indicatorService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
