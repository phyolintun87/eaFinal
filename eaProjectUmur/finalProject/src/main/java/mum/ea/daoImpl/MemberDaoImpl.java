package mum.ea.daoImpl;

import mum.ea.dao.MemberDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao {
    public MemberDaoImpl() {
        super.domainClass = Member.class;
    }
}
