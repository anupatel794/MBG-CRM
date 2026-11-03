
package com.mbg.mbgcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mbg.mbgcrm.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    long countByStatus(String status);

}

