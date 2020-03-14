package com.janani.sms.allocationservice.repository;

import com.janani.sms.commons.model.allocation.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {
}
