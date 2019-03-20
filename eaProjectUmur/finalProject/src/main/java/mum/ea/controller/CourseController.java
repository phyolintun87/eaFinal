package mum.ea.controller;


import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Course;
import mum.ea.model.EaResultData;
import mum.ea.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController extends CrudController<Course, CourseService> {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/myCourses")
    public EaResultData<List<Course>> listMyCourses() {
        return courseService.listMyCourses();
    }
    
    

}
