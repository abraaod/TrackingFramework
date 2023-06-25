package br.ufrn.trackingframework.Model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AbstractModel {

    @Id
    private String id;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    private Double latitude;

    private Double longitude;

    private Map<String, Object> data;

    @JsonAnySetter
    public void add(String key, Object value){
        if(data == null){
            data = new HashMap<>();
        }
        data.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> get(){
        return data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "AbstractModel{" +
                "id='" + id + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", data=" + data +
                '}';
    }
}
