package com.syh.demo.mybatis.generator.templates.util;

import com.syh.demo.mybatis.generator.templates.enums.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * @author hsy
 * @version 1.0
 * @date 2019/12/28 17:39
 *
 * 返回给前端的响应体
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NurseResponseUtil<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 调用接口返回描述信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public NurseResponseUtil() {
    }

    public NurseResponseUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public NurseResponseUtil(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 功能描述
     *  不带返回体的成功返回
     * @param <T>   泛型
     * @return  ResponseUtil
     */
    public static <T> NurseResponseUtil<T> succeed() {
        return succeed(null);
    }

    /**
     * 功能描述
     *  带返回体的成功返回
     * @param <T>   泛型
     * @return  ResponseUtil
     */
    public static <T> NurseResponseUtil<T> succeed(T data) {
        return new NurseResponseUtil<>(ResponseCode.OK.code, ResponseCode.OK.msg, data);
    }

    /**
     * 功能描述
     *  请求成功，但是没有任何结果
     * @param <T>   泛型
     * @return  ResponseUtil
     */
    public static <T> NurseResponseUtil<T> succeedButNotResult() {
        return new NurseResponseUtil<>(ResponseCode.RESULT_IS_NULL.code, ResponseCode.RESULT_IS_NULL.msg, null);
    }

    /**
     * 功能描述
     *  不带返回体的失败返回——业务级别失败
     * @param <T>   泛型
     * @return  ResponseUtil
     */
    public static <T> NurseResponseUtil<T> failureBusinessLevel () {
        return failure(ResponseCode.BUSINESS_LEVEL_ERROR.code, ResponseCode.BUSINESS_LEVEL_ERROR.msg, null);
    }
    /**
     * 功能描述
     *  不带返回体的失败返回——系统级别失败
     * @param <T>   泛型
     * @return  ResponseUtil
     */
    public static <T> NurseResponseUtil<T> failureSystemLevel () {
        return failure(ResponseCode.INTERNAL_SERVER_ERROR.code, ResponseCode.INTERNAL_SERVER_ERROR.msg, null);
    }

    public static <T> NurseResponseUtil<T> failureMicroInvocation () {
        return failure(ResponseCode.MICRO_INVOCATION_ERROR.code, ResponseCode.MICRO_INVOCATION_ERROR.msg, null);
    }

    public static <T> NurseResponseUtil<T> failure (Integer code, String msg, T data) {
        return new NurseResponseUtil<>(code, msg, data);
    }
}

