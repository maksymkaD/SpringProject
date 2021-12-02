package com.example.application.controller;

import com.example.application.security.MyUserDetails;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class StaticPageController {
    @GetMapping("/")
    public String getHomePage(ModelMap model) {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", user);

        return "home";
    }

    @GetMapping(value = "/download")
    public ResponseEntity<InputStreamResource> downloadFile1() throws IOException {

        File file = new File("C:\\Users\\maxym\\ukma\\4_course\\spring\\SpringProject\\spring-boot\\src\\main\\java\\com\\example\\application\\images\\image.png");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(MediaType.valueOf("image/png"))
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }
}
