package cn.texous.common.builder;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/18 1:23
 */
public interface BaseBuilder<T> {

    /**
     * 生成对象
     * @return
     */
    T build();

}
