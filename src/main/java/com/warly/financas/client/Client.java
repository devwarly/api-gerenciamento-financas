package com.warly.financas.client;

import com.warly.financas.config.FeignConfig;
import com.warly.financas.dto.BuscarCotacaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@FeignClient(name = "awesomeApi", url = "${api.cambio.url}", configuration = FeignConfig.class)
public interface Client {

    @GetMapping("/last/{par}")
    Map<String, BuscarCotacaoDTO> buscarCotacao(@PathVariable("par") String par);
}