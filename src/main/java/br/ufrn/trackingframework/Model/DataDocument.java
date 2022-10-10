package br.ufrn.trackingframework.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "datadocuments")
public class DataDocument extends AbstractModel{

    private String dataEntityId;

    public String getDataEntityId() {
        return dataEntityId;
    }

    public void setDataEntityId(String dataEntityId) {
        this.dataEntityId = dataEntityId;
    }

    public DataDocument() {
    }

    public DataDocument(DataDocument document) {
        this.setId(document.getId());
        this.setDataEntityId(document.getDataEntityId());
        this.setLatitude(document.getLatitude());
        this.setLongitude(document.getLongitude());
        this.setCreatedDate(document.getCreatedDate());
        this.setLastModifiedDate(document.getLastModifiedDate());
    }

    @Override
    public String toString() {
        return "DataDocument{" +
                "dataEntityId='" + dataEntityId + '\'' +
                '}' + super.toString();
    }
}
