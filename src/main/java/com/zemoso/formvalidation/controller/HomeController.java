package com.zemoso.formvalidation.controller;

import com.zemoso.formvalidation.config.AppConfig;
import com.zemoso.formvalidation.model.Student;
import com.zemoso.formvalidation.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.validation.Valid;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private final StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/register")
    public String helloWorld(Model model){
        model.addAttribute("student", new Student());
        logger.info("Data received in register");
        return "studentForm";
    }

    @PostMapping("/registerStudent")
    public String submitForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "studentForm";
        }
        studentService.registerStudent(student);
        logger.info("The data from student is: {}", student.toString());
        model.addAttribute("message", "Registration successful!");
        return "success";
    }

    @GetMapping("/studentList")
    public String showStudentList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        logger.info("The complete student list: {}", studentService.getAllStudents());
        return "studentList";
    }

    @GetMapping("/redirectToStudentList")
    public String redirectToStudentList() {
        return "redirect:/studentList";
    }
}
