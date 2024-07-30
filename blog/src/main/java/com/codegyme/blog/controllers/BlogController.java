package com.codegyme.blog.controllers;

import com.codegyme.blog.models.Blog;
import com.codegyme.blog.services.IBlogService;
import com.codegyme.blog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ModelAndView display(@PageableDefault(value = 5) Pageable pageable
    ,@RequestParam(name="searchByName", defaultValue = "") String searchByName
    ,@RequestParam(name="categoryId", defaultValue = "0") String categoryId){
        Page<Blog> blogs;
        if(Integer.parseInt(categoryId) != 0 && !categoryId.isEmpty()){
            blogs = blogService.findByCategoryId(Integer.parseInt(categoryId),pageable);
        } else {
            blogs = blogService.findAllByName(searchByName,pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/display");
        modelAndView.addObject("categoryArray", categoryService.findAll());
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("searchByName", searchByName);
        modelAndView.addObject("categoryId", Integer.parseInt(categoryId));
        return modelAndView;
    }
    @GetMapping("/category")
    public ModelAndView category(@RequestParam("categoryId") String categoryId,@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/blog/display");
        modelAndView.addObject("blogs", blogService.findByCategoryId(Integer.parseInt(categoryId),pageable));
        modelAndView.addObject("selectedCategory", categoryService.findById(Integer.parseInt(categoryId)));
        modelAndView.addObject("categoryArray", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryArray", categoryService.findAll());
        return "blog/create";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id,Model model) {
        model.addAttribute("blog",blogService.findBlogById(Integer.parseInt(id)));
        model.addAttribute("categoryArray", categoryService.findAll());
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
}
