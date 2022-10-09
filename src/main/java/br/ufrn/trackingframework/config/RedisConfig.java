package br.ufrn.trackingframework.config;

import br.ufrn.trackingframework.Model.DataEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

    @Bean
    ReactiveRedisOperations<String, DataEntity> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<DataEntity> serializer = new Jackson2JsonRedisSerializer(DataEntity.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, DataEntity> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, DataEntity> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }

}
