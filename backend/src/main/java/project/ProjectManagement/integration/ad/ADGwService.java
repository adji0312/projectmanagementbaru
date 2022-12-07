//package project.ProjectManagement.integration.ad;
//
//import java.net.ConnectException;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpStatusCodeException;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//import project.ProjectManagement.security.TripleDesEncoder;
//
////import id.co.bca.bnos.security.TripleDesEncoder;
//
//@Service
//public class ADGwService {
//    private static final Logger LOG = LoggerFactory.getLogger(ADGwService.class);
//
//    @Value("${bnos.interface.ad.verify.uri}")
//    private String verifyUri;
//
//    @Value("${bnos.interface.ad.ldap.path.uri}")
//    private String ldapPathUri;
//
//    @Value("${bnos.interface.ad.client-id}")
//    private String clientId;
//
//    @Value("${bnos.interface.ad.app-id}")
//    private String appId;
//
//    @Value("${bnos.interface.ad.key-id}")
//    private String keyId;
//
//    private final RestTemplate restTemplate;
//
//    public ADGwService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public boolean verify(String userId, String password) {
//        String encPasswd = TripleDesEncoder.encrypt(password, keyId);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("ClientID", clientId);
//
//        ADGwRequest request = new ADGwRequest();
//        request.ApplicationID = appId;
//        request.UserID = userId;
//        request.Password = encPasswd;
//
//        HttpEntity<ADGwRequest> httpEntity = new HttpEntity<ADGwRequest>(request, headers);
//        ResponseEntity<ADGwResponse> response = null;
//        try {
//            response = restTemplate.exchange(verifyUri, HttpMethod.POST, httpEntity, ADGwResponse.class);
//            ADGwResponse body = response.getBody();
//            ErrorSchema errorSchema = body.ErrorSchema;
//            LOG.debug("verify success = " + response.getStatusCode());
//            LOG.debug("errorSchema.ErrorCode = " + errorSchema.ErrorCode);
//            LOG.debug("errorSchema.ErrorMessage = " + errorSchema.ErrorMessage);
//            return true;
//        } catch (HttpStatusCodeException e) {
//            LOG.debug("verify error = " + e.getMessage());
//            LOG.debug("status code = " + e.getStatusCode());
//            ADGwResponse body = null;
//            try {
//                body = new ObjectMapper().readValue(e.getResponseBodyAsString(), ADGwResponse.class);
//            } catch (JsonMappingException je) {
//                LOG.error("Mapping response body to JSON error", je);
//            } catch (JsonProcessingException pe) {
//                LOG.error("Processing response body to JSON error", pe);
//            }
//            ErrorSchema errorSchema = body.ErrorSchema;
//            LOG.debug("errorSchema.ErrorCode = " + errorSchema.ErrorCode);
//            LOG.debug("errorSchema.ErrorMessage = " + errorSchema.ErrorMessage);
//            return false;
//        } catch (RestClientException e) {
//            LOG.error("Rest client error: {}", e.getMessage());
//            return false;
//        } catch (Exception e) {
//            LOG.error("Error: {}", e.getMessage());
//            return false;
//        }
//    }
//
//
//    public boolean isUserExist(String userId) {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("ClientID", clientId);
//
//        ADGwRequest request = new ADGwRequest();
//        request.UserID = userId;
//
//        HttpEntity<ADGwRequest> httpEntity = new HttpEntity<ADGwRequest>(request, headers);
//        ResponseEntity<ADGwResponse> response = null;
//        try {
//            response = restTemplate.exchange(ldapPathUri, HttpMethod.POST, httpEntity, ADGwResponse.class);
//            ADGwResponse body = response.getBody();
//            ErrorSchema errorSchema = body.ErrorSchema;
//            LOG.debug("verify success = " + response.getStatusCode());
//            LOG.debug("errorSchema.ErrorCode = " + errorSchema.ErrorCode);
//            LOG.debug("errorSchema.ErrorMessage = " + errorSchema.ErrorMessage);
//            return true;
//        } catch (HttpStatusCodeException e) {
//            LOG.debug("verify error = " + e.getMessage());
//            LOG.debug("status code = " + e.getStatusCode());
//            ADGwResponse body = null;
//            try {
//                body = new ObjectMapper().readValue(e.getResponseBodyAsString(), ADGwResponse.class);
//            } catch (JsonMappingException je) {
//                LOG.error("Mapping response body to JSON error", je);
//            } catch (JsonProcessingException pe) {
//                LOG.error("Processing response body to JSON error", pe);
//            }
//            ErrorSchema errorSchema = body.ErrorSchema;
//            LOG.debug("errorSchema.ErrorCode = " + errorSchema.ErrorCode);
//            LOG.debug("errorSchema.ErrorMessage = " + errorSchema.ErrorMessage);
//
//            return false;
//        } catch (RestClientException e) {
//            LOG.error("Call AD Gateway service error", e);
//            return false;
//        }
//    }
//
//}
