package com.example.biblesearch.controller;

import com.example.biblesearch.entity.Bible;
import com.example.biblesearch.service.BibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // 모든 도메인에서의 접근을 허용. 필요에 따라 제한 가능
public class BibleRestController {

    @Autowired
    private BibleService bibleService;

    /**
     * 검색 API
     * @param keyword 검색어
     * @param page 페이지 번호 (0부터 시작)
     * @return 검색 결과 페이지
     */
    @GetMapping("/search")
    public Page<Bible> searchBibles(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "page", defaultValue = "0") int page
    ) {
        return bibleService.searchByKeyword(keyword, page);
    }
}
