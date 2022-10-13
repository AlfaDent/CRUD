package com.example.habrsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

   /* @GetMapping(value = "/users")
    public ModelAndView ShowUserList(Model model, User user){
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("user", user);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") long id, Model model, User user){
        ModelAndView modelAndView = new ModelAndView("update-user");
        user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return modelAndView;
    }

    @PostMapping("/adduser")
    public ModelAndView addUser(User user, BindingResult result, Model model) {
        ModelAndView modelAndView = new ModelAndView("add-user");
        if (result.hasErrors()) {
            return modelAndView;
        }

        userRepository.save(user);
        modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateUser(@PathVariable("id") long id, User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return new ModelAndView("update-user");
        }

        userRepository.save(user);
        return new ModelAndView("redirect:/index");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return new ModelAndView("redirect:/index");
    }

    @GetMapping("/signup")
    public ModelAndView showSignUpForm() {
        return new ModelAndView("add-user");
    }*/
   @GetMapping("/")
   public ModelAndView viewHomePage(Model model) {
       model.addAttribute("listUsers", userRepository.findAll());
       return new ModelAndView("index");
   }

    @GetMapping("/showNewUserForm")
    public ModelAndView showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("new_user");
    }

    @PostMapping("/saveUser")
    public ModelAndView saveEmployee(@ModelAttribute("user") User user) {
        // save employee to database
        userRepository.save(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/showFormForUpdate/{id}")
    public ModelAndView showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        User user = userRepository.findById(id).get();

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return new ModelAndView("update_user");
    }

    @GetMapping("/deleteUser/{id}")
    public ModelAndView deleteUser(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.userRepository.deleteById(id);
        return new ModelAndView("redirect:/");
    }
}
