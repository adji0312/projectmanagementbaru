package project.ProjectManagement.integration.ad;

//import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ADGwResponse {
    @JsonProperty("ErrorSchema")
    public ErrorSchema ErrorSchema;
    @JsonProperty("OutputSchema")
    public Map<String, String> OutputSchema;
    // public OutputSchema OutputSchema;
}

class ErrorSchema {
    @JsonProperty("ErrorCode")
    public String ErrorCode;
    @JsonProperty("ErrorMessage")
    public Map<String, String> ErrorMessage;

}

class OutputSchema {
    @JsonProperty("Status")
    public String Status;
}

