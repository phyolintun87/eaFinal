package mum.ea.controller;


import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Course;
import mum.ea.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController extends CrudController<Course, CourseService> {


}
