package org.javaboy.common.cache.model;

/**
 * @author:majin.wj
 */
public class PlatformBusinessCache<T> extends PlatformCommonCache {

    private T data;

    public PlatformBusinessCache<T> with(T data){
        this.data = data;
        this.exist = true;
        return this;
    }

    public PlatformBusinessCache<T> withVersion(Long version){
        this.version = version;
        return this;
    }

    public PlatformBusinessCache<T> retryLater(){
        this.retryLater = true;
        return this;
    }

    public PlatformBusinessCache<T> notExist(){
        this.exist = false;
        this.version = -1L;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
