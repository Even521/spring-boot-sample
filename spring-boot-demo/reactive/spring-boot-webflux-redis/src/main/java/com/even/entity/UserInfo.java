package com.even.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author even
 * @date 2020/12/22 0022 下午 17:06
 * @describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    /**
     * id
     * @return
     * @ahtor even
     * @since
     */
    @Id
    private Integer id;
    /**
     * 姓名
     * @return
     * @ahtor even
     * @since
     */
    private String userName;
    /**
     * 创建时间
     * @return
     * @ahtor even
     * @since
     */
    private LocalDateTime createTime;

}
