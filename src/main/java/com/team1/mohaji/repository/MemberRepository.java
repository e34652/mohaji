package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    List<Member> findByLoginId(String loginId);

}
