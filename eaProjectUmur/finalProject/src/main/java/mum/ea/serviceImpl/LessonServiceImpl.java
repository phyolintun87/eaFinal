package mum.ea.serviceImpl;

import mum.ea.dao.LessonDao;
import mum.ea.domain.Lesson;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.LessonService;
import mum.ea.validation.EaValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;

    @Secured(value = "ROLE_ADD_LESSON")
    @EaValidate
    public EaResult save(Lesson lesson) {

       return lessonDao.save(lesson);
    }

    public EaResult delete(Long id) {
       return lessonDao.delete(id);
    }

    @Secured(value = "ROLE_ADD_LESSON")
    public EaResult update(Lesson t) {
        return lessonDao.update(t);
    }

    public EaResultData<Lesson> findById(Long id) {
        return lessonDao.findById(id);
    }

    public EaResultData<List<Lesson>> findAll() {
        return lessonDao.findAll();
    }
}
