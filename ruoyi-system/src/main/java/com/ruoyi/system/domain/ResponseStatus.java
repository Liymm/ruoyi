package com.ruoyi.system.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author gec
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResponseStatus {

        /**
         * 请求成功
         * */
        OK(20000,"SUCCESS！",1);

    private int code;
    private String msg;
    private int status;

}
