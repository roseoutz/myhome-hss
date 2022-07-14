package io.myhome.hss.common.constant;

public enum AdjustAreaCode {
    OVERHEATED_AREA("Y"),
    UNTARGETED_HOUSE("N"),
    ATROPHY_AREA("S")
    ;
    private String adjustAreaCode;

    AdjustAreaCode(String adjustAreaCode) {
        this.adjustAreaCode = adjustAreaCode;
    }
}
