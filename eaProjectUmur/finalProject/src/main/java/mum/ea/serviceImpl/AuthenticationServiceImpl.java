package mum.ea.serviceImpl;

import mum.ea.dao.AuthenticationDao;
import mum.ea.dao.MemberDao;
import mum.ea.domain.Member;
import mum.ea.dto.ExtendedLoginModel;
import mum.ea.dto.LoginModel;
import mum.ea.dto.MailBuilder;
import mum.ea.dto.MailDto;
import mum.ea.mail.EaMailSender;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.security.EaGrantedAuthority;
import mum.ea.security.JwtUserDetails;
import mum.ea.security.JwtUtil;
import mum.ea.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationDao authenticationDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EaMailSender eaMailSender;

    public EaResult register(Member member) {
        EaResult result = memberDao.save(member);

        if (result.isSuccess()) {
            MailBuilder mailBuilder = new MailBuilder();
            MailDto mailDto = mailBuilder.buildTo(member.getMail())
                    .buildName(member.getFirstname() + " " + member.getLastname())
                    .buildSubject("Welcome to TA TEAM")
                    .buildTemplate("welcomeTemp")
                    .build();
            eaMailSender.sendMail(mailDto);
        }

        return result;
    }

    public EaResultData<ExtendedLoginModel> login(LoginModel loginModel) {
        EaResultData<ExtendedLoginModel> result = authenticationDao.login(loginModel);
        if (result.isSuccess()) {
            // generate token
            JwtUserDetails jwtUserDetails = new JwtUserDetails();
            jwtUserDetails.setUsername(loginModel.getUsername());
            //fetch roles

            jwtUserDetails.setRoles(result.getData().getRoleList());
            EaResultData<String> tokenRes = jwtUtil.encode(jwtUserDetails);
            if (tokenRes.isSuccess()) {
                result.getData().setToken(tokenRes.getData());
                result.makeSuccess();
            }

        }
        return result;
    }
}
