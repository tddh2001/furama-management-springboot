package com.codegym.controller;

import com.codegym.model.Log;
import com.codegym.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping("/log")
    public String showListLog(Model model,@PageableDefault(value = 10) Pageable pageable){
        Page<Log> followLogs = logService.findAll(pageable);
        model.addAttribute("logs", followLogs);
        return "/log/index";
    }
    @GetMapping("/delete-log/{id}")
    public String showDelete(Model model, @PathVariable Long id){
        Log followLog = logService.findById(id);
        model.addAttribute("log", followLog);
        return "/log/delete";
    }
    @PostMapping("/delete-log")
    public String delete(Log followLog, RedirectAttributes redirectAttributes){
        logService.remove(followLog.getId());
        redirectAttributes.addFlashAttribute("msgLogDelete", "Delete log successfully");
        return "redirect:/log";
    }
}
