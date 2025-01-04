package com.example.biblesearch.controller;

import com.example.biblesearch.entity.Bible;
import com.example.biblesearch.service.BibleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BibleController {

    private final BibleService bibleService;

    public BibleController(BibleService bibleService) {
        this.bibleService = bibleService;
    }

    /**
     * 한 페이지에서 검색 폼 + 결과 + 페이징까지 처리
     */
    @GetMapping("/")
    public String searchPage(
            @RequestParam(value="keyword", required=false) String keyword,
            @RequestParam(value="page", defaultValue="0") int page,
            Model model
    ) {
        // DB 검색 (keyword가 없으면 전체 목록, 있으면 해당 검색 결과)
        Page<Bible> pageResult = bibleService.searchByKeyword(keyword, page);

        // Page<Bible>에서 필요한 정보 추출
        model.addAttribute("results", pageResult.getContent());  // 실제 데이터 목록
        model.addAttribute("currentPage", pageResult.getNumber());  // 현재 페이지(0부터 시작)
        model.addAttribute("totalPages", pageResult.getTotalPages()); // 총 페이지 수
        model.addAttribute("keyword", keyword); // 검색어

        return "index"; // templates/index.html 로 이동
    }
}
