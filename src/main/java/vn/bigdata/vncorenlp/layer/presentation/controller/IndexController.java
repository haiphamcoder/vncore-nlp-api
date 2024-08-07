package vn.bigdata.vncorenlp.layer.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.bigdata.vncorenlp.utility.response.Response;
import vn.bigdata.vncorenlp.utility.response.ResponseFactory;

@RestController
public class IndexController {
    @GetMapping("/")
    Response getRoot() {
        return ResponseFactory.getSuccessResponse("Welcome");
    }

    @GetMapping("ping")
    Response getAll() {
        return ResponseFactory.getSuccessResponse("pong");
    }
}