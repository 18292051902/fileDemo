package com.example.filedemo.controller;

import com.example.filedemo.biz.stream.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* @Description:  流
* @Author: xukl
* @Date: 2021/9/17 14:00
*/
@RestController
@RequestMapping("/stream")
public class StreamController {
    @Autowired
    private StreamService streamService;

    @PostMapping("/test")
    public void test(){
        streamService.test();
    }


}
