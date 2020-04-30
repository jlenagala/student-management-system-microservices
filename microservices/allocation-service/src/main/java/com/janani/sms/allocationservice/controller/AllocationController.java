package com.janani.sms.allocationservice.controller;

import com.janani.sms.allocationservice.model.DetailResponse;
import com.janani.sms.allocationservice.model.Response;
import com.janani.sms.allocationservice.model.SimpleResponse;
import com.janani.sms.allocationservice.service.AllocationService;
import com.janani.sms.commons.model.allocation.Allocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/services")
public class AllocationController {
    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/allocations", method = RequestMethod.POST)
    // @PreAuthorize("hasAuthority('create_profile')")
    public Allocation save(@RequestBody Allocation allocation) {
        return allocationService.save(allocation);
    }

    @RequestMapping(value = "/allocationsByStudent/{studentId}", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('create_profile')")
    public List<DetailResponse> fetchByStudent(@PathVariable int studentId) {
        return allocationService.findDetailResponseByStudent(studentId);
    }

    @RequestMapping(value = "/allocationsByCourse/{courseId}", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('create_profile')")
    public List<DetailResponse> fetchByCourse(@PathVariable int courseId) {
        return allocationService.findDetailResponseByCourse(courseId);
    }

    @RequestMapping(value = "/allocations/{allocationId}", method = RequestMethod.GET)
    //@PreAuthorize("hasAuthority('create_profile')")
    public Response fetch(@PathVariable int allocationId, @RequestParam(required = false) String type) {
        if (type == null) {
            return new SimpleResponse((allocationService.fetchById(allocationId)));
        } else {
            return allocationService.findDetailResponse(allocationId);
        }
        //return allocationService.fetchById(allocationId);
    }

    @RequestMapping(value = "/allocation", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ROLE_admin')")
    public List<Allocation> fetch() {
        return allocationService.fetchAll();
    }

    @RequestMapping(value = "/allocations", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ROLE_admin')")
    public List<Allocation> fetchAll() {
        return allocationService.fetchAll();
    }


    @RequestMapping(value = "/allocations", method = RequestMethod.PUT)
    // @PreAuthorize("hasAuthority('update_profile')")
    public Allocation updateProfile(@RequestBody Allocation allocation) {
        return allocationService.save(allocation);
    }

    @RequestMapping(value = "/allocations/{allocationId}", method = RequestMethod.DELETE)
    public void deleteProfile(@PathVariable int allocationId) {
        Allocation tempAllocation = allocationService.fetchById(allocationId);
        allocationService.deleteAllocation(allocationId);
    }


}
