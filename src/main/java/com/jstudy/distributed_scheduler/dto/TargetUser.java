package com.jstudy.distributed_scheduler.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TargetUser {

    private Long id;
    private String name;
    private Integer age;
    private LocalDateTime processdAt;

}
