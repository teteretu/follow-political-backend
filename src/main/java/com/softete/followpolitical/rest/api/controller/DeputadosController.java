package com.softete.followpolitical.rest.api.controller;

import com.softete.followpolitical.rest.api.Service.DeputadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/deputados")
public class DeputadosController {

    @Autowired
    private DeputadosService deputadosService;

    @GetMapping("/list")
    public Map<String, Object> getDeputados() {
        return deputadosService.getDeputados();
    }
}
