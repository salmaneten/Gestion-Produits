package dao;

import metier.entities.Produit;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        ProduitDaoImpl dao= new ProduitDaoImpl();
        //Produit p1 = dao.save(new Produit("hp 6580", 900, 45));
        //Produit p2 = dao.save(new Produit("hp Imprimente", 1000, 15));
        System.out.println("chercher des produits");
        List<Produit> produits = dao.produitParMC("%h%");
        for (Produit p : produits){
            System.out.println(p.toString());
        }

    }
}
