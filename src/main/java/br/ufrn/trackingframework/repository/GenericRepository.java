package br.ufrn.trackingframework.repository;

import br.ufrn.trackingframework.Model.AbstractModel;
import br.ufrn.trackingframework.Model.DataEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.io.Serializable;

public interface GenericRepository<T extends AbstractModel, PK extends Serializable> extends ReactiveMongoRepository<T, PK> {
}
