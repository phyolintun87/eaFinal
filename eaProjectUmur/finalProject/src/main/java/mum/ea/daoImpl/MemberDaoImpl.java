package mum.ea.daoImpl;

import mum.ea.dao.MemberDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Member;
import mum.ea.domain.MemberType;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao {
    public MemberDaoImpl() {
        super.domainClass = Member.class;
    }

    @Override
    public EaResult save(Member t) {
        if(t.getMemberType() == null) {
            t.setMemberType(new MemberType());

            t.getMemberType().setId(1L);
        }
        return super.save(t);
    }

    @Override
    public EaResultData<Member> findById(Long id) {
        Member member = (Member) entityManager.createQuery("from Member where id=:id")
                .setParameter("id", id)
                .getSingleResult();

        if (member != null && member.getCourseList() != null && !member.getCourseList().isEmpty()) {
            member.getCourseList().get(0);
        }
        EaResultData<Member> result = new EaResultData<Member>();
        result.setData(member);
        result.makeSuccess();
        return result;
    }

    @Override
    public EaResultData<List<Member>> findAll() {
        List<Member> memberList = (List<Member>) entityManager.createQuery("from Member")
                .getResultList();

        if (memberList != null && !memberList.isEmpty()) {
            if (memberList.get(0).getCourseList() != null && !memberList.get(0).getCourseList().isEmpty()) {
                memberList.get(0).getCourseList().get(0);
            }
        }

        EaResultData<List<Member>> result = new EaResultData<List<Member>>();
        result.setData(memberList);
        result.makeSuccess();
        return result;

    }
}
