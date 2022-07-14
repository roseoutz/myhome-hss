package io.myhome.hss.common.constant;

public enum HouseTypcode {
    APT("01"),
    OFFICE_TEL("02"),
    PUBLIC_SUPPORT_RENTAL("03"),
    UNRANKED("04"),
    REMAINING("04"),
    CONTRACT_CANCELED("6")
    ;

    private String HouseTypeCode;

    HouseTypcode(String houseTypeCode) {
        this.HouseTypeCode = houseTypeCode;
    }
}
