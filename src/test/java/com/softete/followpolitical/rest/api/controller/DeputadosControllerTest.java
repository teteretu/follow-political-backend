package com.softete.followpolitical.rest.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softete.followpolitical.rest.api.Service.DeputadosService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeputadosController.class)
class DeputadosControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DeputadosService deputadosService;

    @Test
    void getListDeputados() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("dep", null);

        when(deputadosService.getDeputados()).thenReturn(map);
        String contentResponse = this.mockMvc.perform(get("/api/deputados/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(new ObjectMapper().readValue(contentResponse, Map.class), map);

        verify(deputadosService, Mockito.times(1)).getDeputados();
    }

}