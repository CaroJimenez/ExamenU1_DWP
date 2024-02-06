package examen.examen.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import examen.examen.Model.Vehicle;
import examen.examen.Service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "http://localhost:5173")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @PostMapping
    public Vehicle saveVehicle(@RequestBody(required = true) Vehicle vehicle) {
        return service.saveVehicle(vehicle);
    }

    @PostMapping("/page")
    Page<Vehicle> getPage(Pageable pageable) {
        return service.PageOfVehicle(pageable);
    }

    @GetMapping
    public List<Vehicle> getAll(){
        return service.getListVehiculos();
    }

    @GetMapping("/page")
    Page<Vehicle> getAll(Pageable pageable){
        return service.PageOfVehicle(pageable);
    }
}
