package mum.ea.daoImpl;

import mum.ea.dao.AuthenticationDao;
import mum.ea.domain.Member;
import mum.ea.dto.ExtendedLoginModel;
import mum.ea.dto.LoginModel;
import mum.ea.enums.StatusCode;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public EaResultData<ExtendedLoginModel> login(LoginModel loginModel) {
        EaResultData<ExtendedLoginModel> result = new EaResultData<ExtendedLoginModel>();

        try {
            Query query = entityManager.createQuery("from Member m WHERE m.username =:username AND m.password =:password");
            query.setParameter("username", loginModel.getUsername());
            query.setParameter("password", loginModel.getPassword());
            Object queryResult = query.getSingleResult();

            if (queryResult != null) {
                Member member = (Member) queryResult;
                if (member != null) {
                    ExtendedLoginModel extendedLoginModel = new ExtendedLoginModel();
                    extendedLoginModel.setUsername(member.getUsername());
                    result.setData(extendedLoginModel);
                    result.makeSuccess();
                } else {
                    result.setStatusCode(StatusCode.AUTHENTICATION_ERROR);
                }
            }
        } catch (Exception e) {
            result.setStatusCode(StatusCode.AUTHENTICATION_ERROR);
        }
        return result;
    }


}
