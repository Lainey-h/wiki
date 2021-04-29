package com.lainey.wiki.exception;

public class BusinessException extends RuntimeException{

    private BusinessExceptionCode code;
// 当我们需要构造自定义异常的时候，需要把code传进来
    public BusinessException (BusinessExceptionCode code) {
        super(code.getDesc());
        this.code = code;
    }

    public BusinessExceptionCode getCode() {
        return code;
    }

    public void setCode(BusinessExceptionCode code) {
        this.code = code;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
