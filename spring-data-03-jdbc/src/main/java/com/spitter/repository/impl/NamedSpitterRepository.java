package com.spitter.repository.impl;

import com.spitter.domain.Spitter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
public class NamedSpitterRepository {
    // 使用命名参数
    private final NamedParameterJdbcOperations jdbcOperations;

    @Inject
    public NamedSpitterRepository(NamedParameterJdbcOperations operations){
        this.jdbcOperations = operations;
    }

    public void updateSpitter(Spitter spitter) {

    }

    public Spitter findOne(Long id) {
        String sql = "select * from spitter where id = :id";
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id",1L);
        Spitter spitter = jdbcOperations.queryForObject(sql, params, new SpitterRowMap());
        return spitter;
    }


    public void addSpitter(Spitter spitter){
        String sql = "insert into spitter (username,password,fullname,email,updateByEmail) values(:username,:password,:fullname,:email,:updateByEmail)";
        // 使用命名参数
        // 参数使用Map来封装
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("username",spitter.getUsername());
        params.put("password",spitter.getPassword());
        params.put("fullname",spitter.getFullName());
        params.put("email",spitter.getEmail());
        params.put("updateByEmail",spitter.isUpdateByEmail());

        jdbcOperations.update(sql,params);

        //return null;

    }


    class SpitterRowMap implements RowMapper<Spitter>{

        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            Spitter spitter = new Spitter();
            spitter.setId(rs.getLong("id"));
            spitter.setUsername(rs.getString("username"));
            spitter.setPassword(rs.getString("password"));
            spitter.setFullName(rs.getString("fullname"));
            spitter.setEmail(rs.getString("email"));
            spitter.setUpdateByEmail(rs.getBoolean("updateByEmail"));

            return spitter;
        }
    }
}
