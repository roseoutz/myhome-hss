package io.myhome.hss.common.constant;

public enum HouseTypeSearchCode {
    URBAN_LIVING("0201"),
    OFFICE_TEL("0202"),
    PRIVATE_RENTAL("0203"),
    PUBLIC_SUPPORT_RENTAL("0303")
    ;
    private String searchCode;
    HouseTypeSearchCode(String searchCode) {
        this.searchCode = searchCode;
    }
}
