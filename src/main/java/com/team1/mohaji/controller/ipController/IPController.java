package com.team1.mohaji.controller.ipController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Slf4j
public class IPController {

    private Set<String> ipAddressSet = new HashSet<>(); // 중복을 허용하지 않는 클라이언트 IP 주소를 저장할 Set

    @GetMapping("/myPC")
    public String showRegistrationPage(Model model) {
        // 등록된 IP 주소 Set를 리스트로 변환하여 모델에 추가하여 페이지에 전달
        System.out.println("여기도착완료");
        List<String> ipAddressList = new ArrayList<>(ipAddressSet);
        model.addAttribute("ipAddressList", ipAddressList);
        System.out.println(ipAddressList);
        return "view/myPage/myPC";
    }

    @PostMapping("/registerPC")
    public String registerPC(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }
        // 중복된 IP 주소인지 확인하고, 중복되지 않은 경우에만 추가
        if (!ipAddressSet.contains(ipAddress)) {
            ipAddressSet.add(ipAddress);
        }
        System.out.println(ipAddress);
        return "redirect:/myPC";
    }
}
