package com.janani.sms.allocationservice.service;

import com.janani.sms.allocationservice.model.DetailResponse;
import com.janani.sms.allocationservice.model.Response;
import com.janani.sms.commons.model.allocation.Allocation;

import java.util.List;

public interface AllocationService {
    Allocation save(Allocation allocation);

    Allocation fetchById(int profileId);

    List<Allocation> fetchAllProfiles();

    void deleteAllocation(int allocationId);

    DetailResponse findDetailResponse(int allocationId);
}
