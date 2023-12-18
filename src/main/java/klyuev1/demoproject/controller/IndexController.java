package klyuev1.demoproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String index(Map<String, Object> model) {

        model.put("key1", 15);
        model.put("key2", 200);
        model.put("key3", 20);

        return "index";


    };

    @GetMapping(value = "/check")
    public String check(String ans, String ans2, Map<String, Object> model) {

        log.info("{}, {}", ans, ans2);
        if (ans.equals("4") &&  ans2.equals("10")) {
            return "success";
        } else {
            model.put("right1", 4);
            model.put("right2", 10);
            model.put("user1", ans);
            model.put("user2", ans2);
            return "error";
        }
    }



}
