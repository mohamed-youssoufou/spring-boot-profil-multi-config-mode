package fr.demo.youssoufou.ack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ForkJoinWorkerThread;

@RestController
public class EnvController {

    private static final Logger log = LoggerFactory.getLogger(EnvController.class);
    @Value("${profil}")
    private String env;

    @GetMapping("/app/env")
    public void getEnv(){
        var th = "";
        for (var i = 0; i < 10; i++){
            th =  "bonjour";
        }
    }
}
