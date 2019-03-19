package mum.ea.controller;

import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Member;
import mum.ea.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController extends CrudController<Member, MemberService> {
}
