package by.bookstore.controller;

import by.bookstore.entity.Address;
import by.bookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/save")
    public String save() {
        return "saveAddress";
    }

    @PostMapping("/save")
    public String save(Address address, Model model) {
        addressService.save(address);
        return "redirect:/";
    }
}
