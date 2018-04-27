package com.codeup.teddyblog.services;

import com.codeup.teddyblog.Models.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean isLoggedIn() {
        boolean isAnonUser = SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken;
        return !isAnonUser;
    }

    public User loggedInUser() {
        if (!isLoggedIn()) {
            return null;
        } else return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public boolean isOwnedBy(User user) {
        return isLoggedIn() && loggedInUser().getId() == user.getId();
    }
}
