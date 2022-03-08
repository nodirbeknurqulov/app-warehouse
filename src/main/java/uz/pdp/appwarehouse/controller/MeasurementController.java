package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.MeasurementService;

import java.util.List;

// Nurkulov Nodirbek 3/8/2022  12:10 PM
@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @GetMapping
    public List<Measurement> getMeasurements(){
        List<Measurement> measurements = measurementService.getMeasurements();
        return measurements;
    }

    @GetMapping("/{measurementId}")
    public String getMeasurementById(@PathVariable Integer measurementId){
        String measurementById = measurementService.getMeasurementById(measurementId);
        return measurementById;
    }

    //bu klientdan malumotni tutib oluvchi method
    @PostMapping//request body jsonni classga parse qilib beradi
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        Result result = measurementService.addMeasurementService(measurement);
        return result;
    }
}
