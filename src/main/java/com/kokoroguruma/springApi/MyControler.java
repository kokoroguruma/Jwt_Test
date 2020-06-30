package com.kokoroguruma.springApi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MyControler {


    @RequestMapping(value = "/test1")
    public Object test1(
            
            @RequestHeader(name = "head1", required = false) String  head1,
            @RequestParam(name = "data1", defaultValue = "") String data1,
            Model model,
            String aaa
            ) {

        log.info("[start]:test1", head1, data1);

        System.out.println("----------------------------------------");
        System.out.println("head1: " + head1);
        System.out.println("data1: " + data1);
        System.out.println("----------------------------------------");


        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("head1", head1);
        resultMap.put("data1", data1);

        model.addAllAttributes(resultMap);


        return "test1";
    }




}
