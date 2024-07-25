package com.codegyme.cart.controllers;

import com.codegyme.cart.models.Cart;
import com.codegyme.cart.models.Product;
import com.codegyme.cart.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public String display(@PageableDefault(value = 5) Pageable pageable, Model model, @RequestParam(value="searchByName",defaultValue = "") String searchByName) {

        model.addAttribute("products", productService.findAllByName(searchByName,pageable));
        model.addAttribute("searchByName", searchByName);
        return "shop/list";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "shop/view";
    }
    @PostMapping("/addToCart")
    public String addProductToCart(@ModelAttribute("product") Product product, @ModelAttribute Cart cart) {
        cart.addProduct(product);
        return "redirect:/shop";
    }

    @GetMapping("/add/{id}")
    public ModelAndView addProduct(@PathVariable Long id,@SessionAttribute(value = "cart",required = false) Cart cart) {
        cart.addProduct(productService.findById(id));
        ModelAndView modelAndView = new ModelAndView("shop/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/deduct/{id}")
    public ModelAndView deductProduct(@PathVariable Long id,@SessionAttribute(value = "cart",required = false) Cart cart) {
        cart.deductProduct(productService.findById(id));
        ModelAndView modelAndView = new ModelAndView("shop/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView displayCart(@SessionAttribute(value = "cart",required = false) Cart cart) {
        ModelAndView modelAndView = new ModelAndView("shop/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
