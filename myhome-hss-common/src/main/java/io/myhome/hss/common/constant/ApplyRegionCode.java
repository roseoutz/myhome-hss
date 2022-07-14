package io.myhome.hss.common.constant;

public enum ApplyRegionCode {
    EOUL(100),
    GANGWON(200),
    DAEJEON(300),
    CHOONGNAM(312),
    SEJONG(338),
    CHOONGBOOK(360),
    INCHEON(400),
    GEONGI(410),
    GWANGJU(500)
    ;

    private int regionCode;

    ApplyRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

}
