package com.clothpromo.controller;

import com.clothpromo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {

    @ModelAttribute("siteName")
    public String siteName() {
        return "명훈어패럴";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("activePage", "home");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("activePage", "about");
        return "about";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("activePage", "products");
        model.addAttribute("products", List.of(
                new Product("세터 후드 집업", "세터(SETTER) 브랜드 발주, 기모 후드 집업 생산"),
                new Product("세터 트레이닝 세트", "세터(SETTER) 브랜드 발주, 상하 트레이닝 세트 생산"),
                new Product("기획 의류 샘플 제작", "신규 브랜드 의뢰, 디자인 시안 기반 샘플 제작"),
                new Product("단체 유니폼 생산", "기업/단체 의뢰, 유니폼 대량 생산")
        ));
        return "products";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("activePage", "contact");
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@RequestParam String name,
                                 @RequestParam String phone,
                                 @RequestParam String message,
                                 Model model) {
        model.addAttribute("activePage", "contact");
        model.addAttribute("submitted", true);
        model.addAttribute("submittedName", name);
        return "contact";
    }
}
