package br.ufrn.trackingframework.service;

import br.ufrn.trackingframework.Model.AbstractModel;
import br.ufrn.trackingframework.Model.DataEntity;
import br.ufrn.trackingframework.repository.DataEntityRepository;
import br.ufrn.trackingframework.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Service
public class DataEntityService extends AbstractService{

    protected final ReactiveRedisOperations<String, DataEntity> redisOperations;
    @Autowired
    private DataEntityRepository repository;

    public DataEntityService(ReactiveRedisOperations<String, DataEntity> redisOperations) {
        this.redisOperations = redisOperations;
    }

    @Override
    protected GenericRepository repository() {
        return this.repository;
    }

    @Override
    public Mono save(AbstractModel object) {
        object = super.updateObjectDates(object);
        DataEntity dataEntity = (DataEntity) object;
        redisOperations.opsForValue().set(dataEntity.getId(), dataEntity).subscribe();
        return super.save(object);
    }

    @Override
    public Mono getById(Serializable id) {
        return redisOperations.opsForValue().get(id).switchIfEmpty(super.getById(id));
    }

    @Override
    public Mono delete(Serializable id) {
        redisOperations.delete((String) id).subscribe();
        return super.delete(id);
    }
}
