package com.jstudy.distributed_scheduler.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class User {

    private Long id;
    private String name;
    private Integer age;

}
