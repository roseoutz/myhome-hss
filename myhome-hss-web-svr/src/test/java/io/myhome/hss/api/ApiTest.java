package io.myhome.hss.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class ApiTest {
    private final static String OPEN_API_URL = "https://api.odcloud.kr/api/ApplyhomeInfoDetailSvc/v1/";
    private final static String OPEN_API_SECRET = "1Rq2e%2FpCZvi6x%2FIIKgTEE1J%2F0%2FaBiCAsd4nlnaakn4PAk8wa2f9wU%2BeNyTWILyYceH0mc3hV5UPaOW2JG51j3g%3D%3D";
    private final static String getAPTLttotPblancDetail = "getAPTLttotPblancDetail";
    private final static String getUrbtyOfctlLttotPblancDetail = "getUrbtyOfctlLttotPblancDetail";
    private final static String getRemndrLttotPblancDetail = "getRemndrLttotPblancDetail";

    private HttpClient getHttpClient() {
        return HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(3))
                .build();
    }

    private String convertQueryString(Map<String, Object> paramMap) {
        StringBuffer sb = new StringBuffer();
        sb.append("?");

        paramMap.forEach((key, value) -> sb.append(key).append("=").append(value).append("&"));

        return sb.toString();
    }

    private HttpResponse<String> get(String uri, Map<String, String> headerMap) throws IOException, InterruptedException {
        HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder(URI.create(uri))
                .timeout(Duration.ofSeconds(5))
                .GET();

        if (headerMap != null && !headerMap.isEmpty()) {
            headerMap.forEach(httpRequestBuilder::setHeader);
        }

        return getHttpClient().send(httpRequestBuilder.build(), HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
    }

    @Test
    void get_info_test() throws IOException, InterruptedException {
        Map<String, Object> paramMap = Map.of(
                "page", 1,
                "perPage", 10,
                "serviceKey", OPEN_API_SECRET
        );

        String data = get( OPEN_API_URL + getAPTLttotPblancDetail + convertQueryString( paramMap), null).body();
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseData responseData = objectMapper.readValue(data, ResponseData.class);
        Assertions.assertNotNull(responseData);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseData {
        public ResponseData() {

        }
        @JsonProperty("page")
        private int page;
        @JsonProperty("perPage")
        private int perPage;
        @JsonProperty("totalCount")
        private int totalCount;
        @JsonProperty("currentCount")
        private int currentCount;
        @JsonProperty("matchCount")
        private int matchCount;
        @JsonProperty("data")
        private List<ApplyHomeInfo> applyHomeInfos;

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ApplyHomeInfo {
        public ApplyHomeInfo() {}
        @JsonProperty("HOUSE_MANAGE_NO")
        private int manageNo;
        @JsonProperty("PBLANC_NO")
        private int pblancNo;
        @JsonProperty("HOUSE_NM")
        private String name;
        @JsonProperty("HOUSE_SECD")
        private String sectionCode;
        @JsonProperty("HOUSE_SECD_NM")
        private String sectionCodeName;
        @JsonProperty("HOUSE_DTL_SECD")
        private String detailSectionCode;
        @JsonProperty("HOUSE_DTL_SECD_NM")
        private String detailSectionCodeName;
        @JsonProperty("RENT_SECD")
        private String rentSectionCode;
        @JsonProperty("REND_SECD_NM")
        private String rentSectionCodeName;
        @JsonProperty("SUBSCRPT_AREA_CODE")
        private String supplyAreaCode;
        @JsonProperty("SUBSCRPT_AREA_CODE_NM")
        private String supplyAreaCodeName;
        @JsonProperty("HSSPLY_ZIP")
        private String supplyAreaZipCode;
        @JsonProperty("HSSPLY_ADRES")
        private String supplyAreaAddress;
        @JsonProperty("TOT_SUPLY_HSHLDCO")
        private String supplyTotalArea;
        @JsonProperty("RCRIT_PBLAC_DE")
        private String recruitHouseDate;
        @JsonProperty("RECEPT_BGNDE")
        private String subscriptionBeginDate;
        @JsonProperty("RECEPT_ENDDE")
        private String subscriptionEndDate;
        @JsonProperty("SPSPLY_RCEPT_BGNDE")
        private String specialSubscriptionBeginDate;
        @JsonProperty("SPSPLY_RCEPT_ENEDE")
        private String specialSubscriptionEndDate;
        @JsonProperty("GNRL_RNK1_CRSPAREA_RCEPT_PD")
        private String fisrtRegistrationDateRegion;
        @JsonProperty("GNRL_RNK1_ETC_GG_RCPTDE_PD")
        private String firstRegistrationGGRegion;
        @JsonProperty("GNRL_RNK1_ETC_AREA_RCPTDE_PD")
        private String firstRegistrationEtcRegion;
        @JsonProperty("GNRL_RNK2_CRSPAREA_RCEPT_PD")
        private String secondRegistrationDateRegion;
        @JsonProperty("GNRL_RNK2_ETC_GG_RCPTDE_PD")
        private String secondRegistrationGGRegion;
        @JsonProperty("GNRLRNK2_ETC_AREA_RCPTDE_PD")
        private String secondRegistrationEtcRegion;
        @JsonProperty("PRZWNER_PRESNATN_DE")
        private String announcementDate;
    }
}
