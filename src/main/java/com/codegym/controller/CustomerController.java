package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import com.codegym.model.Gender;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerTypeService;
import com.codegym.service.DuplicateIDException;
import com.codegym.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @Autowired
    private GenderService genderService;

    @ModelAttribute("gender")
    public Iterable<Gender> genders() {
        return genderService.findAll();
    }

    @ModelAttribute("customerType")
    public Iterable<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }

//    @GetMapping("/")
//    private String index() {
//        return "index";
//    }

    @GetMapping("/404")
    private String error403(){
        return "/customer/inputs-not-acceptable";
    }

    @GetMapping("/customer-list")
    private String list(@RequestParam("s") Optional<String> s, Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers;
        if (s.isPresent()){
            customers = customerService.findAllByCustomerNameContaining(s.get(), pageable);
        }else {
            customers = customerService.findAll(pageable);
        }
        model.addAttribute("customers", customers);
        return "/customer/list";
    }

    @GetMapping("/create-customer")
    private String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/create-customer")
    private String create(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws DuplicateIDException {
        try {
            if (bindingResult.hasErrors()) {
                return "/customer/create";
            } else {
                if (customerService.existId(customer.getCustomerId()) == false) {
                    customerService.create(customer);
                    model.addAttribute("customer", new Customer());
                    redirectAttributes.addFlashAttribute("createSuccess", "Create customer successfully");
                    return "redirect:/customer-list";
                } else {
                    throw new DuplicateIDException();
                }
            }
        } catch (DuplicateIDException e) {
            return "/customer/inputs-not-acceptable";
        }
    }

    @GetMapping("/edit-customer/{id}")
    private String showEdit(@PathVariable String id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/edit";
    }

    @PostMapping("edit-customer")
    private String edit(@Validated @ModelAttribute("customer") Customer customer,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws DuplicateIDException {
        if (bindingResult.hasErrors()){
            return "/customer/edit";
        }else {
            customerService.edit(customer);
            model.addAttribute("customer", customer);
            redirectAttributes.addFlashAttribute("editSuccess", "Edit customer successfully");
            return "redirect:/customer-list";
        }
    }

    @PostMapping("delete-customer")
    private String deleteCustomer(@RequestParam(name = "idCustomer") String id) {
        customerService.remove(id);
        return "redirect:/customer-list";
    }

    @GetMapping("/view-customer/{id}")
    private String viewCustomer(Model model, @PathVariable("id") String id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/view";
    }
}
