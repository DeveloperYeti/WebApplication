package org.example.webapplication0404;

import org.example.webapplication0404.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
public class controller {
    @GetMapping("/ex1")
    public void ex(){

    }
    @GetMapping({"/ex2","/ex2_1"})
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

}

