package tp04.metier;

import java.util.ArrayList;
import java.util.List;

public class HistoriqueCours {
    private String libelle; 
    private List<Cours> historique; 

    // Constructeur
    public HistoriqueCours(String libelle) {
        this.libelle = libelle;
        this.historique = new ArrayList<>();
    }

    // Ajouter un cours à l'historique
    public void ajouterCours(Cours cours) {
        if (cours.getLibelle().equals(this.libelle)) {
            historique.add(cours);
        } else {
            System.out.println("Le libellé du cours ne correspond pas à l'indice.");
        }
    }

    // Obtenir l'historique des cours pour cet indice
    public List<Cours> obtenirHistorique(String libelleCours = "") {
        
        return historique;
    }

    // Afficher l'historique des cours
    public void afficherHistorique() {
        System.out.println("Historique des cours de l'indice " + libelle + ":");
        for (Cours cours : historique) {
            System.out.println(cours);
        }
    }

}