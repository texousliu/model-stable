package cn.texous.common.constants;

import cn.texous.common.builder.ResultBuilder;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/17 22:19
 */
public class TexousResult {

    private int status;
    private String description;
    private Object data;

    public TexousResult(StatusConstants result) {
        this.status = result.getStatus();
        this.description = result.getDescription();
    }

    public TexousResult() { }

    public static TexousResult ok() {
        return new TexousResult(StatusConstants.SUCCESS);
    }

    public static TexousResult ok(Object data) {
        return result(StatusConstants.SUCCESS, data);
    }

    public static TexousResult result(int status, String description, Object data) {
        return new ResultBuilder(new TexousResult())
                .status(status).description(description).data(data).build();
    }

    public static TexousResult result(int status, String description) {
        return result(status, description, null);
    }

    public static TexousResult result(StatusConstants constants) {
        return result(constants.getStatus(), constants.getDescription());
    }

    public static TexousResult result(StatusConstants constants, Object data) {
        return result(constants.getStatus(), constants.getDescription(), data);
    }

    public static TexousResult defFail() {
        return result(StatusConstants.FAILURE);
    }

    public static TexousResult defFail(String description) {
        return result(StatusConstants.FAILURE.getStatus(), description);
    }

    public static TexousResult paramFail() {
        return result(StatusConstants.PARAM_ERROR);
    }

    public static TexousResult paramFail(String description) {
        return result(StatusConstants.PARAM_ERROR.getStatus(), description);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
