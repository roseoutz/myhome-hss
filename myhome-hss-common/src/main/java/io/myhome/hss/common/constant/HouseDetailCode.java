package io.myhome.hss.common.constant;

public enum HouseDetailCode {
    URBAN_LIVING_HOUSE("01"),
    OFFICE_TEL("02"),
    PRIVATE_RENTAL("03"),
    PUBLIC_SUPPORT_RENTAL("03")
    ;

    private String houseDetailCode;

    HouseDetailCode(String houseDetailCode) {
        this.houseDetailCode = houseDetailCode;
    }
}
