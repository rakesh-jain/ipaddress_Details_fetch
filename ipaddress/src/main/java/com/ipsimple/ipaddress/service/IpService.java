package com.ipsimple.ipaddress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IpService {
    @Autowired
    private final RestTemplate restTemplate;

    public IpService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getIpAddress(){
        return restTemplate.getForObject("https://api-bdc.net/data/client-ip",String.class);
    }

    public String getIpDetails(){
        return restTemplate.getForObject("https://api.bigdatacloud.net/data/client-info",String.class);
    }

    public String isIRoaming() {
        return restTemplate.getForObject("https://api.bigdatacloud.net/data/am-i-roaming",String.class);

    }
    public String geoCoding() {
        return restTemplate.getForObject("https://api.bigdatacloud.net/data/reverse-geocode-client",String.class);

    }
}
