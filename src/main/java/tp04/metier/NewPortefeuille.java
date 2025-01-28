package tp04.metier;

import java.util.HashMap;
import java.util.Map;

public class NewPortefeuille {

    // Map pour stocker les actions et leurs quantités
    private Map<Action, Integer> portefeuille;

    // Constructeur
    public Portefeuille() {
        this.portefeuille = new HashMap<>();
    }

    /**
     * Acheter une quantité d'une action à une date donnée.
     *
     * @param action   L'action à acheter.
     * @param quantite La quantité à acheter.
     * @param date     La date pour laquelle le cours est utilisé.
     * @throws IllegalArgumentException Si le cours n'existe pas ou si la quantité est invalide.
     */
    public void acheter(Action action, int quantite, String date) {
        // Vérifier que la quantité est positive
        if (quantite <= 0) {
            throw new IllegalArgumentException("La quantité doit être supérieure à zéro.");
        }


        // Vérifier que le cours existe pour la date donnée
        Cours cours = action.getCoursByDate(date);
        if (cours == null) {
            throw new IllegalArgumentException("Aucun cours disponible pour cette action à la date : " + date);
        }

        // Calculer le coût total
        double prixTotal = cours.getValeur() * quantite;
        System.out.println("Achat effectué : " + quantite + " actions de " + action.getLibelle() +
                " à " + cours.getValeur() + "€ par action (Total : " + prixTotal + "€)");

        // Ajouter ou mettre à jour la quantité dans le portefeuille

        portefeuille.put( try: 
                            action, portefeuille.getOrDefault(action, 0) + quantite);
    
                        catch :
    }

    /**
     * Afficher le contenu du portefeuille.
     */
    public void afficherPortefeuille() {
        System.out.println("Contenu du portefeuille :");
        if (portefeuille.isEmpty()) {
            System.out.println("Le portefeuille est vide.");
        } else {
            for (Map.Entry<Action, Integer> entry : portefeuille.entrySet()) {
                System.out.println("Action : " + entry.getKey().getLibelle() + ", Quantité : " + entry.getValue());
            }
        }
    }

    /**
     * Vendre une quantité d'une action.
     *
     * @param action   L'action à vendre.
     * @param quantite La quantité à vendre.
     * @throws IllegalArgumentException Si la quantité est invalide ou si l'action n'est pas possédée en quantité suffisante.
     */
    public void vendre(Action action, int quantite) {
        // Vérifier que la quantité est positive
        if (quantite <= 0) {
            throw new IllegalArgumentException("La quantité doit être supérieure à zéro.");
        }

        // Vérifier que l'action existe dans le portefeuille
        if (!portefeuille.containsKey(action)) {
            throw new IllegalArgumentException("Action non présente dans le portefeuille : " + action.getLibelle());
        }

        // Vérifier que la quantité possédée est suffisante
        int quantitePossedee = portefeuille.get(action);
        if (quantite > quantitePossedee) {
            throw new IllegalArgumentException("Quantité insuffisante à vendre. Possédé : " + quantitePossedee);
        }

        // Mettre à jour ou supprimer l'action dans le portefeuille
        if (quantite == quantitePossedee) {
            // Si on vend tout, on retire l'action du portefeuille
            portefeuille.remove(action);
            System.out.println("Vente effectuée : Toutes les actions de " + action.getLibelle() + " ont été vendues.");
        } else {
            // Si on vend une partie, on met à jour la quantité restante
            portefeuille.put(action, quantitePossedee - quantite);
            System.out.println("Vente effectuée : " + quantite + " actions de " + action.getLibelle() +
                    " ont été vendues. Reste : " + (quantitePossedee - quantite) + " actions.");
        }
    }

    /**
     * Afficher le contenu du portefeuille.
     */
    public void afficherPortefeuille() {
        System.out.println("Contenu du portefeuille :");
        if (portefeuille.isEmpty()) {
            System.out.println("Le portefeuille est vide.");
        } else {
            for (Map.Entry<Action, Integer> entry : portefeuille.entrySet()) {
                System.out.println("Action : " + entry.getKey().getLibelle() + ", Quantité : " + entry.getValue());
            }
        }
    }

}
