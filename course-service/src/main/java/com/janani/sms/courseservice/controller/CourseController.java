package com.janani.sms.courseservice.controller;

import com.janani.sms.commons.model.course.Course;
import com.janani.sms.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public Course fetch(@PathVariable(value = "id") int courseId) {
        return courseService.fetchById(courseId);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
   // @PreAuthorize("hasRole('ROLE_operator')")
    public List<Course> fetch() {
        return courseService.fetchAllProfiles();
    }

    @RequestMapping(value = "/courses", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('update_profile')")
    public Course updateProfile(@RequestBody Course course) {
        return courseService.save(course);
    }

    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.DELETE)
    public void deleteProfile(@PathVariable int courseId) {
        Course tempCourse = courseService.fetchById(courseId);
        courseService.deleteCourse(courseId);
    }

}
