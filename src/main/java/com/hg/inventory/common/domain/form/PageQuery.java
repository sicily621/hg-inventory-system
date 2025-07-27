package com.hg.inventory.common.domain.form;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class PageQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer size = Integer.MAX_VALUE;
    private Integer currentPage = 1;


    public <T> Page<T> build() {
        Page<T> page = new Page<>(currentPage, size);
        return page;
    }
}
