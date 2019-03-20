package mum.ea.daoImpl;

import com.sun.tools.internal.xjc.outline.ClassOutline;
import mum.ea.dao.CourseDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Course;
import mum.ea.domain.Member;
import mum.ea.dto.CourseDto;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.security.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {
    public CourseDaoImpl() {
        super.domainClass = Course.class;
    }

    public EaResult enroll(Long idCourse) {
        EaResult result = new EaResult();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtUserDetails jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        long currentUserId = jwtUserDetails.getId();

        try {
            Course c = findById(idCourse).getData();
            if (c.getJoinedMembers() == null) {
                c.setJoinedMembers(new ArrayList<Member>());
            }

            Member m = new Member();
            m.setId(currentUserId);

            c.getJoinedMembers().add(m);

            entityManager.merge(c);

        } catch (Exception e) {
            int a = 5;
        }
        return result;
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
