package br.ufrn.trackingframework.service;

import br.ufrn.trackingframework.Model.DataEntity;
import br.ufrn.trackingframework.repository.DataEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataEntityService {

    @Autowired
    private DataEntityRepository repository;

    public Flux<DataEntity> findAll(){
        return repository.findAll();
    }

    public Mono<DataEntity> getById(String id) { return repository.findById(id); }

    public Mono<DataEntity> save(DataEntity dataEntity){
        return repository.save(dataEntity);
    }

    public Mono deleteById(String id) {
        return repository.deleteById(id);
    }
}
