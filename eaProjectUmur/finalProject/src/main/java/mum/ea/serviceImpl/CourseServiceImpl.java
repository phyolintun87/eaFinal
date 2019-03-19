package mum.ea.serviceImpl;

import mum.ea.amqp.CourseNotifier;
import mum.ea.amqp.CourseNotifierImpl;
import mum.ea.dao.CourseDao;
import mum.ea.domain.Course;
import mum.ea.domain.Lesson;
import mum.ea.domain.Member;
import mum.ea.dto.CourseDto;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.CourseService;
import mum.ea.validation.EaValidate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private RabbitTemplate topicTemplate;

    @EaValidate
    public EaResult save(Course course) {

        if (course.getLessonList() != null) {
            for (Lesson lesson : course.getLessonList()) {
                lesson.setCourse(course);
            }
        }

//        if (course.getJoinedMembers() != null) {
//                for(Member m : ){
//
//                }
//        }

        EaResult result = courseDao.save(course);
        if (result.isSuccess()) {
            // publish to users about new course
            try {
                CourseNotifier courseNotifier = new CourseNotifierImpl();
                CourseDto courseDto = new CourseDto();
                courseDto.setName(course.getName());
                courseNotifier.publish(topicTemplate, courseDto);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public EaResult delete(Long id) {
        return courseDao.delete(id);
    }

    @EaValidate
    public EaResult update(Course t) {
        return courseDao.update(t);
    }

    public EaResultData<Course> findById(Long id) {
        return courseDao.findById(id);
    }

    public EaResultData<List<Course>> findAll() {
        return courseDao.findAll();
    }
}
