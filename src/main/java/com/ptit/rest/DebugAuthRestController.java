package com.ptit.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class DebugAuthRestController {

    @GetMapping("/rest/debug/auth")
    public Map<String, Object> auth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return Map.of("authenticated", false);
        }
        List<String> roles = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return Map.of(
                "authenticated", auth.isAuthenticated(),
                "principal", auth.getName(),
                "authorities", roles
        );
    }
}