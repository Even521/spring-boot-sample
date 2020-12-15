package com.even.entity;

import lombok.Data;

/**
 * @author even
 * @date 2019/8/1 0001
 * @describe
 */
@Data
public class Apple {
    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;
    /**
     * 大小
     */
    private Integer size;
    /**
     * 颜色
     */
    private String colour;
}
