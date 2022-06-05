package org.mnu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mnu.domain.QuestionVO;
import org.mnu.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/question/*")
public class QuestionController {

    private final QuestionService service;

    @GetMapping("/questionMain")
    public String questionMain() {
        return "question/questionMain";
    }



    /**
     * @brief 문제 수정 페이지
     * @details 문제의 정보를 수정할 수 있는 페이지를 보여준다.
     */
    @GetMapping("/modify")
    public void modify() {

    }

    /**
     * @brief 문제 수정 처리 페이지
     * @details 입력한 정보를 DB에 반영하여 정보를 수정한다.
     */
    @PostMapping("/modify")
    public String modify(RedirectAttributes rttr) {
        return "redirect:/question/list";
    }

    /**
     * @brief 문제 삭제 처리 페이지
     * @details 문제를 삭제하고 문제 리스트 페이지로 리다이렉트한다.
     */
    @GetMapping("/remove")
    public String remove(RedirectAttributes rttr) {
        return "redirect:/question/list";
    }


    /**
     * @brief 채점 처리
     * @details 채점 처리
     */
    @GetMapping("/exam/grading")
    public String examGrading(@RequestParam String qno, @RequestParam String ans) {



        return "questionGrading";
    }

    /**
     * @brief 시험 결과 페이지
     * @details 시험 결과 페이지
     */
    @GetMapping("/exam/result")
    public void examResult() {

    }

    /**
     * @derails 필기 실기의 문제 수를 전송해준다.
     */
    @GetMapping("/count")
    @ResponseBody
    public int count(@RequestParam String exam){
        int count = service.getCount();
        if(exam.equals("written")){
            return count;
        }
        else if(exam.equals("practical")){
            return 10;
        }
        return -1;
    }

    /**
     * @derails qno로 문제 정보를 받아 전송해준다.
     */
    @GetMapping("/written/get")
    public String examWrittenGet(Model model, @RequestParam long qno){
        QuestionVO vo = service.get(qno);
        model.addAttribute("vo",vo);
        return "written";
    }
}
