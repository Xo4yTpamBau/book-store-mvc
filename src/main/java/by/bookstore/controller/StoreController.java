package by.bookstore.controller;

import by.bookstore.entity.Store;
import by.bookstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/save")
    public String save (){
        return "saveStore";
    }

    @PostMapping("/save")
    public String save (Store store){
        storeService.save(store);
        return "redirect:/";
    }
}
