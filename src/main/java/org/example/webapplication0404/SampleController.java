package org.example.webapplication0404;

import org.example.webapplication0404.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/ex1")
    public void ex(){

    }
    @GetMapping({"/ex2","/ex2_1 ", "/exBlock","/exLink"})
    public void exModel(Model model){
        List<SampleDTO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder()
                .sno(i)
                .first("first.." + i)
                .last("Last.." + i)
                .regTime(LocalDateTime.now())
                .build();
            return dto;
        }).collect(Collectors.toList());
        model.addAttribute("list", list);

    }

    @GetMapping("/exInline")
    public String exInline(RedirectAttributes redirectAttributes){// 매개변수의 타입이 나올 수 있음 시험으로
        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("first...100")
                .last("last")
                .regTime(LocalDateTime.now())
                .build();

        redirectAttributes.addFlashAttribute("result", "success");// addFlashAttribute 의 속성 값을 사용 할 수 있는가
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/sample/ex3";//redirect mapping 주소 명시할 수 있는지
    }
    @GetMapping("/ex3")
    public void ex3(){
        
    }
    @GetMapping({"/exLayout1","/exLayout2"})
    public void exLaytout1(){

    }
}

