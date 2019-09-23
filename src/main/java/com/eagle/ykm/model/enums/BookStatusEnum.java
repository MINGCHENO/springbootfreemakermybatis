package com.eagle.ykm.model.enums;

/**
 * @description 书的状态
 * @auth YKM
 * @date 2019/9/21 14:18
 **/
public enum BookStatusEnum {
    NORMAL(0),
    DELETE(1),
    RECOMMENDED(2),
    ;
    private int value;

    BookStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}