package com.atguigu.gmall.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel
@Data
public class PageInfoVo implements Serializable {

    private Long total;

    private Long totalPage;

    private Long pageSize;

    private List<? extends Object> list;

    private Long pageNum;
}
