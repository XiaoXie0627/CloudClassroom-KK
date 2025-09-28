package com.ymcc.scommon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Light xhh032533@163.com
 * @time 2025/9/29 03:02
 * 验证码对象 包括：验证码和过期时间
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeDTO {
    String code;
    Long time;
}
