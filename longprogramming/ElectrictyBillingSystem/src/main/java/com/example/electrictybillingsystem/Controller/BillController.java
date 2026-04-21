package com.example.electrictybillingsystem.Controller;

import com.example.electrictybillingsystem.Entity.Bill;
import com.example.electrictybillingsystem.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private BillService billService;


    @PostMapping("/generate/{customerId}")
    public Bill generateBill(@PathVariable Long customerId,
                             @RequestParam int units) {
        return billService.generateBill(customerId, units);
    }
    @GetMapping
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/{id}")
    public Bill getBill(@PathVariable Long id) {
        return billService.getBillById(id);
    }

    @PostMapping("/pay/{billId}")
    public String payBill(@PathVariable Long billId) {
        billService.payBill(billId);
        return "Bill paid successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return "Bill deleted successfully";
    }
}
