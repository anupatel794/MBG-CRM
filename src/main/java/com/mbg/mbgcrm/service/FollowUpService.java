package com.mbg.mbgcrm.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mbg.mbgcrm.entity.FollowUp;
import com.mbg.mbgcrm.repository.FollowUpRepository;

@Service
public class FollowUpService {

    private final FollowUpRepository repository;

    public FollowUpService(FollowUpRepository repository) {
        this.repository = repository;
    }

    public FollowUp addFollowUp(FollowUp followUp) {
        return repository.save(followUp);
    }

    public List<FollowUp> getAllFollowUps() {
        return repository.findAll();
    }

    public List<FollowUp> getByLeadId(Long leadId) {
        return repository.findByLeadId(leadId);
    }

    public FollowUp updateFollowUp(Long id, FollowUp data) {
        FollowUp old = repository.findById(id)
            .orElseThrow(() ->
                new RuntimeException("Follow-up not found"));

        old.setFollowUpDate(data.getFollowUpDate());
        old.setNotes(data.getNotes());
        old.setStatus(data.getStatus());

        return repository.save(old);
    }

    public void deleteFollowUp(Long id) {
        repository.deleteById(id);
    }
}

