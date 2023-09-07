package com.estc.catalogueapp;

import com.estc.catalogueapp.entities.Produit;
import com.estc.catalogueapp.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogueAppApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;
    public static void main(String[] args) {
        SpringApplication.run(CatalogueAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        produitRepository.save(new Produit(null,"PS5",7500.0,4.0));
        produitRepository.save(new Produit(null,"PS4 Pro",5500.0,7.0));
        produitRepository.save(new Produit(null,"PS4",3500.0,30.0));
        produitRepository.save(new Produit(null,"Xbox s",8500.0,10.0));
        produitRepository.save(new Produit(null,"Switch",4500.0,20.0));

        produitRepository.save(new Produit(null,"PC ASUS",17500.0,2.0));
        produitRepository.save(new Produit(null,"HP Lap",5500.0,3.0));
        produitRepository.save(new Produit(null,"TV Smart",13500.0,45.0));
        produitRepository.save(new Produit(null,"IPhon",18500.0,150.0));
        produitRepository.save(new Produit(null,"Android",14500.0,200.0));
        /*
        Page<Produit> produits = produitRepository.findByDesignationContains("X",PageRequest.of(0,2));
        System.out.println(produits.getSize());
        System.out.println(produits.getTotalElements());
        System.out.println(produits.getTotalPages());

        produits.getContent().forEach(p ->{
            System.out.println(p.toString());
        } );

        Page<Produit> prods = produitRepository.chercher("%P%",5000.0,PageRequest.of(0,2));
        System.out.println(prods.getSize());
        System.out.println(prods.getTotalElements());
        System.out.println(prods.getTotalPages());

        prods.getContent().forEach(p ->{
            System.out.println(p.toString());
        } );
         */
    }
}
