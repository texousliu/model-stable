package cn.texous.common.builder;

import cn.texous.common.constants.TexousResult;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/17 22:50
 */
public class ResultBuilder<T extends TexousResult> {

    private T result;

    public ResultBuilder(T result) {
        this.result = result;
    }

    public ResultBuilder status(int status) {
        result.setStatus(status);
        return this;
    }

    public ResultBuilder description(String description) {
        result.setDescription(description);
        return this;
    }

    public ResultBuilder data(Object data) {
        result.setData(data);
        return this;
    }

    public T build() {
        return this.result;
    }

}
