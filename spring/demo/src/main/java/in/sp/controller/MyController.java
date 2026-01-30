package in.sp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.services.UserService;
import in.sp.main.entities.User;


@Controller
public class MyController {
  @Autowired
  private UserService userService;
  @GetMapping("/regPage")
    
public String openRegPage(Model model) {
  model.addAttribute("user", new User());
    return "register";
}
@PostMapping("/regForm")

public String submitRegForm(@ModelAttribute("user") User user, Model model) {
 boolean status = userService.registerUser(user);
 if (status) {
  model.addAttribute("successmsg", "Registration Successful");
 } else {
  model.addAttribute("errormsg", "Something went wrong");
 } 
 
 return "register";
}
@GetMapping("/loginPage")
public String openLoginPage(Model model) 
{
  model.addAttribute("user", new User());
  return "login";
}
@PostMapping("/loginForm")
public String submitLoginForm(@ModelAttribute("user") User user, Model model) {
 User validUser=userService.loginUser(user.getEmail(), user.getPassword());
 if (validUser!=null) {
  return "profile";
 } else {
  model.addAttribute("errormsg", "Invalid details");
 }
 return "login";
}
}
