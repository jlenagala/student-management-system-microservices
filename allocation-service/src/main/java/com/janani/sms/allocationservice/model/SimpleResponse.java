package com.janani.sms.allocationservice.model;

import com.janani.sms.commons.model.allocation.Allocation;

public class SimpleResponse implements Response {
    Allocation allocation;

    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }

    public SimpleResponse(Allocation allocation) {
        this.allocation = allocation;
    }
}
