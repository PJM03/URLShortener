package jm.springtoy.urlshortener.controller;

import jm.springtoy.urlshortener.Util;
import jm.springtoy.urlshortener.domain.ShortURL;
import jm.springtoy.urlshortener.service.ShortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private ShortURLService service;

    @Autowired
    public MainController(ShortURLService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("urls", service.findAll());
        return "list";
    }

    @PostMapping("/create")
    public String create(@RequestParam String id, @RequestParam String url, @RequestParam String password) {
        service.save(id, url, password);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam String id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("message", "비밀번호를 입력해 주세요.");
        return "edit";
    }

    @GetMapping("/{id}")
    public String redirect(@PathVariable String id) {
        ShortURL sUrl = service.findById(id);
        return "redirect:" + sUrl.getUrl();
    }


}
