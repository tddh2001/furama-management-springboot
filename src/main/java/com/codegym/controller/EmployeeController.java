package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    GenderService genderService;

    @ModelAttribute("gender")
    public Iterable<Gender> genders(){
        return genderService.findAll();
    }

    @ModelAttribute("positions")
    public List<Position> positionList() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public List<EducationDegree> educationDegreeList() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public List<Division> divisionList() {
        return divisionService.findAll();
    }

    @GetMapping("/employee-list")
    public String list(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "employee/list";
    }

    @GetMapping("/create-employee")
    public String showCreate(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("create-employee")
    public String create(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/create";
        }
        employeeService.save(employee);
        return "redirect:/employee-list";
    }

    @GetMapping("/edit-employee/{id}")
    private String showEdit(@PathVariable int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "/employee/edit";
    }

    @PostMapping("edit-employee")
    public String editCustomer(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.save(employee);
        model.addAttribute("employee", employee);
        return "redirect:/employee-list";
    }

    @PostMapping("delete-employee")
    private String deleteCustomer(@RequestParam(name = "idEmployee") int id){
        employeeService.remove(id);
        return "redirect:/employee-list";
    }
    @GetMapping("/view-employee/{id}")
    private String viewCustomer(Model model, @PathVariable("id") int id){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "/employee/view";
    }

}
