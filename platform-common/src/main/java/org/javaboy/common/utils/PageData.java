package org.javaboy.common.utils;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
public class PageData<T> {

    private T data;

    private long total;
    private long currentPage;
    private long pageSize;

    public PageData(long currentPage,long pageSize){
        this.currentPage =currentPage;
        this.pageSize = pageSize;
    }
}
