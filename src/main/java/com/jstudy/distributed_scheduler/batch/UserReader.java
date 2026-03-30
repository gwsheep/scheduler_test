package com.jstudy.distributed_scheduler.batch;

import com.jstudy.distributed_scheduler.dto.User;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserReader extends JdbcCursorItemReader<User> {

    public UserReader(DataSource dataSource) {

        setName("userReader");
        setDataSource(dataSource);
        setSql("SELECT id, name, age " +
                "FROM user " +
                "ORDER BY id");

        setRowMapper((rs, rowNum) -> new User()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setAge(rs.getInt("age")));

    }



}
