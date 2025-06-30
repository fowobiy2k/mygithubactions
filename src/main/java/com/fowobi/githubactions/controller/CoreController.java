package com.fowobi.githubactions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action")
public class CoreController {
    @GetMapping("msg")
    public String hello() {
        return "GitHubActions for AWS";
    }
}
