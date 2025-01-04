package com.example.biblesearch.repository;

import com.example.biblesearch.entity.Bible;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibleRepository extends JpaRepository<Bible, Integer> {

    // sentence 컬럼에 keyword가 포함되어 있는 구절 검색 + 페이징
    Page<Bible> findBySentenceContaining(String keyword, Pageable pageable);

    // 전체 목록 + 페이징
    // (사실 JpaRepository 자체에 findAll(Pageable pageable) 있음)
    // Page<Bible> findAll(Pageable pageable); // 이미 상속받은 메서드라 생략 가능
}
