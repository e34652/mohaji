package com.team1.mohaji.config;

import com.team1.mohaji.entity.Member;
import com.team1.mohaji.repository.MemberRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//이 클래스는 사용자 정보를 DB에서 가져온 뒤 authentication 객체 생성
@Service
public class MemberDetails implements UserDetailsService {

    private MemberRepository memberRepository;

    public MemberDetails(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        int member_id;
        String userName, password = null;
        List<GrantedAuthority> authorities = null;


        List<Member> memberList = memberRepository.findByLoginId(username);
        if (memberList.size() == 0) {
            throw new UsernameNotFoundException("User details 확인 불가: " + username);
        } else{
            userName = memberList.get(0).getLoginId();
            password = memberList.get(0).getPassword();
            member_id = memberList.get(0).getMemberId();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(memberList.get(0).getRole().name()));
        }

        return new CustomUserDetails(member_id,userName,password,authorities);
//        return new User(userName,password,authorities);
    }
}
