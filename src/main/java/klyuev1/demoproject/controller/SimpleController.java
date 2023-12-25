package klyuev1.demoproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import klyuev1.demoproject.entity.SimpleTask;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/simple")
public class SimpleController {

    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/")
    public String index(Map<String, Object> model) {

        Random random = new Random();
        int count = random.nextInt(5,10);

        List<SimpleTask> tasks = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            tasks.add(new SimpleTask(
                    i,
                    random.nextInt(1,10),
                    random.nextInt(1,10)
            ));
        }

        model.put("tasks", tasks);
        return "simple";

    };

    @PostMapping(value = "/check")
    public String check(HttpServletRequest request) {

        log.info("пришли примеры {}", request.getParameterMap());

        return "simple";
    }

}
