package io.myhome.hss.common.constant;

public enum HouseSupportCode {
    SUPPORT_HOUSE("0"),
    CONVERTIBLE_RENTAL_HOUSE("1"),
    NOT_CONVERTIBLE_RENTAL_HOUSE("2")
    ;
    private String houseSupportCode;

    HouseSupportCode(String houseSupportCode) {
        this.houseSupportCode = houseSupportCode;
    }
}
