package com.yese.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
//indexName:索引,type:类型
@Document(indexName = "zhangsan", type = "user")
public class User {
    private String id;
    private String username;
    private String password;
}