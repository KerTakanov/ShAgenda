package com.pfcca.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class IndexController {
    @RequestMapping("/")
    String index() {
        return "index";
    }
}
