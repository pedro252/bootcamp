package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
    //como vai enviar os dados, para formato json
    //post salva
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@RequestBody StockDTO dto) {

        return ResponseEntity.ok(dto);

    }

    //put alteração
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);

    }

    //pegar informações
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findALL() {

        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Magazine Luiza");
        dto.setPrice(1000D);
        dto.setVariation(10D);
        dto.setDate(LocalDate.now());

        StockDTO stock2 = new StockDTO();
        stock2.setId(2L);
        stock2.setName("Ponto Frio");
        stock2.setPrice(2000D);
        stock2.setVariation(20D);
        stock2.setDate(LocalDate.now());


        list.addAll(Arrays.asList(dto, stock2));
        return ResponseEntity.ok(list);

    }

    //pegar informações pelo id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByID(@PathVariable long id) {

        List<StockDTO> list = new ArrayList<>();

        StockDTO stock1 = new StockDTO();
        stock1.setId(1L);
        stock1.setName("Magazine Luiza");
        stock1.setPrice(1000D);
        stock1.setVariation(10D);
        stock1.setDate(LocalDate.now());

        StockDTO stock2 = new StockDTO();
        stock2.setId(2L);
        stock2.setName("Ponto Frio");
        stock2.setPrice(2000D);
        stock2.setVariation(20D);
        stock2.setDate(LocalDate.now());

        list.addAll(Arrays.asList(stock1, stock2));

        Optional<StockDTO> optionalSelecionado = list.stream().filter(x -> x.getId() == id).findFirst();

        if (optionalSelecionado.isPresent())
            return ResponseEntity.ok(optionalSelecionado.get());

        return ResponseEntity.badRequest().body("Objeto não encontrado !");

    }
}