package com.kokoroguruma.springApi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControlerApi {



    @RequestMapping(value = "/testApi01",
            method = RequestMethod.POST,
            produces = "application/json"
            )
    public Object test1(
            @RequestHeader(name = "head1", required = false) String  head1,
            @RequestHeader(name = "head2", required = false) String  head2,
            @RequestParam(name = "data1", defaultValue = "") String data1,
            @RequestParam(name = "data2", defaultValue = "") String data2,
            @RequestParam(name = "data3", defaultValue = "") String data3,
            Model model,
            String aaa
            ) {

        System.out.println("----------------------------------------");
        System.out.println("head1: " + head1);
        System.out.println("head2: " + head2);
        System.out.println("data1: " + data1);
        System.out.println("data2: " + data2);
        System.out.println("data3: " + data3);
        System.out.println("----------------------------------------");
        System.out.println(System.getProperty("file.encoding"));
//        try {
//            System.out.println("----------------------------------------");
//            System.out.println(URLEncoder.encode(head2));
//            System.out.println(URLEncoder.encode(head2,"UTF-8"));
//            System.out.println(URLEncoder.encode(head2,"Shift-JIS"));
//            System.out.println(URLDecoder.decode(head2));
//            System.out.println(URLDecoder.decode(head2,"UTF-8"));
//            System.out.println(URLDecoder.decode(head2,"Shift-JIS"));
//            System.out.println("----------------------------------------");
//            System.out.println(URLDecoder.decode(URLEncoder.encode(head2,"Shift-JIS"),"UTF-8"));
//            System.out.println("----------------------------------------");
//        } catch (UnsupportedEncodingException e1) {
//            // TODO 自動生成された catch ブロック
//            e1.printStackTrace();
//        }
//        try {
//            System.out.println(new String(head2.getBytes("Shift-JIS"),"UTF-8"));
//            System.out.println(new String(head2.getBytes("UTF-8"),"Shift-JIS"));
//        } catch (UnsupportedEncodingException e) {
//            // TODO 自動生成された catch ブロック
//            e.printStackTrace();
//        }
//        System.out.println(head2.equals(new String(bytes, "UTF-8")));
//        System.out.println("head2: " + head2.);
        System.out.println("----------------------------------------");


        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("head1", head1);
        resultMap.put("head2", head2);
        resultMap.put("data1", data1);
        resultMap.put("data2", data2);
        resultMap.put("data3", data3);

        model.addAllAttributes(resultMap);


        return resultMap;
//        return "ああああああああ";
    }



}
