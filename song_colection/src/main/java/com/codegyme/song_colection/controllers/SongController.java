package com.codegyme.song_colection.controllers;

import com.codegyme.song_colection.dtos.SongDto;
import com.codegyme.song_colection.models.Song;
import com.codegyme.song_colection.services.ISongService;
import com.codegyme.song_colection.services.impl.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "songName", defaultValue = "") String songName) {
        model.addAttribute("songs",songService.findAll());
        model.addAttribute("songName", songName);
        return "music/list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "music/create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "music/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/song";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Song song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "music/update";
    }
    @PostMapping("update/{id}")
    public String update(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "music/update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        return "redirect:/song";
    }

}

