package com.yese.repository;

import com.yese.pojo.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

//第一个泛型是类型,第二个是主键的类型
public interface UserRepository extends ElasticsearchRepository<User, String> {
}
