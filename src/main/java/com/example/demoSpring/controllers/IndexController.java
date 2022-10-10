package com.example.demoSpring.controllers;

import com.example.demoSpring.Models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
        usuario.setEmail("andresguierrezsergi@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "perfil del usuario: " .concat(usuario.getNombre()));
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Sergi", "Andres", "andresguierrezsergi@gmail.com"));
        usuarios.add(new Usuario("Oriol", "Sangra", "andresguierrezsergi@gmail.com"));
        usuarios.add(new Usuario("`Victor`", "Ponsa", "andresguierrezsergi@gmail.com"));

        model.addAttribute("titulo", "listado de usuaios: ");
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }




}