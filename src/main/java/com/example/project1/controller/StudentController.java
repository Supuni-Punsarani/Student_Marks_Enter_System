package com.example.project1.controller;

import com.example.project1.model.Student;
import com.example.project1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/insert")
    public String getdata(@RequestParam String sid,@RequestParam String name,@RequestParam int ca,@RequestParam int practical,@RequestParam int theory){
        Student student=new Student();
        student.setSid(sid);
        student.setName(name);
        student.setCa(ca);
        student.setPractical(practical);
        student.setTheory(theory);
        student.cal_final_mark();
        studentRepository.save(student);
        return "redirect:/view";
    }
    @GetMapping("/view")
    public String viewdata(Model model){
        model.addAttribute("students",studentRepository.findAll());
        return "/view";
    }
    @GetMapping("/")
    public String index(){
        return "/insert";
    }

    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }
}
