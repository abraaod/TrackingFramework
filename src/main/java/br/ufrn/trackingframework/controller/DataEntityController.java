package br.ufrn.trackingframework.controller;

import br.ufrn.trackingframework.Model.DataEntity;
import br.ufrn.trackingframework.service.DataEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class DataEntityController {

    @Autowired
    DataEntityService service;

    @GetMapping
    public Flux<DataEntity> getDataEntityFlux(){
        return  service.findAll();
    }

    @PostMapping
    public Mono<DataEntity> saveDataEntityMono(@RequestBody DataEntity dataEntity){
        return service.save(dataEntity);
    }
}
