package com.even.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author even
 * @date 2020/3/30 0030
 * @describe
 */
@Table("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
}
