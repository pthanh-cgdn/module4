package com.codegyme.library.controllers;

import com.codegyme.library.models.Book;
import com.codegyme.library.models.BorrowedBook;
import com.codegyme.library.repositories.IBookRepository;
import com.codegyme.library.repositories.IBorrowedBookRepository;
import com.codegyme.library.services.IBookService;
import com.codegyme.library.services.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library")
public class UserController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowedBookService borrowedBookService;
    @GetMapping("")
    public String display(@PageableDefault(value = 5) Pageable pageable,Model model, @RequestParam(value="searchByName",defaultValue = "") String searchByName) {

        model.addAttribute("books", bookService.findAllByName(searchByName,pageable));
        model.addAttribute("searchByName", searchByName);
        return "library/list";
    }
    @GetMapping("/view/{id}")
    public String getBorrow(Model model, @PathVariable("id") Long id) {
        model.addAttribute("book", bookService.findById(id));
        return "library/view";
    }
    @PostMapping("/borrow")
    public String postBorrow(Model model, @ModelAttribute("book") Book book) {
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        if(borrowedBookService.save(borrowedBook) != null) {
            model.addAttribute("borrowedKey", borrowedBook.getId());
            return "library/borrow";
        }
        return "redirect:/library/view/{id}";
    }
    @GetMapping("/return")
    public String getReturnBook() {
        return "library/return";
    }
    @PostMapping("/return")
    public String postReturnBook(Model model, @RequestParam(value="borrowedKey",defaultValue = "0") Long borrowedKey) {
        boolean isReturn = borrowedBookService.returnBook(borrowedKey);
        if (isReturn){
            return "redirect:/library";
        } else {
            model.addAttribute("borrowedKey", borrowedKey);
            model.addAttribute("message", "Your key is invalid, please re-input borrowed key")   ;
            return "library/return";
        }
    }
}
