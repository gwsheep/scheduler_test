package com.jstudy.distributed_scheduler.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@ToString
@Accessors(chain = true)
public class TargetUser {

    private Long id;
    private String name;
    private Integer age;
    private LocalDateTime processedAt;

}
