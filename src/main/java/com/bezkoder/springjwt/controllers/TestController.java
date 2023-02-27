package com.bezkoder.springjwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }
  //ADD ROLES IN  SQL
  @GetMapping("/user")
  @PreAuthorize("hasRole('USER')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @RolesAllowed({"ROLE_MODERATOR", "ROLE_ADMIN"})
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @RolesAllowed("ROLE_ADMIN")
  public String adminAccess() {
    return "Admin Board.";
  }
}
