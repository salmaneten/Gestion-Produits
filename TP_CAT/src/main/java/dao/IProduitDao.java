package dao;

import metier.entities.Produit;

import java.util.List;

public interface IProduitDao {
    public Produit save(Produit p);
    public List<Produit> produitParMC(String mc);
    public Produit getProduit(Long id);
    public Produit updateProduit(Produit p);
    public void deleteProduit(Long id);
}
