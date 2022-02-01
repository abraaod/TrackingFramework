package br.ufrn.trackingframework.Model;

import br.ufrn.trackingframework.helper.DataEntityValidator;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dataentities")
public class DataEntity extends AbstractModel{

    @Indexed(unique = true)
    private String dataEntity;

    @Override
    public void add(String key, Object value) {

        if(DataEntityValidator.isValid(value)){
            super.add(key, value);
        } else {
            //TODO improve this runtime exception
            throw new RuntimeException();
        }
    }

    public String getDataEntity() {
        return dataEntity;
    }

    public void setDataEntity(String dataEntity) {
        this.dataEntity = dataEntity;
    }
}
