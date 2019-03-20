package mum.ea.daoImpl;

import mum.ea.dao.CourseDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Course;
import mum.ea.domain.Member;
import mum.ea.model.EaResultData;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {
    public CourseDaoImpl() {
        super.domainClass = Course.class;
    }

    public EaResultData<List<Course>> listMyCourses(long idMember) {
        EaResultData<List<Course>> result = new EaResultData<List<Course>>();

        try {

            Query query = entityManager
                    .createQuery("from Member m WHERE m.id =:idMember");

            query.setParameter("idMember", idMember);
            Member m = (Member) query.getSingleResult();

            if (m != null && m.getCourseList() != null) {
                List<Course> cl = new ArrayList<Course>();
                for (Course db : m.getCourseList()) {
                    Course course = new Course();
                    course.setId(db.getId());
                    course.setName(db.getName());
                    course.setDescription(db.getDescription());

                    course.setInstructor(new Member());
                    course.getInstructor().setFirstname(db.getInstructor().getFirstname());
                    course.getInstructor().setLastname(db.getInstructor().getLastname());


                    cl.add(course);
                }
                result.setData(cl);

            }
            result.makeSuccess();
        } catch (Exception e) {

        }

        return result;
    }
}
