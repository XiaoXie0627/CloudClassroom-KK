package com.ymcc.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**--------------------------------------------------------
封装分页查询结果
--------------------------------------------------------**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageList<T> {

    //条数
    private Long total = 0L;

    //列表
    private List<T> rows = new ArrayList<>();

}
