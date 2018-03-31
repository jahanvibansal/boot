package com.gft.academy.selen.ui.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UsersController {


    @RequestMapping(method = RequestMethod.GET, value = "/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public Principal getCurrentUser(Principal principal) {
        return principal;
    }
}
