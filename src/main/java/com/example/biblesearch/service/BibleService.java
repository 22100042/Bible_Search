package com.example.biblesearch.service;

import com.example.biblesearch.entity.Bible;
import com.example.biblesearch.repository.BibleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BibleService {

    private final BibleRepository bibleRepository;
    private static final int PAGE_SIZE = 30; // 페이지당 30개

    public BibleService(BibleRepository bibleRepository) {
        this.bibleRepository = bibleRepository;
    }

    /**
     * keyword 가 있으면 sentence에 LIKE 검색,
     * 없으면 전체 목록.
     * page는 0부터 시작(첫 페이지).
     */
    public Page<Bible> searchByKeyword(String keyword, int page) {
        // PageRequest(page, size) : page는 0부터 시작
        PageRequest pageable = PageRequest.of(page, PAGE_SIZE);

        if (keyword == null || keyword.trim().isEmpty()) {
            // 전체 목록 + 페이징
            return bibleRepository.findAll(pageable);
        } else {
            // sentence에 keyword 포함 + 페이징
            return bibleRepository.findBySentenceContaining(keyword, pageable);
        }
    }
}
