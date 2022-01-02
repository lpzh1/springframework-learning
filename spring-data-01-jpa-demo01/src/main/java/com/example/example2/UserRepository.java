package com.example.example2;

import org.springframework.data.repository.Repository;

import java.util.List;

/*
    注意：直接继承Repository接口，一定要记得指定泛型，不然spring不会创建代理类对象！
    查询方法的参数和方法名要对应！
 */
public interface UserRepository extends Repository<User,Long> {

    /**
     * 根据名称查找User
     *
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 多条件查询
     *
     * @param name
     * @return
     */
    List<User> findByEmailAndName(String email,String name);

    void save(User user);
}
