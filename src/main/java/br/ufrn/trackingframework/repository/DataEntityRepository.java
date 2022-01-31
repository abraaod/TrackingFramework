package br.ufrn.trackingframework.repository;

import br.ufrn.trackingframework.Model.DataEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataEntityRepository extends ReactiveMongoRepository<DataEntity, String> {

}
