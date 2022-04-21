package com.bmanzano.redispractice.repositoriesSql;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity @Table(name = "words_sql")
@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
public class WordsSql implements Serializable {
    @Id
    String id;
    String key;
    String value;
}
