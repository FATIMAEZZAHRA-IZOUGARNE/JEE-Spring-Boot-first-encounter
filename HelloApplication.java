package com.fstm.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fstm.jpa.entities.Produit;
import com.fstm.jpa.repositories.ProduitsRepository;

@SpringBootApplication
public class HelloApplication implements CommandLineRunner {

    @Autowired
    private ProduitsRepository produitsRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Enregistrer des produits
        produitsRepository.save(new Produit(0, "TCL", 23.00));
        produitsRepository.save(new Produit(0, "Samsung", 23.00));

        // Afficher tous les produits
        System.out.println("===== Liste de tous les produits =====");
        produitsRepository.findAll().forEach(p -> {
            System.out.println(p.toString());
        });

        // Chercher par ID
        System.out.println("===== Recherche par ID (5) =====");
        Produit produit = produitsRepository.findById(5).get();
        System.out.println("Produit trouvé: " + produit.toString());

        // Recherche par nom
        System.out.println("===== Recherche par nom =====");
        produitsRepository.findByNomContains("de").forEach(p -> {
            System.out.println(p.toString());
        });

        // Recherche par prix
        System.out.println("===== Recherche par prix =====");
        produitsRepository.findByPrix(10.00).forEach(p -> {
            System.out.println(p.toString());
        });

        // Recherche par double critères
        System.out.println("===== Recherche par double critères =====");
        produitsRepository.findByNomContainsAndPrix("p", 10.00).forEach(p -> {
            System.out.println(p.toString());
        });

        // Supprimer le produit avec l'id 9
        produitsRepository.deleteById(9);
        System.out.println("===== Produit avec ID 9 supprimé =====");
    }
}