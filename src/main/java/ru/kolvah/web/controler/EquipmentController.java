package ru.kolvah.web.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kolvah.entity.Equipment;
import ru.kolvah.entity.Indicator;
import ru.kolvah.service.EquipmentService;
import ru.kolvah.service.IndicatorService;
import ru.kolvah.service.serviceImpl.EquipmentServiceImpl;
import ru.kolvah.service.serviceImpl.IndicatorServiceImpl;

import java.util.List;

/**
 * Created by dmitriik on 22.05.2016.
 */
@RestController
public class EquipmentController {

    //    @Autowired
    private EquipmentService equipmentService = new EquipmentServiceImpl();

    @RequestMapping(value = "/equipments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Equipment>> getAll() {
        equipmentService.beginWork();
        List<Equipment> equipments = equipmentService.getAll();
        ResponseEntity<List<Equipment>> responseEntity = new ResponseEntity<List<Equipment>>(equipments, HttpStatus.OK);
        equipmentService.endWork();
        return responseEntity;
    }

    @RequestMapping(value = "/equipments/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipment> getById(@PathVariable("id") Long id) {
        equipmentService.beginWork();
        Equipment equipment = equipmentService.getById(id);
        ResponseEntity<Equipment> responseEntity = new ResponseEntity<Equipment>(equipment, HttpStatus.OK);
        equipmentService.endWork();
        return responseEntity;
    }

    @RequestMapping(value = "/equipments", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insert(@RequestBody Equipment equipment) {
        equipmentService.insert(equipment);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/equipments", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Equipment equipment) {
        equipmentService.update(equipment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/equipments/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        equipmentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
