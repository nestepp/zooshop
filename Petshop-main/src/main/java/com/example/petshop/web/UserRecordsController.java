package com.example.petshop.web;

import com.example.petshop.model.Record;
import com.example.petshop.repository.RecordRepository;
import com.example.petshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;

@Controller
public class UserRecordsController {

    private Authentication authentication;

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/userRecords")
    public String userRecords(Model model) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        List<Record> list = recordRepository.findAllByUser(userRepository.findByEmail(email));

        model.addAttribute("records", list);

        return "userRecords";
    }

}
