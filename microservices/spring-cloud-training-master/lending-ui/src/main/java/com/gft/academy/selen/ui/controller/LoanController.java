package com.gft.academy.selen.ui.controller;

import com.gft.academy.selen.ui.feign.client.LoanFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private LoanFeignClient client;

    @RequestMapping(method = RequestMethod.GET, value = "/loan")

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String readAllLoans() {
        return client.readAllLoans();
    }

}
