package dev.kaykyfreitas.springfullstack.controller;

import dev.kaykyfreitas.springfullstack.dto.UserDto;
import dev.kaykyfreitas.springfullstack.model.FileModel;
import dev.kaykyfreitas.springfullstack.model.UserModel;
import dev.kaykyfreitas.springfullstack.repository.FileRepository;
import dev.kaykyfreitas.springfullstack.service.FileService;
import dev.kaykyfreitas.springfullstack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/create")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("user", new UserModel());
        return mv;
    }

    @PostMapping("/create")
    public String create(UserDto userDto) {
        if (Objects.nonNull(userDto.id())) {
            userService.update(userDto);
        } else {
            userService.create(userDto);
        }

        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("users", userService.findAll());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("user", userService.findById(id));
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/list";
    }

}
