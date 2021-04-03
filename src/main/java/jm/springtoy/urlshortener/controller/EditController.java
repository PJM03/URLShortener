package jm.springtoy.urlshortener.controller;

import jm.springtoy.urlshortener.Util;
import jm.springtoy.urlshortener.domain.ShortURL;
import jm.springtoy.urlshortener.service.ShortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {
    private final ShortURLService service;

    @Autowired
    public EditController(ShortURLService service) {
        this.service = service;
    }

    @PostMapping("/edit/pw")
    public String editPw(@RequestParam String id, @RequestParam String password, Model model) {
        ShortURL sUrl = service.findById(id);
        if(sUrl.getPassword().equals(Util.encrypt("SHA-256", password))) {
            model.addAttribute("sUrl", sUrl);
            return "edit/input";
        }else {
            model.addAttribute("id", id);
            model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
            return "edit";
        }
    }

    @PostMapping("/edit/confirm")
    public String edit_confirm(@RequestParam String id, @RequestParam String url, @RequestParam String password, Model model) {
        ShortURL sUrl = service.findById(id);
        if(sUrl.getPassword().equals(Util.encrypt("SHA-256", password))) {
            sUrl.setUrl(url);
            service.save(sUrl);
            return "edit/success";
        }else {
            model.addAttribute("message", "비밀번호가 일치하지 않습니다");
            model.addAttribute("sUrl", sUrl);
            return "edit/input";
        }
    }

    @GetMapping("/edit/pw")
    public String editPwGet() {
        return "redirect:/";
    }
}
