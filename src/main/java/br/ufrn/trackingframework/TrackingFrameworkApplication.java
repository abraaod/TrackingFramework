package br.ufrn.trackingframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication()
@EnableReactiveMongoAuditing()
public class TrackingFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackingFrameworkApplication.class, args);
    }

}
