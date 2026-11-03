
package com.mbg.mbgcrm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbg.mbgcrm.entity.Lead;
import com.mbg.mbgcrm.repository.LeadRepository;

@Service
public class LeadService {

    private final LeadRepository repository;

    public LeadService(LeadRepository repository) {
        this.repository = repository;
    }

    public Lead addLead(Lead lead) {
        return repository.save(lead);
    }

    public List<Lead> getAllLeads() {
        return repository.findAll();
    }

    public Lead getLeadById(Long id) {
        return repository.findById(id)
            .orElseThrow(() ->
                new RuntimeException("Lead not found"));
    }

    public Lead updateLead(Long id, Lead newLead) {

        Lead oldLead = getLeadById(id);

        oldLead.setName(newLead.getName());
        oldLead.setEmail(newLead.getEmail());
        oldLead.setPhone(newLead.getPhone());
        oldLead.setCompany(newLead.getCompany());
        oldLead.setStatus(newLead.getStatus());

        return repository.save(oldLead);
    }

    public void deleteLead(Long id) {
        repository.deleteById(id);
    }
}

