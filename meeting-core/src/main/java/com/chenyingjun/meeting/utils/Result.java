/*
 * @Project: red-core
 * @Description: 处理结果对象
 */

package com.chenyingjun.meeting.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Title: Result<T>.java
 * @Package com.red.p2p.util
 * @Description: 处理结果对象
 * @author: chenyingjun
 * @date: 2016年9月18日12:00:55
 * @version V1.0
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 返回代码 */
    private String code;

    /** 返回错误消息提示 */
    private String message;

    /** 如果需要验签则返回请求过来的token */
    private String token;

    /** 返回客户端的签名 */
    private String sign;

    /** 返回结果 */
    private T t;

    public Result() {
        super();
    }

    public Result(String code, String message) {
        super();
        this.code = code;
        if (StringUtils.isNotBlank(message)) {
            try {

                this.message = URLEncoder.encode(message, "utf-8");

            } catch (UnsupportedEncodingException e) {

                this.message = message;
            }
        }
    }

    public Result(String code, String message, boolean encode) {
        super();
        this.code = code;
        if (encode) {
            if (StringUtils.isNotBlank(message)) {
                try {

                    this.message = URLEncoder.encode(message, "utf-8");

                } catch (UnsupportedEncodingException e) {

                    this.message = message;
                }
            }
        } else {
            this.message = message;
        }
    }

    public Result(String code, String message, String token, String sign, T t) {
        super();
        this.code = code;
        if (StringUtils.isNotBlank(message)) {
            try {

                this.message = URLEncoder.encode(message, "utf-8");

            } catch (UnsupportedEncodingException e) {

                this.message = message;
            }
        }
        this.token = token;
        this.sign = sign;
        this.t = t;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(boolean decode) {
        if (decode) {
            if (StringUtils.isNotBlank(message)) {
                try {

                    return URLDecoder.decode(message, "utf-8");

                } catch (UnsupportedEncodingException e) {

                    return message;
                }
            } else
                return null;
        }
        return message;
    }

    public void setMessage(String message) {
        if (StringUtils.isNotBlank(message)) {
            try {

                this.message = URLEncoder.encode(message, "utf-8");

            } catch (UnsupportedEncodingException e) {

                this.message = message;
            }
        }
    }

    public void setMessage(String message, boolean encode) {

        if (encode) {
            if (StringUtils.isNotBlank(message)) {
                try {

                    this.message = URLEncoder.encode(message, "utf-8");

                } catch (UnsupportedEncodingException e) {

                    this.message = message;
                }
            }
        } else {
            this.message = message;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", message=" + message + ", token=" + token + ", sign=" + sign + ", t="
                + (null != t ? t.toString() : "") + "]";
    }

}
