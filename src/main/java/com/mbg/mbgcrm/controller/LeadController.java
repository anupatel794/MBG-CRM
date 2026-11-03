
package com.mbg.mbgcrm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mbg.mbgcrm.entity.Lead;
import com.mbg.mbgcrm.service.LeadService;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "*")
public class LeadController {

    private final LeadService service;

    public LeadController(LeadService service) {
        this.service = service;
    }

    @PostMapping
    public Lead addLead(@RequestBody Lead lead) {
        return service.addLead(lead);
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return service.getAllLeads();
    }

    @GetMapping("/{id}")
    public Lead getLead(@PathVariable Long id) {
        return service.getLeadById(id);
    }

    @PutMapping("/{id}")
    public Lead updateLead(
            @PathVariable Long id,
            @RequestBody Lead lead) {
        return service.updateLead(id, lead);
    }

    @DeleteMapping("/{id}")
    public String deleteLead(@PathVariable Long id) {
        service.deleteLead(id);
        return "Lead deleted successfully";
    }
}

