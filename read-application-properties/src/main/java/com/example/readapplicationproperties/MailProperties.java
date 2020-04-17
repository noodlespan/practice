package com.example.readapplicationproperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "mail")
public class MailProperties {
    private String hostName;
    private Integer port;
    private String from;

    private List<String> defaultRec;
    private Map<String,String> header;
    private Credentials credentials;
}
