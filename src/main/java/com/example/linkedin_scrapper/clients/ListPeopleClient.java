package com.example.linkedin_scrapper.clients;

import com.example.linkedin_scrapper.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Slf4j
public class ListPeopleClient {
    public RestClient getRestClient(Integer year) {
        return RestClient.builder()
                .defaultHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:132.0) Gecko/20100101 Firefox/132.0")
                .defaultHeader("Accept", "application/vnd.linkedin.normalized+json+2.1")
                .defaultHeader("Accept-Language", "en-US,en;q=0.5")
                .defaultHeader("Accept-Encoding", "gzip, deflate, br, zstd")
                .defaultHeader("x-li-lang", "pt_BR")
                .defaultHeader("x-li-track", "{\"clientVersion\":\"1.13.26206\",\"mpVersion\":\"1.13.26206\",\"osName\":\"web\",\"timezoneOffset\":-3,\"timezone\":\"America/Sao_Paulo\",\"deviceFormFactor\":\"DESKTOP\",\"mpName\":\"voyager-web\",\"displayDensity\":1,\"displayWidth\":1920,\"displayHeight\":1080}")
                .defaultHeader("x-li-page-instance", "urn:li:page:schools_school_people_index;3a6b894c-8a1e-418b-91bd-64279c6dca48")
                .defaultHeader("csrf-token", "ajax:5281613647973076274")
                .defaultHeader("x-restli-protocol-version", "2.0.0")
                .defaultHeader("x-li-pem-metadata", "Voyager - Organization - Member=organization-people-card")
                .defaultHeader("Connection", "keep-alive")
                .defaultHeader("Referer", "https://www.linkedin.com/school/centrouniversitariosenac/people/?educationEndYear=" + year + "&educationStartYear=" + year)
                .defaultHeader("Cookie", "bcookie=\"v=2&dd15fc0b-3337-407c-84a0-e0c9a6c122d9\"; bscookie=\"v=1&202409221551572fbab6aa-add1-46e8-850c-f56b316cc919AQE2p8gM8KXk1-fDIY25uOUKEFq9cOGq\"; AMCV_14215E3D5995C57C0A495C55%40AdobeOrg=-637568504%7CMCIDTS%7C20039%7CMCMID%7C07424648146352512898887572084229809590%7CMCOPTOUT-1731294339s%7CNONE%7CvVersion%7C5.1.1; timezone=America/Sao_Paulo; li_theme=system; li_theme_set=user; UserMatchHistory=AQKJKsPvl01nOAAAAZMYeBubUij4_a2WmN-GFHJfq8LfIBPSk-ZnBP-bYZ9gcrerf4OGFUAAxiXqWLXkR_vJUGlLUh_d7spTLONvJWGv67LeyoyomOO9_eZ5opVU_jA-ifORskVTCHsTAIOULXL8TcDEw9-zk-hGP82qzHvyWhZuflz5_Z77zxHeXWtisjw4TFUbepIt5RUNQDPVW21PR-B-x6rpiMc12L4hTHUGHb1afYfc6uJEGDO1MbVfD4F5QQLHXlKf43N1F6dS4dscKc8khgjO5vx1zI0aStqiJYGrTumFzWoNKgaxd-LiJblxukOFGMQ_P_ZFn7CmuYMo; dfpfpt=9dfa658671d441b9987c7baf5b0e6ce9; li_rm=AQHiQVMs7jN69wAAAZI5OQnUxgq2FMLgvUaqUw2cCncn2cyfLBuUrrAJun019aBPOE1OtOdkEBq9MgxmK-3gxzOqQueZSWk8T21Ztuc7YJzciBPWJ-8i0tWk1C8KtmACQyFKoAanXG6OnDNAhMnSHf4yh8eC6jouxPxCqmGfEwvQ4f34PSv5xiMYgTI2_05KFIN97UGYsIHaRHAB-HvF50gpFIGqha1Hs8cH1C6-vtl--bD04tL0oRCHHc0Ojclwi9fpJ43xdj73yR174R3LsrbVPVm5VURNae3-RWMIM5_qr7OgOEVPNn5htNMjdiqh-ykmq6XbbD6rh4fkbnI; visit=v=1&M; g_state={\"i_l\":0}; JSESSIONID=\"ajax:5281613647973076274\"; liap=true; li_at=AQEDAVKA8HoEvcmLAAABkk_lzW4AAAGTI4qYdU0Av4qHCx9nnIcfri_dugOyWH-jug3n-lLzpB3vKZZQ-RMo4okQ9csmMdfZsIPV89oV857Ik07bWaO4qZmBewE9OIbVtqEbGOb6qRYesWN1DRzrl-Pw; lang=\"v=2&lang=pt-br\"; AMCVS_14215E3D5995C57C0A495C55%40AdobeOrg=1; fptctx2=taBcrIH61PuCVH7eNCyH0FFaWZWIHTJWSYlBtG47cVsLU53FKRWCT9GxTIpd4ZBUGTHwE%252bxSocqgiRXFNsyiwxoCvUVAizHOOfUajmBl1AGYNpSUeCNCSFUtFZB0QKoFLWI0iyqLc5MPSccTKb%252btqMMPeVPnpiBdMU%252fFHLKj9NSF4%252f0fb%252bOpIQ4mpgFjNMpRyBL29OEMrqgE8m4iahF1c7rLRgvuTanJhQGYpUaKZWXeeOicTc12e8DmyM3C0tr2hPdCj%252byS065%252bVizstRNIsFDVO%252b99E3wsYJH%252bY8bbi0NrQMSZ1P39K%252bisyilfIkYEAb%252bS2FT3GEmpn17pKjCfhKr1wiz5%252bYirO4y9Xr8JsTI%253d; lidc=\"b=TB82:s=T:r=T:a=T:p=T:g=8448:u=9:x=1:i=1731276541:t=1731362941:v=2:sig=AQHqrOyb0qJRmUISlGS5iq8kO0NSgaE1\"; __cf_bm=DB9.Vyq5S1DJuO82XIhsGfKXmtPHNph7v8GzwVc_xCM-1731286460-1.0.1.1-Z4Aq3yl6A4H5rMmvdjXpKrH4Y649NtlORApFcBOy1tjUndechN5CvrtVeWPPHMcE8EWsrtl76QYpt8bjN3SeOQ")
                .defaultHeader("Sec-Fetch-Dest", "empty")
                .defaultHeader("Sec-Fetch-Mode", "cors")
                .defaultHeader("Sec-Fetch-Site", "same-origin")
                .defaultHeader("TE", "trailers")
                .build();
    }

    public String execRestClient(RestClient restClient, Integer year, Integer start) {
        log.info("execRestClient year: {} start: {}", year, start);
        return restClient
                .get()
                .uri("https://www.linkedin.com/voyager/api/graphql?variables=(start:{start},origin:FACETED_SEARCH,query:(flagshipSearchIntent:ORGANIZATIONS_PEOPLE_ALUMNI,queryParameters:List((key:educationEndYear,value:List({year})),(key:educationStartYear,value:List({year})),(key:resultType,value:List(ORGANIZATION_ALUMNI)),(key:schoolFilter,value:List(11354076))),includeFiltersInResponse:false),count:12)&queryId=voyagerSearchDashClusters.8c4c84e04746a876c20b1eb6cd899df0", start, year, year)
                .retrieve()
                .body(String.class);
//        return Utils.retornaJson("jsons/lista.json");
    }
}