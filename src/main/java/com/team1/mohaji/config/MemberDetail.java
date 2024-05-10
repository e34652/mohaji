package com.team1.mohaji.config;

import com.team1.mohaji.entity.Member;
import com.team1.mohaji.repository.MemberRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class MemberDetail implements UserDetails {
    private Member member;
    private MemberRepository memberRepository; // MemberRepository 주입

    public MemberDetail(Member member) {
        this.member = member;
    }

    // 권한 정보를 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add(() -> {
            return member.getRole().name();
        });

        return collections;
    }

    // 토큰 기반 인증일 경우 null 반환
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getLoginId();
    }


    // 아래의 옵션들로 Spring Security가 발생시킨다.
    // false일 경우 인증을 허용하지 않고 사용자는 권한을 얻지못해 엑세스를 못함
    @Override
    public boolean isAccountNonExpired() {
        // 토큰 만료 확인하는 코드 필요
        return true;
    }

    // 계정이 잠겨있는지 확인 / 사용자 직접 or 비밀번호 틀리면
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 유효기간 -> 변경 요청
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 / 시큐리티는 사용자가 인증하도록 허용한다.
    // false 일경우
    @Override
    public boolean isEnabled() {
        return member.getStatus();
    }
}
