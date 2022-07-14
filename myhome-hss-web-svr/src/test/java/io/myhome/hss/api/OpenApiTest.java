package io.myhome.hss.api;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

public class OpenApiTest {

    private final static String OPEN_API_URL = "https://infuser.odcloud.kr/api/ApplhomeInfoDetailSvc/v1/";
    private final static String OPEN_API_SECRET = "1Rq2e/pCZvi6x/IIKgTEE1J/0/aBiCAsd4nlnaakn4PAk8wa2f9wU+eNyTWILyYceH0mc3hV5UPaOW2JG51j3g==";
    private final static String 아파트_분양정보_조회 = "getAPTLttotPblancDetail";
    private final static String 오피스텔_도시_민간_임대_분양정보_조회 = "getUrbtyOfctlLttotPblancDetail";
    private final static String 아파트_무순위_잔여_분양정보_조회 = "getRemndrLttotPblancDetail";

    private static WebClient getWebClient(Map<String, Object> paramMap) {
        String requestUrl = OPEN_API_URL + 아파트_분양정보_조회;
        if (!paramMap.isEmpty()) {
            requestUrl  = requestUrl + convertQueryString(paramMap);
        }
        return WebClient.builder()
                .defaultHeader("serviceKey", OPEN_API_SECRET)
                .build();
    }

    private static String convertQueryString(Map<String, Object> paramMap) {
        StringBuffer sb = new StringBuffer();

        sb.append("?");

        paramMap.forEach((key, value) -> sb.append(key).append("=").append(value));

        return sb.toString();
    }

    public static void main(String[] args) {
        Map<String, Object> paramMap = Map.of(
                "page", 1,
                "perPage", 10,
                "serviceKey", OPEN_API_SECRET
        );

        getWebClient(paramMap).get().uri(OPEN_API_URL, paramMap).retrieve().toEntity(Map.class)
                .log()
                .subscribe();
    }
}
