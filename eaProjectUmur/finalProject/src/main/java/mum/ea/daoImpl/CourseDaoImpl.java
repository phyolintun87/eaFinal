package mum.ea.daoImpl;

import mum.ea.dao.CourseDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {
    public CourseDaoImpl() {
        super.domainClass = Course.class;
    }
}
