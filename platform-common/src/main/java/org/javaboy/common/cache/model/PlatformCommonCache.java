package org.javaboy.common.cache.model;

/**
 * @author:majin.wj
 * 缓存通用模型
 */
public class PlatformCommonCache {

    /**
     * 缓存数据是否存在
     */
    protected boolean exist;

    protected long version;

    protected boolean retryLater;

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public boolean isRetryLater() {
        return retryLater;
    }

    public void setRetryLater(boolean retryLater) {
        this.retryLater = retryLater;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public long getVersion() {
        return version;
    }
}
