package com.team1.mohaji.service.imple;

import com.team1.mohaji.config.MemberDetail;
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
import java.util.Optional;

//이 클래스는 사용자 정보를 DB에서 가져온 뒤 authentication 객체 생성
@Service
public class MemberDetailsService implements UserDetailsService {

    private MemberRepository memberRepository;

//    // /login + Post + FormUrlEncoded + username,password 모두 성립하면
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Optional으로 NPE를 방지한다.
//        List<Member> memberList = memberRepository.findByLoginId(username);
//        if(memberList.isPresent()){
//            return new MemberDetail(memberList.get());
//        }else{
//            return null;
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorities = null;

        List<Member> memberList = memberRepository.findByLoginId(username);
        if (memberList.size() == 0) {
            throw new UsernameNotFoundException("User details 확인 불가: " + username);
        } else{
            userName = memberList.get(0).getLoginId();
            password = memberList.get(0).getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(memberList.get(0).getRole()));
        }

        return new User(userName,password,authorities);
    }
}
