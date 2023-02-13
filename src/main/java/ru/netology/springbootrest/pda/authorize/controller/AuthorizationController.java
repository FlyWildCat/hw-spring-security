package ru.netology.springbootrest.pda.authorize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    @Autowired
    private AuthInterface authInterface;

    @GetMapping("all")
    public String all(){
        Authentication auth = authInterface.getAuthentication();
        return "<h3>Общественная</h3> <div>Привет пользователь " + auth.getName() + "<div>";}

    @GetMapping("user")
    public String user(){
        Authentication auth = authInterface.getAuthentication();
        return "<h3>Пользовательская</h3> <div>Привет пользователь " + auth.getName() + " с правами " + auth.getAuthorities() + "</div>";}

    @GetMapping("admin")
    public String admin(){
        Authentication auth = authInterface.getAuthentication();
        return "<h3>Админская</h3> Привет пользователь " + auth.getName() + " с правами " + auth.getAuthorities();}

    @GetMapping("manager")
    public String manager(){
        Authentication auth = authInterface.getAuthentication();
        return "<h3>Менеджерская</h3> Привет пользователь " + auth.getName() + " с правами " + auth.getAuthorities();}
}
