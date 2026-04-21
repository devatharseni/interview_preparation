package com.example.electrictybillingsystem.Controller;

import com.example.electrictybillingsystem.Entity.Meter;
import com.example.electrictybillingsystem.Service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meters")
public class MeterController {
    @Autowired
    private MeterService meterService;

    @PostMapping
    public Meter addMeter(@RequestBody Meter meter) {
        return meterService.saveMeter(meter);
    }

    @GetMapping
    public List<Meter> getAllMeters() {
        return meterService.getAllMeters();
    }

    @GetMapping("/{id}")
    public Meter getMeter(@PathVariable Long id) {
        return meterService.getMeterById(id);
    }

    @PostMapping("/assign/{meterId}/{customerId}")
    public Meter assignMeter(@PathVariable Long meterId, @PathVariable Long customerId) {
        return meterService.assignMeterToCustomer(meterId, customerId);
    }

    @DeleteMapping("/{id}")
    public String deleteMeter(@PathVariable Long id) {
        meterService.deleteMeter(id);
        return "Meter deleted successfully";
    }
}

