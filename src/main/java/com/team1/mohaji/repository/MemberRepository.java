package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    List<Member> findByLoginId(String loginId);

//    @Query("select from Member where loginId = {loginId}")
//    List<Member> findbyUsername(@Param("username") String username);

}
