package com.even.springbootelasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author even
 * @date 2019/4/16 15:51
 * @describe
 */
@Document(indexName = "user",type = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String userName;
    private String age;
}
