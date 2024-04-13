package com.ipsimple.ipaddress.controller;


import com.ipsimple.ipaddress.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/server")
public class IpController {
    @Autowired
    private final IpService ipService;

    public IpController(IpService ipService) {
        this.ipService = ipService;
    }
    @GetMapping(path = "/client/ip",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIpValue(){
        if(ipService.getIpAddress()==null){
            return ResponseEntity.badRequest().body("no data found");
        }
        return  ResponseEntity.ok().body(ipService.getIpAddress());
    }
    @GetMapping(path = "/client/ipdetails",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIpDetails(){
        if(ipService.getIpDetails()==null){
            return ResponseEntity.badRequest().body("no data found");
        }
        return  ResponseEntity.ok().body(ipService.getIpDetails());
    }

    @GetMapping(path = "/client/roaming")
    public ResponseEntity<?> isRoaming(){
        if(ipService.isIRoaming()==null){
            return ResponseEntity.badRequest().body("something wrong here please i try again later");
        }
        return ResponseEntity.ok().body(ipService.isIRoaming());
    }
    @GetMapping(path = "/client/geocoding")
    public ResponseEntity<?> geoCodingInfo(){
        if(ipService.geoCoding()==null){
            return ResponseEntity.badRequest().body("something wrong here please i try again later");
        }
        return ResponseEntity.ok().body(ipService.geoCoding());
    }

}
