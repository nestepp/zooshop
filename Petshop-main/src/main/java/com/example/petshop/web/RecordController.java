package com.example.petshop.web;

import com.example.petshop.model.Record;
import com.example.petshop.model.User;
import com.example.petshop.repository.UserRepository;
import com.example.petshop.service.RecordService;
import com.example.petshop.web.dto.RecordDto;
import com.example.petshop.web.dto.UserRegistrarionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/record")
public class RecordController {

    private Authentication authentication;

    @Autowired
    RecordService recordService;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public String addRecord(@ModelAttribute("record") RecordDto recordDto) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email);

        Record record = new Record();
        record.setUser(user);
        record.setItem(recordDto.getItem());
        record.setQuantity(recordDto.getQuantity());
        record.setPrice(recordDto.getPrice());
        record.setCost(recordDto.getCost());


        recordService.save(record);
        return "redirect:/record?success";
    }

    @GetMapping
    public String record(Model m) {
        m.addAttribute("records", new RecordDto());
        return "record";
    }
}
