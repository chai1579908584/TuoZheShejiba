package com.example.tz.tuozhe.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tz on 2018/4/10.
 */
public class Loginout implements Serializable {

    /**
     * code : 1
     * data : []
     * message : 退出成功
     */

    private String code;
    private String message;
    private List<?> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}

