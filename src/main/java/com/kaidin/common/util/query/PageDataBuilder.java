package com.kaidin.common.util.query;

import com.kaidin.common.util.exception.IExceptionCode;

/**
 * 用来方便构建PageData<T>模型
 * @author xiaobin
 * @date 2020-09-09 22:54
 */
public class PageDataBuilder {

    /**
     * 构建返回成功的数据模型
     * @param <T>
     * @return
     */
    public static <T> PageData<T> success() {
        PageData<T> result = new PageData<>();
        result.setSuccess(true);

        return result;
    }

    /**
     * 构建返回成功的数据模型
     * @param data
     * @param <T>
     * @return
     */
    public static <T> PageData<T> success(T data) {
        PageData<T> result = new PageData<>();

        result.setData(data);
        result.setSuccess(true);

        return result;
    }

    /**
     * 返回检查异性的数据模型
     * @param eEnum
     * @return
     */
    public static PageData error(IExceptionCode eEnum) {
        PageData result = new PageData();
        result.setErrCode(eEnum.getErrCode());
        result.setErrMsg(eEnum.getErrMsg());

        return result;
    }

    /**
     * 返回检查异性的数据模型
     * @param errCode
     * @param errMsg
     * @return
     */
    public static PageData error(String errCode, String errMsg) {
        PageData result = new PageData();

        result.setErrCode(errCode);
        result.setErrMsg(errMsg);

        return result;
    }
}
