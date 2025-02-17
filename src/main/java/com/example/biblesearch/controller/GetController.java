package com.example.biblesearch.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.example.biblesearch.dto.MemberDTO;


@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }


    @GetMapping(value= "/name")
    public String getName(){
        return "Flature";
    }

    @GetMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param){
        StringBuilder sb= new StringBuilder();

        param.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }

}
