package com.team1.mohaji.controller.ipController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class IPController {

    private Set<String> ipAddressSet = new HashSet<>(); // 중복을 허용하지 않는 클라이언트 IP 주소를 저장할 Set
    private List<String> ipAddressList = new ArrayList<>(); // 등록된 IP 주소를 보관할 리스트

    @GetMapping("/myPC")
    public String showRegistrationPage(Model model) {
        // 등록된 IP 주소 Set를 리스트로 변환하여 클래스 수준의 ipAddressList에 저장하고, 모델에 추가하여 페이지에 전달
        ipAddressList = new ArrayList<>(ipAddressSet);
        model.addAttribute("ipAddressList", ipAddressList);
        System.out.println("여기도착완료");
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

    @PostMapping("/deletePC")
    public String deletePC(@RequestParam("index") int index) {
        if (index >= 0 && index < ipAddressList.size()) {
            ipAddressSet.remove(ipAddressList.get(index));
        }
        return "redirect:/myPC";
    }
}
