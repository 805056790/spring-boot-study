package pers.study.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author : panxin
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "customers", type = "customer", shards = 1, replicas = 0, refreshInterval = "-1")
public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

}
