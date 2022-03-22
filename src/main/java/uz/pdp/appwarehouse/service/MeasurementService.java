package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

// Nurkulov Nodirbek 3/8/2022  12:21 PM

@Service
//service anotatsiyasi clasni bean qilib beradi
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    /**
     * GET ALL MEASUREMENTS
     *
     * @return List
     */
    public List<Measurement> getMeasurements() {
        return measurementRepository.findAll();
    }


    /**
     * GET MEASUREMENT BY ID
     *
     * @param id Integer
     * @return Result
     */
    public Result getMeasurementById(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()) {
            Measurement measurement = optionalMeasurement.get();
            measurement.setName(measurement.getName());
            measurement.setActive(measurement.isActive());
            return new Result(measurement, true);
        }
        return new Result("measurement not found", false);
    }


    /**
     * ADD MEASUREMENT
     *
     * @param measurement Measurement
     * @return Result
     */
    public Result addMeasurementService(Measurement measurement) {
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName) {
            return new Result("This measurement already exist", false);
        }
        measurementRepository.save(measurement);
        return new Result("Measurement saved!!!", true);
    }


    /**
     * UPDATE MEASUREMENT BY ID
     *
     * @param measurement Measurement
     * @return Result
     */
    public Result updateMeasurement(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()) {
            Measurement newMeasurement = optionalMeasurement.get();
            newMeasurement.setName(measurement.getName());
            newMeasurement.setActive(measurement.isActive());
            measurementRepository.save(newMeasurement);
            return new Result("Measurement updated!!!", true);
        }
        return new Result("Measurement not found", false);
    }


    /**
     * DELETE MEASUREMENT
     *
     * @param measurementId Integer
     * @return Result
     */
    public Result deleteMeasurementById(Integer measurementId) {
        boolean exists = measurementRepository.existsById(measurementId);
        if (exists) {
            measurementRepository.deleteById(measurementId);
            return new Result("Measurement deleted!!!", true);
        }
        return new Result("Measurement not found!!!", false);
    }
}
