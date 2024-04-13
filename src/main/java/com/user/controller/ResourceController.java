package com.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Thangamudy Gurusamy
 * Date : 12/04/24
 * Package : com.user.controller
 */
@RestController
public class ResourceController {


    @GetMapping("/login")
    public String openPolicy() {
        return "test";
    }

}
