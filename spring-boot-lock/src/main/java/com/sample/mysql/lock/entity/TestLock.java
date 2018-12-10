package com.sample.mysql.lock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author even
 * @since 2018-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("test_lock")
public class TestLock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 流水号
     */
    @TableField("OUTER_SERIAL_NO")
    private String outerSerialNo;

    /**
     * 客户号
     */
    @TableField("CUST_NO")
    private String custNo;

    /**
     * 锁操作
     */
    @TableField("SOURCE_CODE")
    private String sourceCode;

    /**
     * 线程号
     */
    @TableField("THREAD_NO")
    private Long threadNo;

    /**
     * 锁状态:P处理中，F失败，Y成功
     */
    @TableField("STATUS")
    private String status;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("CREATED_AT")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField("UPDATED_AT")
    private LocalDateTime updatedAt;


}
