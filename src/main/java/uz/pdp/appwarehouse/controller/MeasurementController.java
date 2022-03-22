package uz.pdp.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.MeasurementService;

import java.util.List;

// Nurkulov Nodirbek 3/8/2022  12:10 PM
@RestController
@RequestMapping("/measurement")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;

    /**
     * GET ALL MEASUREMENTS
     *
     * @return List
     */
    @GetMapping
    public List<Measurement> getMeasurements() {
        return measurementService.getMeasurements();
    }


    /**
     * GET MEASUREMENT BY ID
     *
     * @param measurementId Integer
     * @return Result
     */
    @GetMapping("/{measurementId}")
    public Result getMeasurementById(@PathVariable Integer measurementId) {
        return measurementService.getMeasurementById(measurementId);
    }


    /**
     * ADD MEASUREMENT
     *
     * @param measurement Measurement
     * @return Result
     */
    //bu klientdan malumotni tutib oluvchi method
    //request body jsonni classga parse qilib beradi
    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        return measurementService.addMeasurementService(measurement);
    }


    /**
     * UPDATE MEASUREMENT BY ID
     *
     * @param measurement Measurement
     * @return Result
     */
    @PutMapping("/{measurementId}")
    public Result updateMeasurement(@RequestBody Measurement measurement, @PathVariable Integer measurementId) {
        return measurementService.updateMeasurement(measurementId, measurement);
    }


    /**
     * DELETE MEASUREMENT
     *
     * @param measurementId Integer
     * @return Result
     */
    @DeleteMapping("/{measurementId}")
    public Result deleteMeasurement(@PathVariable Integer measurementId) {
        return measurementService.deleteMeasurementById(measurementId);
    }


}
