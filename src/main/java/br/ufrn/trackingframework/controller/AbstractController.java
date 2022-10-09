package br.ufrn.trackingframework.controller;

import br.ufrn.trackingframework.Model.AbstractModel;
import br.ufrn.trackingframework.service.AbstractService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

@CrossOrigin(origins = "*")
public abstract class AbstractController<T extends AbstractModel, PK extends Serializable> {

    protected abstract AbstractService<T, PK> service();

    @GetMapping
    public Flux<T> findAll() {
        return service().findAll();
    }

    @GetMapping("/{id}")
    public Mono<T> getById(@PathVariable PK id) {
        return service().getById(id);
    }

    @PostMapping
    public Mono<T> save(@RequestBody T entity) {
        return service().save(entity);
    }

    @DeleteMapping("/{id}")
    public Mono delete(@PathVariable(value = "id") PK id) {
        return service().delete(id);
    }
}
