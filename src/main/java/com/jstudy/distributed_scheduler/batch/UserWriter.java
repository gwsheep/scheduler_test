package com.jstudy.distributed_scheduler.batch;

import com.jstudy.distributed_scheduler.dto.TargetUser;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserWriter extends JdbcBatchItemWriter<TargetUser> {

    public UserWriter(DataSource dataSource) {

        setDataSource(dataSource);
        setSql("""
                INSERT INTO target_user (id, name, age, processed_at)
                VALUES (:id, :name, :age, :processedAt)
                ON DUPLICATE KEY UPDATE
                    name = VALUES(name),
                    age = VALUES(age),
                    processed_at = VALUES(processed_at)
            """);
        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

        try {
            afterPropertiesSet();
        } catch (Exception e) {
            throw new IllegalArgumentException("UserWriter 초기화를 실패하였습니다.", e);
        }

    }





}
