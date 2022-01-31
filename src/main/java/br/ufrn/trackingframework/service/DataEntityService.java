package br.ufrn.trackingframework.service;

import br.ufrn.trackingframework.Model.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataEntityService {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    public Flux<DataEntity> findAll(){
        return reactiveMongoTemplate.findAll(DataEntity.class);
    }

    public Mono<DataEntity> save(DataEntity dataEntity){
        return reactiveMongoTemplate.save(dataEntity);
    }


}
