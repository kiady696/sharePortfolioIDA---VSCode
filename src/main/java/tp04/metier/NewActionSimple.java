package tp04.metier;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe représentant une action simple avec ses cours associés
 * Auteur : Ismaila
 */
public class NewActionSimple {
    // Libellé de l'action
    private String libelle;

    // Map des cours (clé = date, valeur = objet Cours)
    private Map<String, Cours> mapCours;

    // Valeur par défaut à retourner si aucun cours n'est trouvé
    private static final Double VALEUR_PAR_DEFAUT = 0.0;

    // Constructeur
    public NewActionSimple(String libelle, Map<String, Cours> mapCours) {
        this.libelle = libelle;
        this.mapCours = mapCours != null ? mapCours : new HashMap<>();
    }

    // Getters et Setters
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Map<String, Cours> getMapCours() {
        return mapCours;
    }

    public void setMapCours(Map<String, Cours> mapCours) {
        this.mapCours = mapCours;
    }

    /**
     * Enregistre un nouveau cours pour une date donnée s'il n'existe pas déjà
     * @param date La date du cours
     * @param lib Le libellé du cours
     * @param valeur La valeur du cours
     */
    public void enregistrerCours(String date, String lib, Double valeur) {
        if (this.mapCours == null) {
            this.mapCours = new HashMap<>();
        }
        if (!this.mapCours.containsKey(date)) {
            this.mapCours.put(date, new Cours(lib, valeur, date));
        }
    }

    /**
     * Retourne la valeur du cours à une date spécifiée
     * @param date La date du cours
     * @return La valeur du cours ou une valeur par défaut si aucun cours n'est trouvé
     */
    public Double valeur(String date) {
        if (this.mapCours != null && this.mapCours.containsKey(date)) {
            return this.mapCours.get(date).getValeur();
        }
        return VALEUR_PAR_DEFAUT;
    }

    @Override
    public String toString() {
        return "NewActionSimple [libelle=" + libelle + ", mapCours=" + mapCours + "]";
    }
}
