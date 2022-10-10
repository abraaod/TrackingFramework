package br.ufrn.trackingframework.service;

import br.ufrn.trackingframework.Model.AbstractModel;
import br.ufrn.trackingframework.Model.DataDocument;
import br.ufrn.trackingframework.Model.DataEntity;
import br.ufrn.trackingframework.repository.DataDocumentRepository;
import br.ufrn.trackingframework.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataDocumentService extends AbstractService{

    protected final ReactiveRedisOperations<String, DataDocument> redisOperationsDocument;

    @Autowired
    private DataDocumentRepository repository;

    @Autowired
    private DataEntityService dataEntityService;

    @Override
    protected GenericRepository repository() {
        return this.repository;
    }

    public DataDocumentService(ReactiveRedisOperations<String, DataDocument> redisOperationsDocument) {
        this.redisOperationsDocument = redisOperationsDocument;
    }

    @Override
    public Mono save(AbstractModel object) {
        object = super.updateObject(object);
        DataDocument dataDocument = (DataDocument) object;
        Duration duration = Duration.ofSeconds(30);
        Mono<DataDocument> dataDocumentMono = dataEntityService.getById(dataDocument.getDataEntityId()).flatMap(entity -> fieldValidator((DataEntity) entity, dataDocument));
        return dataDocumentMono.flatMap(document -> {
            redisOperationsDocument.opsForValue().set(document.getId(), document, duration).subscribe();
            return Mono.just(document);
        });
    }

    @Override
    public Mono getById(Serializable id) {
        return redisOperationsDocument.opsForValue().get(id).switchIfEmpty(super.getById(id));
    }

    @Override
    public Mono delete(Serializable id) {
        redisOperationsDocument.delete((String) id).subscribe();
        return super.delete(id);
    }

    private Mono<DataDocument> fieldValidator(DataEntity dataEntity, DataDocument dataDocument){
        DataDocument persistedDocument = new DataDocument(dataDocument);
        for(String s : dataDocument.get().keySet()){
            List<String> fields = (ArrayList) dataEntity.get().get("fields");
            if(fields.contains(s)){
                persistedDocument.add(s, dataDocument.get().get(s));
            }
        }
        return Mono.just(persistedDocument);
    }
}
