package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    List<Member> findByLoginId(String loginId);

    Member findByMemberId(int memberId);

}
