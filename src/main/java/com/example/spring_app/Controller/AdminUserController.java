package com.example.spring_app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring_app.entity.User;
import com.example.spring_app.servise.UserService;

// http://localhost:8080/adminuser

@Controller
public class AdminUserController {

    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adminuser")
    public String adminUser(Model model) {
        // ユーザーリストを取得してビューに渡す
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "adminUserView";
    }

    @PostMapping("/register")
    public String registerUser(
            RedirectAttributes redirectAttributes,
            @RequestParam("user_name") String userName,
            @RequestParam("password") String password,
            @RequestParam("role_id") int roleId) {

        try {
            // ユーザーを登録
            userService.createUser(userName, password, roleId);

            // 成功メッセージを渡す
            redirectAttributes.addFlashAttribute("successMessage", "ユーザー登録が完了しました。");

        } catch (IllegalArgumentException e) {
            // 失敗メッセージと入力内容（パスワードは除く）を渡す
            redirectAttributes.addFlashAttribute("failureMessage", e.getMessage());
            redirectAttributes.addFlashAttribute("userName", userName);
            redirectAttributes.addFlashAttribute("roleId", roleId);
        }

        // ユーザー一覧ページにリダイレクト
        return "redirect:/adminuser";
    }

}

