package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.demo.Entity.Member;
import com.example.demo.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private  HomeService homeService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/memberlist")
    public String memberlist(Model model) {
        List<Member> memlist = homeService.memberList();
        model.addAttribute("memlist", memlist);
        return "memberlist"; //viewpage(memberList.html)

    }

}
