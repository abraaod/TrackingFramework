package br.ufrn.trackingframework.service;

import br.ufrn.trackingframework.Model.DataEntity;
import br.ufrn.trackingframework.repository.DataEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataEntityService {

    @Autowired
    private DataEntityRepository repository;

    public Flux<DataEntity> findAll(){
        return repository.findAll();
    }

    public Mono<DataEntity> save(DataEntity dataEntity){
        return repository.save(dataEntity);
    }

    public Mono deleteAll() { return repository.deleteAll(); }
}
