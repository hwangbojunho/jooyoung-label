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
        return "주영라벨";
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
                new Product("우븐 라벨", "세터(SETTER) 브랜드 발주, 메인 넥 라벨 직조 제작", "/images/woven-label.jpg"),
                new Product("케어 라벨", "세탁/취급 안내가 담긴 케어 라벨 인쇄 제작", "/images/care-label.jpg"),
                new Product("행택", "제품 태그용 행택 디자인 및 제작", "/images/hang-tag.jpg"),
                new Product("프린트 라벨", "브랜드 로고 인쇄 라벨 제작", "/images/printed-label.jpg")
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
