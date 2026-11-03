
package com.mbg.mbgcrm.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.mbg.mbgcrm.entity.FollowUp;
import com.mbg.mbgcrm.service.FollowUpService;

@RestController
@RequestMapping("/api/followups")
@CrossOrigin(origins = "*")
public class FollowUpController {

    private final FollowUpService service;

    public FollowUpController(FollowUpService service) {
        this.service = service;
    }

    @PostMapping
    public FollowUp add(@RequestBody FollowUp followUp) {
        return service.addFollowUp(followUp);
    }

    @GetMapping
    public List<FollowUp> getAll() {
        return service.getAllFollowUps();
    }

    @GetMapping("/lead/{leadId}")
    public List<FollowUp> getByLead(@PathVariable Long leadId) {
        return service.getByLeadId(leadId);
    }

    @PutMapping("/{id}")
    public FollowUp update(
            @PathVariable Long id,
            @RequestBody FollowUp followUp) {
        return service.updateFollowUp(id, followUp);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteFollowUp(id);
        return "Follow-up deleted successfully";
    }
}

