package com.fuint.framework.exception;

/**
 * 业务异常
 *
 * Created by FSQ
 * CopyRight https://www.fuint.cn
 */
public class BusinessCheckException extends Exception {
    private static final long serialVersionUID = 1L;

    private Throwable rootCause;

    public BusinessCheckException(String arg0) {
        super(arg0);
        this.errorKey = arg0;
        rootCause = this;
    }

    public BusinessCheckException() {
        super();
    }

    public BusinessCheckException(String s, Throwable e) {
        this(s);
        if (e instanceof BusinessCheckException) {
            rootCause = ((BusinessCheckException) e).rootCause;
        } else {
            rootCause = e;
        }
    }

    public BusinessCheckException(Throwable e) {
        this("", e);
    }

    public Throwable getRootCause() {
        return rootCause;
    }

    private String errorKey;

    public String getErrorKey() {
        return errorKey;
    }

    private String[] errorParam;

    private Object[] errorObjectParam;

    public Object[] getErrorObjectParam() {
        return errorObjectParam;
    }

    public void setErrorObjectParam(Object[] errorObjectParam) {
        this.errorObjectParam = errorObjectParam;
    }

    public BusinessCheckException(String key, Object[] objectParam) {
        this(key);
        this.errorObjectParam = objectParam;
    }

    public String[] getErrorParam() {
        return errorParam;
    }

    public void setErrorParam(String[] errorParam) {
        this.errorParam = errorParam;
    }
}
