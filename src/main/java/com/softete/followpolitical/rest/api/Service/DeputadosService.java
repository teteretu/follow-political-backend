package com.softete.followpolitical.rest.api.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class DeputadosService {

    public Map<String, Object> getDeputados() {
        try {
            InputStream responseStream = new HttpService()
                    .getRequest("https://dadosabertos.camara.leg.br/api/v2/deputados?ordem=ASC&ordenarPor=nome");

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseStream, Map.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
