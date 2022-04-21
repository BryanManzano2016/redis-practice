package com.bmanzano.redispractice.repositories;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.io.Serializable;
@RedisHash("Words")
@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
public class Words implements Serializable {
    @Id
    String id;
    @Indexed
    String key;
    String value;
}
