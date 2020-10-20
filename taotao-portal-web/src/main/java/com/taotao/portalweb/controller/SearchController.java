package com.taotao.portalweb.controller;

import com.taotao.portalweb.service.SearchService;
import com.taotao.portalweb.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/query")
    @ResponseBody
    public SearchResult query(@RequestParam(defaultValue = "1") Integer page, String q) {
        SearchResult result = searchService.query(q, page);
        return result;
    }


}
