package br.ufrn.trackingframework.repository;

import br.ufrn.trackingframework.Model.DataEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DataEntityRepository extends GenericRepository<DataEntity, String> {

}
