package com.example.OAuthLogin.controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OAuthController {
    @GetMapping("/userFB")
   public String  detais(@AuthenticationPrincipal OAuth2User principal){
        System.out.println(principal);
        return principal.getAttributes().get("name").toString();
    }

    @GetMapping("/userGoogle")
    public Map<String, Object> userDetails(@AuthenticationPrincipal OAuth2User user) {
        System.out.println("Got USer Attributes/////////////////");
        System.out.println((String)user.getAttribute("name"));
        return user.getAttributes();
    }
}
