package com.codegyme.module4_student.controllers;

import com.codegyme.module4_student.dtos.StudentDto;
import com.codegyme.module4_student.models.Student;
import com.codegyme.module4_student.services.IClassroomService;
import com.codegyme.module4_student.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="student")
@SessionAttributes("studentTalkList")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassroomService classroomService;

    @ModelAttribute("studentTalkList")
    private List<Student> students(){return new ArrayList<>();}

    @GetMapping("")
    public String displayAllStudents(Model model,
                                     @RequestParam(value = "nameStudent", defaultValue = "") String nameStudent,
                                     @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("name").descending();
        Page<Student> students = studentService.findAllByName(nameStudent, PageRequest.of(page, 20, sort));
        model.addAttribute("students", students);
        model.addAttribute("nameStudent", nameStudent);
        return "student/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("classrooms", classroomService.getAllClassrooms());
        return "student/create";
    }

    @PostMapping("/create")
    public String newStudent(@Validated @ModelAttribute("studentDto") StudentDto studentDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirect,
                             Model model
    ) {
        new StudentDto().validate(studentDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("classrooms", classroomService.getAllClassrooms());
            return "student/create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/student";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable Long id) {
        System.out.println(id);
//....
        return "student/update";
    }
    @GetMapping("talk/{id}")
    public String addTalk(@PathVariable("id")Long id,
                          @ModelAttribute("studentTalkList")List<Student> students,
                          RedirectAttributes redirect) {
        Student student = studentService.findById(id);
        students.add(student);
        redirect.addFlashAttribute("message", "Thêm vào room thanh công");
        return "redirect:/student";
    }

    @GetMapping("/talk")
    public String viewTalkList(@ModelAttribute("studentTalkList")List<Student> students,
                               Model model) {
        model.addAttribute("students", students);
        return "student/list_talk";
    }

    @ExceptionHandler(Exception.class)
    public String handleError(Model model, Exception exception) {
        model.addAttribute("message", exception.getMessage());
        return "errors/404";
    }
}
