package com.example.linkedin_scrapper.clients;

import com.example.linkedin_scrapper.domains.entities.UserEntity;
import com.example.linkedin_scrapper.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Slf4j
public class EducationClient {
    public RestClient getRestClient(UserEntity user) {
        return RestClient.builder()
                .defaultHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:132.0) Gecko/20100101 Firefox/132.0")
                .defaultHeader("Accept", "application/vnd.linkedin.normalized+json+2.1")
                .defaultHeader("Accept-Language", "en-US,en;q=0.5")
                .defaultHeader("Accept-Encoding", "gzip, deflate, br, zstd")
                .defaultHeader("x-li-lang", "pt_BR")
                .defaultHeader("x-li-track", "{\"clientVersion\":\"1.13.26206\",\"mpVersion\":\"1.13.26206\",\"osName\":\"web\",\"timezoneOffset\":-3,\"timezone\":\"America/Sao_Paulo\",\"deviceFormFactor\":\"DESKTOP\",\"mpName\":\"voyager-web\",\"displayDensity\":1,\"displayWidth\":1920,\"displayHeight\":1080}")
                .defaultHeader("x-li-page-instance", "urn:li:page:d_flagship3_profile_view_base_education_details;OmuJTIoeQYuRvWQnnG3KSA==")
                .defaultHeader("csrf-token", "ajax:5281613647973076274")
                .defaultHeader("x-restli-protocol-version", "2.0.0")
                .defaultHeader("x-li-pem-metadata", "Voyager - Profile=view-education-details")
                .defaultHeader("Connection", "keep-alive")
                .defaultHeader("Referer", user.getLinkProfile() + "/details/education/")
                .defaultHeader("Cookie", "bcookie=\"v=2&dd15fc0b-3337-407c-84a0-e0c9a6c122d9\"; bscookie=\"v=1&202409221551572fbab6aa-add1-46e8-850c-f56b316cc919AQE2p8gM8KXk1-fDIY25uOUKEFq9cOGq\"; AMCV_14215E3D5995C57C0A495C55%40AdobeOrg=-637568504%7CMCIDTS%7C20036%7CMCMID%7C07424648146352512898887572084229809590%7CMCOPTOUT-1731188822s%7CNONE%7CvVersion%7C5.1.1; timezone=America/Sao_Paulo; li_theme=system; li_theme_set=user; UserMatchHistory=AQJXJdOn-HfLuwAAAZMSqO7tUzevO8FE0Hh2fZZpwTmfsjx1JpCTZIioN_vIfmwbuKRbaxlFToTKJO6B5epvzoQCv4w6yqKtaYlo7hpYFpfxCbZc1tUG5dMJ0mbN-DxsWIYa_olPuI75c_54ovDRQ6J206mYVlxRcyHUuZGKl5QdXLyynezgM7IWQdatn1-3C9Hp-bbu5kVsZtbm0xxq8KKe-4aGFc6gBKCmby10dBGo3u-hrgCe_NBZIRVitAS6FJ6ITm7ZOgmZGE2VPfLRQbIpvqLyXPLvArz99srMlm17mAdnPHZiaRQOPKdkQ9e08F_diqf_eo6MVzZQQioy; dfpfpt=9dfa658671d441b9987c7baf5b0e6ce9; li_rm=AQHiQVMs7jN69wAAAZI5OQnUxgq2FMLgvUaqUw2cCncn2cyfLBuUrrAJun019aBPOE1OtOdkEBq9MgxmK-3gxzOqQueZSWk8T21Ztuc7YJzciBPWJ-8i0tWk1C8KtmACQyFKoAanXG6OnDNAhMnSHf4yh8eC6jouxPxCqmGfEwvQ4f34PSv5xiMYgTI2_05KFIN97UGYsIHaRHAB-HvF50gpFIGqha1Hs8cH1C6-vtl--bD04tL0oRCHHc0Ojclwi9fpJ43xdj73yR174R3LsrbVPVm5VURNae3-RWMIM5_qr7OgOEVPNn5htNMjdiqh-ykmq6XbbD6rh4fkbnI; visit=v=1&M; g_state={\"i_l\":0}; JSESSIONID=\"ajax:5281613647973076274\"; liap=true; li_at=AQEDAVKA8HoEvcmLAAABkk_lzW4AAAGTI4qYdU0Av4qHCx9nnIcfri_dugOyWH-jug3n-lLzpB3vKZZQ-RMo4okQ9csmMdfZsIPV89oV857Ik07bWaO4qZmBewE9OIbVtqEbGOb6qRYesWN1DRzrl-Pw; lang=\"v=2&lang=pt-br\"; AMCVS_14215E3D5995C57C0A495C55%40AdobeOrg=1; fptctx2=taBcrIH61PuCVH7eNCyH0FFaWZWIHTJWSYlBtG47cVsLU53FKRWCT9GxTIpd4ZBUGTHwE%252bxSocqgiRXFNsyiwxoCvUVAizHOOfUajmBl1AGYNpSUeCNCSFUtFZB0QKoFLWI0iyqLc5MPSccTKb%252btqAR6S9VzfTkBR%252bY1WdyIdf7EG2OHyTlYORRwnvi97QF5XS1AcVtnPhxEH5c5Iq6m1CF51Hn3gNdkNoe%252fdTYiUzIFJE%252fxH41h6V9g0Ctj0lU687wFqaUlZnhOOtnxDyqRZIS%252bGWteXQmG9E7yDfuNej5y9Y0ZJeB36DYHC09RdyPqci43nYk6UcLxWYFmhtcqkiT0iWIh%252fia6ZWvms3A5kIM%253d; lidc=\"b=TB82:s=T:r=T:a=T:p=T:g=8448:u=9:x=1:i=1731276541:t=1731362941:v=2:sig=AQHqrOyb0qJRmUISlGS5iq8kO0NSgaE1\"; __cf_bm=g45KIwHcDt_25oxRp4GHTpsj9klJ7sv3vSueKg3BWYA-1731281951-1.0.1.1-rQZGFnv1l.Bvgx3v9Qq97o4Y6bRg81q7VNg3DVFX3VPwoxoGElz50JAvN6O6VVCNfoknu4.kkES89gCiwOa1Zg")
                .defaultHeader("Sec-Fetch-Dest", "empty")
                .defaultHeader("Sec-Fetch-Mode", "cors")
                .defaultHeader("Sec-Fetch-Site", "same-origin")
                .defaultHeader("TE", "trailers")
                .build();
    }

    public String execRestClient(RestClient restClient, String linkedinId) {
        log.info("retrieving education of linkedinId: {}", linkedinId);
        return restClient
                .get()
                .uri("https://www.linkedin.com/voyager/api/graphql?includeWebMetadata=true&variables=(profileUrn:urn%3Ali%3Afsd_profile%3{linkedinId},sectionType:education,locale:pt_BR)&queryId=voyagerIdentityDashProfileComponents.8870d56cb9c3fc30759e093dff132b3e", linkedinId)
                .retrieve()
                .body(String.class);
//        return Utils.retornaJson("jsons/education_chrys.json");
    }
}