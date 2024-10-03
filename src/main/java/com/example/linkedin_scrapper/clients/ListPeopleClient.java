package com.example.linkedin_scrapper.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ListPeopleClient implements IClient {
    @Override
    public RestClient getRestClient() {
        return RestClient.builder()
                .defaultHeader("accept", "application/vnd.linkedin.normalized+json+2.1")
                .defaultHeader("accept-language", "en-US,en;q=0.9")
                .defaultHeader("cookie", "bcookie=\"v=2&bbc2dbef-d1e4-40e4-8a87-3a46bc9ee6e3\"; bscookie=\"v=1&20240922200257dc31583b-4819-4106-815d-e3c822446491AQFY2qBlPRJFQQKz0ikBMVN0FwOZ_gIp\"; AMCVS_14215E3D5995C57C0A495C55%40AdobeOrg=1; aam_uuid=06788333209324291891685683794077001508; g_state={\"i_l\":0}; liap=true; li_at=AQEDAVKA8HoFeHyOAAABkhtUxZsAAAGSP2FJm1YABor0m1b7jInIbQPb04V3xYaZQesdFQaBF6TH0Q9VjZ8amU_bQiriBh9D0FuVyHSQHuJc000SRgcj5f0eU366ieEs1dcYyBi7Jmrz9H--xLUyEyxi; JSESSIONID=\"ajax:0612869958973341761\"; timezone=America/Sao_Paulo; li_theme=light; li_theme_set=app; li_sugr=a5088b8a-035b-4ba2-bc6c-b749cdbff55f; _guid=58940cf4-0c14-492d-9406-bb2fc54ee605; AnalyticsSyncHistory=AQJS76T_8K9pBwAAAZIbVNdu6jW266-niejiZoc3-ZA9ImJwOPsgwqz3WXaw7ZGkgtaiWoBV05coxG3hJfeM5g; lms_ads=AQFaBinwbEKDUwAAAZIbVNh2JV_LMuzk2c5_cvBJT_RMrwFun_9ExqHPIsl_l8a-GXsVM0BIVaemJgj2xLTvhS3F4YvQ4_c5; lms_analytics=AQFaBinwbEKDUwAAAZIbVNh2JV_LMuzk2c5_cvBJT_RMrwFun_9ExqHPIsl_l8a-GXsVM0BIVaemJgj2xLTvhS3F4YvQ4_c5; dfpfpt=78fed44cdf8042679224442f8bb3ffe7; fptctx2=taBcrIH61PuCVH7eNCyH0J9Fjk1kZEyRnBbpUW3FKs%252fZadVzCF%252bSLaqN2%252f13i7oSleBYfWciJuHEHRTSbyOd4HV3xqixeHtem8%252bqr3CoA6HWkPgBuf4wV0uCJKEgz3qlyvah%252fiSaIKYiPVAWNJCg2pj1oRY%252fvzmbmiEK81cQ1TG24%252bRxeWPdifISVH%252fF%252bszG250AqpPDklfx3g0bgFRovWF55LTvqPFBpEXEfZerElobWkwDn9gWuPg0MapA1SQFupsVY54jX1uEY3miJYKQreTyK3kH%252feQU0EnI2%252fWDOi6gElprifVbwwCodRqjQ6l0vr0z6W5gZbDxCz75OBrOEcSwnKRZcHvz67VzPV6%252fJJQ%253d; AMCV_14215E3D5995C57C0A495C55%40AdobeOrg=-637568504%7CMCIDTS%7C19989%7CMCMID%7C06948522633285299981705719969853297903%7CMCAAMLH-1727647388%7C4%7CMCAAMB-1727647388%7C6G1ynYcLPuiQxYZrsz_pkqfLG9yMXBpb2zX5dvJdYQJzPXImdj0y%7CMCOPTOUT-1727049788s%7CNONE%7CvVersion%7C5.1.1%7CMCCIDH%7C1921669772; PLAY_LANG=pt; lang=v=2&lang=pt-BR; PLAY_SESSION=eyJhbGciOiJIUzI1NiJ9.eyJkYXRhIjp7InNlc3Npb25faWQiOiJjNmUxNmViZC1hNTFmLTRiZmMtYTgyNC0xNDZmZjM5ZTA0Yzl8MTcyNzA0Mjg0NiIsImFsbG93bGlzdCI6Int9IiwicmVjZW50bHktc2VhcmNoZWQiOiIiLCJyZWZlcnJhbC11cmwiOiJodHRwczovL3d3dy5saW5rZWRpbi5jb20vaGVscC9saW5rZWRpbi9hbnN3ZXIvYTUyMDUwNC9hY2NvdW50LW5ldHdvcmstYmxvY2tlZCUzRmxhbmclM0RlbiIsInJlY2VudGx5LXZpZXdlZCI6IiIsIkNQVC1pZCI6IsKCwppuw4vCqsOcwplFw4RVacK1XHLDq2_DoyIsImV4cGVyaWVuY2UiOiIiLCJ0cmsiOiIifSwibmJmIjoxNzI3MDQyODQ2LCJpYXQiOjE3MjcwNDI4NDZ9.HWAVK5rvRQ4b6Tm0AdUcSTOTv6LFCFuj8NijLw_7z94; UserMatchHistory=AQKf58m6GnhFuAAAAZIb3_w4aiR_FZrelBLYcGm8C84U857nZGvCr0UKdB3F8GkqPIrPnyvewE4EH8yK2ujFZKYo5QXfpFiLT60V_WgY9wbGOzxGu32892iqB2c-X276Bn13_SjRuZGaQ1zIAWYeFUD3E-2s3zHakmS-h3ASf6llYbxPUxsoYPtZk-IOkMGMK6EtVVzKBR3mSLi02zxkwPMaiAHz_McOOrc9Ncpu1cvNUhG-WfACbw9CZ7Eqxlm5n7_Kasp2IPYqxB0tx_sQT5_KsiAVl8YPB8uT1osH6gWvffTxUOiJ4CXQ79eACMKgy7F6Y8v75IljgovfSoHjKy-KSzd776B3B00QkAxWpRhnZ43qBA; lidc=\"b=TB82:s=T:r=T:a=T:p=T:g=8392:u=4:x=1:i=1727044519:t=1727121499:v=2:sig=AQH0BmpRFe2rLVPErTSwe7soffq6h8HZ\"; __cf_bm=to4_axa2GANOfZHD2gbB89BFbpvUYo1ANusvNKZrtZw-1727319050-1.0.1.1-WNf1c8yiZ20ttiLxMMYsxfihidZD0_UagdFmpqeYBzLxzfndvrOB3jrqbaCWZYx1ovAObptODlA4tMEvmrgqDg; lidc=\"b=VB82:s=V:r=V:a=V:p=V:g=9440:u=5:x=1:i=1727319049:t=1727320909:v=2:sig=AQHJ_aOzqgDiv4GGaSnwO_EkEngheQED\"")
                .defaultHeader("csrf-token", "ajax:0612869958973341761")
                .defaultHeader("dnt", "1")
                .defaultHeader("priority", "u=1, i")
                .defaultHeader("referer", "https://www.linkedin.com/school/centrouniversitariosenac/people/")
                .defaultHeader("sec-ch-ua", "\"Google Chrome\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129\"")
                .defaultHeader("sec-ch-ua-mobile", "?0")
                .defaultHeader("sec-ch-ua-platform", "\"Linux\"")
                .defaultHeader("sec-fetch-dest", "empty")
                .defaultHeader("sec-fetch-mode", "cors")
                .defaultHeader("sec-fetch-site", "same-origin")
                .defaultHeader("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36")
                .defaultHeader("x-li-lang", "pt_BR")
                .defaultHeader("x-li-page-instance", "urn:li:page:d_flagship3_university;2zteXoiJSWqifTPxWF/2tg==")
                .defaultHeader("x-li-pem-metadata", "Voyager - Organization - Member=organization-people-card")
                .defaultHeader("x-li-track", "{\"clientVersion\":\"1.13.23589\",\"mpVersion\":\"1.13.23589\",\"osName\":\"web\",\"timezoneOffset\":-3,\"timezone\":\"America/Sao_Paulo\",\"deviceFormFactor\":\"DESKTOP\",\"mpName\":\"voyager-web\",\"displayDensity\":1,\"displayWidth\":1920,\"displayHeight\":1080}")
                .defaultHeader("x-restli-protocol-version", "2.0.0")
                .defaultHeader("Accept-Encoding", "gzip, deflate, br")
                .defaultHeader("Connection", "keep-alive")
                .build();
    }

    public String execRestClient(RestClient restClient, Integer start) {
        return restClient
                .get()
                .uri("https://www.linkedin.com/voyager/api/graphql?variables=(start:{start},origin:FACETED_SEARCH,query:(flagshipSearchIntent:ORGANIZATIONS_PEOPLE_ALUMNI,queryParameters:List((key:resultType,value:List(ORGANIZATION_ALUMNI)),(key:schoolFilter,value:List(11354076))),includeFiltersInResponse:false),count:12)&queryId=voyagerSearchDashClusters.dec2e0cf0d4c89523266f6e3b44cc87c", start)
                .retrieve()
                .body(String.class);
    }

    public String execRestClient(RestClient restClient, Integer start, Integer school) {
        return restClient
                .get()
                .uri("https://www.linkedin.com/voyager/api/graphql?variables=(start:{start},origin:FACETED_SEARCH,query:(flagshipSearchIntent:ORGANIZATIONS_PEOPLE_ALUMNI,queryParameters:List((key:resultType,value:List(ORGANIZATION_ALUMNI)),(key:schoolFilter,value:List({school}))),includeFiltersInResponse:false),count:12)&queryId=voyagerSearchDashClusters.dec2e0cf0d4c89523266f6e3b44cc87c", start, school)
                .retrieve()
                .body(String.class);
    }
}
