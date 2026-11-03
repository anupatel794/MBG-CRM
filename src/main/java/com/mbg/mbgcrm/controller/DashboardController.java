
package com.mbg.mbgcrm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.mbg.mbgcrm.repository.LeadRepository;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    private final LeadRepository repository;

    public DashboardController(LeadRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/summary")
    public Map<String, Long> getSummary() {

        Map<String, Long> data = new HashMap<>();

        data.put("totalLeads", repository.count());
        data.put("newLeads",
                repository.countByStatus("NEW"));
        data.put("followUps",
                repository.countByStatus("FOLLOW_UP"));
        data.put("convertedLeads",
                repository.countByStatus("CONVERTED"));

        return data;
    }
}

