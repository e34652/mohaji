//import com.team1.mohaji.config.CustomUserDetails;
//import com.team1.mohaji.dto.myPage.RegListDto;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;//package com.team1.mohaji.controller;
//
//import com.team1.mohaji.dto.Dto;
//
//import com.team1.mohaji.service.Service;
//import com.team1.mohaji.service.imple.ServiceImple;
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
//@PostMapping("/regList")
//@ResponseBody
//public List<RegListDto> myList(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
//    if(userDetails != null){
//        int memberId = userDetails.getMemberId();
//        List<RegListDto> regList = regListServiceImple.regListInProgress(memberId);
//        model.addAttribute(regList)
//        return regList;
//    }else {
//        throw new NullPointerException("로그인 유저 정보가 없습니다");
//    }
