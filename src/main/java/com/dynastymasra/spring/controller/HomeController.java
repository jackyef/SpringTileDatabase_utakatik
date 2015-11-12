/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynastymasra.spring.controller;

import static com.dynastymasra.spring.controller.MahasiswaController.logger;
import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.domain.User;
import com.dynastymasra.spring.service.MahasiswaService;
import com.dynastymasra.spring.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author LabGSG
 */
@Controller
@RequestMapping("home")
public class HomeController {
    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private UserService  userService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String formLogin(ModelMap modelMap) {
        logger.debug("Request form login");

        User  user = new User();
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("loginUrl", "../home/login");

        return "login-form-tile";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateLogin(@ModelAttribute("user") User user, ModelMap modelMap) {
        logger.debug("Validasi login");
        
        if(userService.validateLogin(user.getUsername(), user.getPassword())){
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("loginUrl", "../home/login");
            return "home-inside-tile";
        } else {
            modelMap.addAttribute("msg", "Gagal login!");
            return "login-form-tile";
        }
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String formSignup(ModelMap modelMap) {
        logger.debug("Request form signup");

        User  user = new User();
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("signupUrl", "../home/signup");

        return "signup-form-tile";
    }

}
