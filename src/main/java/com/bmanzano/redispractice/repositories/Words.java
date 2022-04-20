package com.bmanzano.redispractice.repositories;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash("Words")
@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
public class Words {
    @Id
    String id;
    String key;
    String value;

}
