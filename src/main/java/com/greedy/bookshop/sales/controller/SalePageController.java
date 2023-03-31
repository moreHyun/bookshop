package com.greedy.bookshop.sales.controller;


import com.greedy.bookshop.sales.model.dto.BookDTO;
import com.greedy.bookshop.sales.model.dto.CategoryDTO;
import com.greedy.bookshop.sales.service.SalePageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.*;


@Slf4j
@Controller
@RequestMapping("/sale")
public class SalePageController {
    private final SalePageService salePageService;

    public SalePageController(SalePageService salePageService) {
        this.salePageService = salePageService;
    }

//    @GetMapping("/salepage")
//    public String gosale(Model model) throws IOException
//    {
//        log.info("판매페이지로 넘어옴");
//
//        List<CategoryDTO> categoryList = FindSideNav();
//        List<BookDTO> bookList = salePageService.selectBookAll();
//        List<FileDTO> fileList = salePageService.selectFileAll();
//
//        log.info("값 넘겨줌");
//        model.addAttribute("bookList", bookList);
//        model.addAttribute("fileList", fileList);
//        model.addAttribute("categoryList", categoryList);
//        log.info("model : " + model);
//        return "web/sale/salepage";
//    }

    @GetMapping("/salepage")
    public String viewSale(@RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) String categoryCode,
            @RequestParam(required = false) String searchValue,
            Model model)
    {
        Map<String,String> value = new HashMap<>();
        value.put("category",categoryCode);
        value.put("search",searchValue);
        Map<String , Object> bookListAndPaging = salePageService.selectBookList(page,value);
        log.info("Controller] bookListAndPaging : " , bookListAndPaging);
        List<CategoryDTO> category = FindSideNav();
        model.addAttribute("paging",bookListAndPaging.get("paging"));
        model.addAttribute("bookList",bookListAndPaging.get("book"));
        model.addAttribute("categoryName",bookListAndPaging.get("name"));
        model.addAttribute("fileList",bookListAndPaging.get("file"));
        model.addAttribute("categoryList",category);
        log.info("model" + model + "\n");

        return "/sale/salepage";
    }

    @GetMapping("/bookDetails")
    public String detailsController(@RequestParam long no , Model model)
    {
        log.info("Controller들어옴");
        Map<String, Object>m = salePageService.selcetBookDetail(no);
        model.addAttribute("book",m.get("book"));
        model.addAttribute("file",m.get("file"));
        log.info("model" + model);

        return "/sale/bookDetails";
    }

    private List<CategoryDTO> FindSideNav()
    {
        List<CategoryDTO> categoryList = salePageService.selectCategoryAll();

        return categoryList;
    }

    @PostMapping("/regist")
    public ResponseEntity<String> cartRegist(@RequestBody BookDTO bookCode)
    {
        String m = salePageService.insertCart(bookCode.getBookCode(),1);
        return ResponseEntity.ok(m);
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyitem(@RequestBody BookDTO book)
    {
        log.info("gd");
        String m = salePageService.buyitem(book.getBookCode(),1);
        return ResponseEntity.ok(m);
    }



}
