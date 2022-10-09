package br.ufrn.trackingframework.service;

import br.ufrn.trackingframework.Model.AbstractModel;
import br.ufrn.trackingframework.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

@Service
public abstract class AbstractService<T extends AbstractModel, PK extends Serializable> {

    protected abstract GenericRepository<T, PK> repository();

    public Flux<T> findAll(){
        return repository().findAll();
    }

    public Mono<T> getById(PK id){
        return repository().findById(id);
    }

    public Mono<T> save(T object){
        return repository().save(object);
    }

    public Mono delete(PK id){
        return repository().deleteById(id);
    }
}
