package br.ufrn.trackingframework.service;

import br.ufrn.trackingframework.Model.AbstractModel;
import br.ufrn.trackingframework.Model.DataEntity;
import br.ufrn.trackingframework.repository.DataEntityRepository;
import br.ufrn.trackingframework.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.swing.text.html.parser.Entity;
import javax.xml.crypto.Data;
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
        Date date = new Date();
        if(object.getId() == null){
            object.setId(UUID.randomUUID().toString());
            object.setCreatedDate(date);
        }
        object.setLastModifiedDate(date);
        DataEntity dataEntity = (DataEntity) object;
        redisOperations.opsForValue().set(dataEntity.getId(), dataEntity).subscribe();
        return super.save(object);
    }
}
