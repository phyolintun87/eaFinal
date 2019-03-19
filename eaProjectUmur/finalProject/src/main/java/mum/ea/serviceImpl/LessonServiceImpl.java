package mum.ea.serviceImpl;

import mum.ea.dao.LessonDao;
import mum.ea.domain.Lesson;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;

    public EaResult save(Lesson t) {
       return lessonDao.save(t);
    }

    public EaResult delete(Long id) {
       return lessonDao.delete(id);
    }

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