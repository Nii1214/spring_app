package com.example.spring_app.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring_app.entity.User;
import com.example.spring_app.repository.UserRepository;

@Controller
public class RegisterController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "pages/register";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("user_name") String userName,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes) {
        
        try {
            // ユーザー名の重複チェック
            if (!userRepository.findByUserName(userName).isEmpty()) {
                throw new IllegalArgumentException("そのユーザー名は既に使用されています。");
            }

            // 新規ユーザーの作成
            User user = new User();
            user.setUserName(userName);
            user.setPassword(passwordEncoder.encode(password));
            user.setRoleId(1); // 一般ユーザーとして登録

            userRepository.save(user);

            redirectAttributes.addFlashAttribute("successMessage", "ユーザー登録が完了しました。ログインしてください。");
            return "redirect:/login";

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            redirectAttributes.addFlashAttribute("userName", userName);
            return "redirect:/register";
        }
    }
} 