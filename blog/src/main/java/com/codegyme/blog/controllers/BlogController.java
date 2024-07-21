package com.codegyme.blog.controllers;

import com.codegyme.blog.models.Blog;
import com.codegyme.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ModelAndView display(@PageableDefault(value = 2) Pageable pageable){
//        Pageable pageable= PageRequest.of(0, 2);
        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/display");
        modelAndView.addObject("categoryArray", new String[]{"Chính trị", "Kinh tế", "Giáo dục", "Xã hội","Sống"});
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
    @GetMapping("/category")
    public ModelAndView category(@RequestParam("categoryName") String category,@PageableDefault(value = 2) Pageable pageable){
//        Pageable pageable= PageRequest.of(0, 2);
        ModelAndView modelAndView = new ModelAndView("/blog/display");
        modelAndView.addObject("blogs", blogService.findByCategoryName(pageable,category));
        modelAndView.addObject("selectedCategory", category);
        modelAndView.addObject("categoryArray", new String[]{"Chính trị", "Kinh tế", "Giáo dục", "Xã hội","Sống"});
        return modelAndView;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryArray", new String[]{"Chính trị", "Kinh tế", "Giáo dục", "Xã hội","Sống"});
        return "blog/create";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id,Model model) {
        model.addAttribute("blog",blogService.findBlogById(Integer.parseInt(id)));
        return "/blog/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id,Model model) {
        model.addAttribute("blog",blogService.findBlogById(Integer.parseInt(id)));
        return "/blog/delete";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") String id,Model model) {
        model.addAttribute("blog",blogService.findBlogById(Integer.parseInt(id)));
        return "/blog/view";
    }


//    @GetMapping("/sort")
//    public String sort(@RequestParam("sortBy") String sortBy,Model model) {
//        model.addAttribute("products",productService.sort(sortBy));
//        return "product/display";
//    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog, BindingResult bindingResult, RedirectAttributes redirect) {
        blogService.save(blog);
        if(bindingResult.hasFieldErrors()) {
            return "/create";
        }
        redirect.addFlashAttribute("message","Blog is successfully created");
        return "redirect:/blog";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.editBlog(blog);
        return "redirect:/blog";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog);
        return "redirect:/blog";
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam("search") String search, @PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/blog/display");
        modelAndView.addObject("blogs",blogService.search(pageable,search));
        modelAndView.addObject("categoryArray", new String[]{"Chính trị", "Kinh tế", "Giáo dục", "Xã hội","Sống"});
        return modelAndView;
    }
}
