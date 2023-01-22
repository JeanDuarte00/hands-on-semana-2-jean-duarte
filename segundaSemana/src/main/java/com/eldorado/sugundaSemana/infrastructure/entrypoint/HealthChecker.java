package com.eldorado.sugundaSemana.infrastructure.entrypoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class HealthChecker {

    @GetMapping("/health")
    public String getHealth(){
        return "heathy";
    }

}