package dev.bigstack.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringSessionController {
    @PostMapping("/addComment")
    public String addNote(@RequestParam("comment") String comment, HttpServletRequest request) {
        List<String> comments = (List<String>) request.getSession().getAttribute("COMMENTS_SESSION");
        if (comments == null) {
        	comments = new ArrayList<>();
            request.getSession().setAttribute("COMMENTS_SESSION", comments);
        }
        comments.add(comment);
        request.getSession().setAttribute("COMMENTS_SESSION", comments);
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        List<String> comments = (List<String>) session.getAttribute("COMMENTS_SESSION");
        model.addAttribute("commentsSession", comments!=null? comments:new ArrayList<>());
        return "home";
    }
    @PostMapping("/invalidate/session")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/home";
    }
}