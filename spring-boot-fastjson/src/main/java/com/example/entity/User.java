package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.time.LocalDate;

/**
 * Created by Administrator on 2018/12/20 0020.
 *
 * @author even
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {
    @JSONField(serialize=false)
    private Long id;
    @JSONField(ordinal = 3)
    private String name;
    private int age;
    @JSONField(ordinal = 1)
    private LocalDate birthday;
}
