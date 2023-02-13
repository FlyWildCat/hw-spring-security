package ru.netology.springbootrest.pda.authorize.controller;

import org.springframework.security.core.Authentication;

public interface AuthInterface {
    Authentication getAuthentication();
}
