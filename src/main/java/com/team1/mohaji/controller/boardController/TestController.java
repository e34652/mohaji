//package com.team1.mohaji.controller.boardController;
//
//import com.team1.mohaji.dto.Dto;
//
//import com.team1.mohaji.service.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.io.IOException;
//import java.util.List;
//
//@Controller
//public class TestController {
//    @Autowired
//    private Service service;
//
//    @GetMapping("/test/main")
//    public String main(){
//        return "/view/gridTest";
//    }
//
//
//    @ResponseBody
//    @PostMapping("/test/getList")
//    public List<Dto> getList() throws IOException{
//        List<Dto> result = service.selectMemberList();
//        return result;
//    }
//}
