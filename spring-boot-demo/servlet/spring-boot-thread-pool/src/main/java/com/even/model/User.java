package com.even.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author even
 * @Date 2019/4/1 17:08
 * @Describe
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String userName;
    private Integer age;
}
