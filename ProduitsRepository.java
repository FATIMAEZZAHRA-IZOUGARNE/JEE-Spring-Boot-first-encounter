package com.fstm.jpa.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fstm.jpa.entities.Produit;

public interface ProduitsRepository extends JpaRepository<Produit, Integer> {

    public List<Produit> findByNomContains(String car);

    public List<Produit> findByPrix(Double prix);

    public List<Produit> findByNomContainsAndPrix(String car, Double prix);
}