package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

// Nurkulov Nodirbek 3/8/2022  12:21 PM

@Service//service anotatsiyasi clasni bean qilib beradi
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    //get measurements
    public List<Measurement> getMeasurements() {
        List<Measurement> measurementList = measurementRepository.findAll();
        return measurementList;
    }

    //get measurement by id
    public String getMeasurementById(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()){
            Measurement measurement = optionalMeasurement.get();
            return null;
        }
        return null;
    }

    //add measurement
    public Result addMeasurementService(Measurement measurement) {
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName) {
            return new Result("Bunday o'lchov birligi mavjud", false);
        }
        measurementRepository.save(measurement);
        return new Result("Muvaffaqiyatli saqlandi", true);
    }

    //GET, GET ONE, EDIT, DELETE
}
