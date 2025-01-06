package com.korit.main;

import com.korit.cotroller.UserController;
import com.korit.service.UserService;
import com.korit.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserService userService2 = new UserServiceImpl();
        UserController userController = new UserController(userService);
        userController.signUp();
        userController.signIn();
        userController.setUserService(userService2);
    }
}
