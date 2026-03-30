package com.jstudy.distributed_scheduler.batch;

import com.jstudy.distributed_scheduler.dto.TargetUser;
import com.jstudy.distributed_scheduler.dto.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Component
public class UserProcessor implements ItemProcessor<User, TargetUser> {

    @Override
    public TargetUser process(User user) throws Exception {

        if(user == null) return null;

        String parsedUserName =
                Optional.ofNullable(user.getName()).map(String::toUpperCase).orElse(null);

        return new TargetUser()
                .setId(user.getId())
                .setName(parsedUserName)
                .setAge(user.getAge())
                .setProcessedAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")));

    }

}
