package project.ProjectManagement.integration.ad;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ADGwRequest {
    @JsonProperty("ApplicationID")
    public String ApplicationID;
    @JsonProperty("UserID")
    public String UserID;
    @JsonProperty("Password")
    public String Password;
}
