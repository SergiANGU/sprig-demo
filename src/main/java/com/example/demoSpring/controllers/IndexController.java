package com.example.demoSpring.controllers;

import com.example.demoSpring.Models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {
    @GetMapping({"/index", "/", "/home", ""})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola spring framework");

        return"index";
    }
    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Sergi");
        usuario.setApellido("Andres");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "perfil del usuario: " .concat(usuario.getNombre()));
        return "perfil";
    }

}