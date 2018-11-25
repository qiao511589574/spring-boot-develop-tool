package com.timocode.datavisualization.develop.storage.returnPackage;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一的返回类
 */
@Data
public class ResultBean<T> implements Serializable {
    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    public static final int NO_PERMISSION = 2;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        this.data = data;
    }

    public ResultBean(Throwable e){
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }
}
