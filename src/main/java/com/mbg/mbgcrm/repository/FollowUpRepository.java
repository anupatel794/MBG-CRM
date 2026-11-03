package com.mbg.mbgcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mbg.mbgcrm.entity.FollowUp;
import java.util.List;

public interface FollowUpRepository
        extends JpaRepository<FollowUp, Long> {

    List<FollowUp> findByLeadId(Long leadId);

    long countByStatus(String status);
}
