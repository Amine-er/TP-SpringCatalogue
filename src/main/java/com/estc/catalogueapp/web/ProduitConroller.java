package com.estc.catalogueapp.web;

import com.estc.catalogueapp.dao.ProduitRepository;
import com.estc.catalogueapp.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProduitConroller {
    @Autowired
    private ProduitRepository produitRepository;
    @GetMapping(path = "/index")
    public String index(){
        return "index";
    }
    @GetMapping(path = "/products")
    public String products(Model model,@RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "motCle", defaultValue = "") String motCle) {

        Page<Produit> pageProduits = produitRepository.
                findByDesignationContains(motCle, PageRequest.of(page, size));

        model.addAttribute("pageProduits", pageProduits);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("motCle", motCle);
        model.addAttribute("pages", new int[pageProduits.getTotalPages()]);
        return "products";
    }
    @GetMapping(path = "/deleteProduits")
    public String delete(Long id, String motCle, String page, String size){
        produitRepository.deleteById(id);
        return "redirect:/products?page="+page+"&motCle="+motCle+"&size="+size;
    }
}
