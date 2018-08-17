package cn.texous.common.constants;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/17 22:22
 */
public enum StatusConstants {

    FAILURE(-1, "请求出错"),
    SUCCESS(0, "请求成功"),
    PARAM_ERROR(-1, "请求参数错误");

    private int status;
    private String description;

    StatusConstants(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
