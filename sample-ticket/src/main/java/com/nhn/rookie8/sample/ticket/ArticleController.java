package com.nhn.rookie8.sample.ticket;

import com.nhn.rookie8.sample.ticket.model.Article;
import com.nhn.rookie8.sample.ticket.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    // setter 주입, 생성자 주입, autowired 주입

    // 생성자 주입 vs annotation 주입 장단점
    private final ArticleRepository articleRepository; // 생성자 주입

    // Autowired 주입
    //@Autowired
    // private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @GetMapping("/{seq}")
    public String detail(@PathVariable("seq") Long seq, Model model) {
        Article article = articleRepository
                .findById(seq)
                .orElseThrow(() -> new ArticleNotFoundException()); // 예시 답안
                // orElse(null);
        model.addAttribute("detail", article);
        // 스프링부트 에러 핸들링

        // 내가 생각한 if ~ else 예외처리
            // if (article == null) return "todo.html";
            // else return "article/detail";

        // 유진 Question : article이 null이어야만 반드시 오류가 날 수 있는가?
        // -> 네트워크 상태에 따라서 다를 수가 있어서 이렇게 하면 http 스펙을 고려하지 않은 코드가 된다.
        // 네트워크 에러는 404만 있는게 아니고 500도 있는 등 많기 때문 (200을 제외하면 이상이 있는 상태이므로)

        // 선배님 Comment : 스프링부트에서 이러한 예외처리를 도와주고 있다. '스프링부트 에러 핸들링'을 찾아보면 된다.
        // Tip) github 404 페이지 소스코드를 그대로 가져와서(...) 구현한 사람이 있었다.

        return "article/detail";
    }

    // 예시 답안
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ArticleNotFoundException extends RuntimeException {
        // ...
    }
}

