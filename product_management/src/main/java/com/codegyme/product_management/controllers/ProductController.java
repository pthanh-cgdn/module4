package com.codegyme.product_management.controllers;

import com.codegyme.product_management.models.Product;
import com.codegyme.product_management.services.IProductService;
import com.codegyme.product_management.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public String display(Model model){
        model.addAttribute("products", productService.getAll());
        return "product/display";
    }
    @GetMapping("product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }
    @GetMapping("product/edit/{id}")
    public String edit(@PathVariable("id") String id,Model model) {
        model.addAttribute("product",productService.findProductById(Integer.parseInt(id)));
        return "product/edit";
    }
    @GetMapping("product/delete/{id}")
    public String delete(@PathVariable("id") String id,Model model) {
        model.addAttribute("product",productService.findProductById(Integer.parseInt(id)));
        return "/product/delete";
    }


    @GetMapping("product/sort")
    public String sort(@RequestParam("sortBy") String sortBy,Model model) {
        model.addAttribute("products",productService.sort(sortBy));
        return "product/display";
    }

    @PostMapping("product/create")
    public String create(@ModelAttribute("product") Product product, Model model) {
        productService.addProduct(product);
        return "redirect:/product";
    }
    @PostMapping("product/edit")
    public String edit(@ModelAttribute("product") Product product, Model model) {
        productService.editProduct(product);
        return "redirect:/product";
    }
    @PostMapping("product/delete")
    public String delete(@ModelAttribute("product") Product product) {
        productService.remove(product);
        return "redirect:/product";
    }
    @PostMapping("product/search")
    public String search(@RequestParam("search") String search, Model model) {
        model.addAttribute("products",productService.search(search));
        return "product/display";
    }
}
