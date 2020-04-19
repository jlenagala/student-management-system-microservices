package com.janani.sms.allocationservice.controller;

import com.janani.sms.allocationservice.model.Response;
import com.janani.sms.allocationservice.model.SimpleResponse;
import com.janani.sms.allocationservice.service.AllocationService;
import com.janani.sms.commons.model.allocation.Allocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class AllocationController {
    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/allocations", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Allocation save(@RequestBody Allocation allocation) {
        return allocationService.save(allocation);
    }

    @RequestMapping(value = "/allocations/{allocationId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('create_profile')")
    public Response fetch(@PathVariable int allocationId,@RequestParam(required = false) String type, @RequestHeader (name="Authorization") String token) {
        if(type==null){
            System.out.println(type);
            return new SimpleResponse((allocationService.fetchById(allocationId)));
        }
        else{
//            System.out.println(type);
//            System.out.println(token);
           return allocationService.findDetailResponse(allocationId,token);
        }
        //return allocationService.fetchById(allocationId);
    }
    @RequestMapping(value = "/allocations", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Allocation> fetch() {
        return allocationService.fetchAllProfiles();
    }

    @RequestMapping(value = "/allocations", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('update_profile')")
    public Allocation updateProfile(@RequestBody Allocation allocation) {
        return allocationService.save(allocation);
    }

    @RequestMapping(value = "/allocations/{allocationId}", method = RequestMethod.DELETE)
    public void deleteProfile(@PathVariable int allocationId) {
        Allocation tempAllocation = allocationService.fetchById(allocationId);
        allocationService.deleteAllocation(allocationId);
    }



}
