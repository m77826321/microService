package org.ebrahimi.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class productController {

    @GetMapping("/list")
    public String list() {
        return "";
    }
}
