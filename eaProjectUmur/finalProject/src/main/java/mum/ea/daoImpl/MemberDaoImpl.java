package mum.ea.daoImpl;

import mum.ea.dao.MemberDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Course;
import mum.ea.domain.Member;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao {
    public MemberDaoImpl() {
        super.domainClass = Member.class;
    }
    
  
	public List<Course> myCourses(long id) {
		Query query=entityManager.createQuery("SELECT m from Member m where m.id=:id ");
		Member result=(Member) query.setParameter("id", id).getSingleResult();
		
		 List<Course> courses=result.getCourseList();
		 
		return courses;

	}
}
