package mum.ea.controller;

import mum.ea.batch.MemberBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.controller.abstracts.CrudController;
import mum.ea.domain.Test;
import mum.ea.service.TestService;

@RestController
@RequestMapping("/api/test")
public class TestController extends CrudController<Test, TestService> {

    @Autowired
    private MemberBatch memberBatch;

    @GetMapping(value = "/start")
    public void startBatch() {
        memberBatch.startjob();
    }

}
