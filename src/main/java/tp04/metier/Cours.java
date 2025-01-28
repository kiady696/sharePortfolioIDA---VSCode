package tp04.metier;
/**
 * Représente un cours d'action à une date donnée, avec un libellé et une valeur.
 * 
 * @author Ismaila/Kiady
 */
public class Cours {
    /**
     * Libellé du cours d'action.
     */
    private String libCours;

    /**
     * Valeur du cours.
     */
    private Double valeur;

    /**
     * Date associée à la valeur du cours.
     */
    private String dateValeurCours;

    /**
     * Constructeur de la classe Cours.
     * 
     * @param lib  Le libellé du cours.
     * @param val  La valeur du cours.
     * @param date La date associée à la valeur du cours.
     */
    public Cours(String lib, Double val, String date) {
        this.libCours = lib;
        this.valeur = val;
        this.dateValeurCours = date;
    }

    /**
     * Récupère le libellé du cours d'action.
     * 
     * @return Le libellé du cours.
     */
    public String getLibCours() {
        return libCours;
    }

    /**
     * Définit le libellé du cours d'action.
     * 
     * @param libCours Le nouveau libellé du cours.
     */
    public void setLibCours(String libCours) {
        this.libCours = libCours;
    }

    /**
     * Récupère la valeur du cours.
     * 
     * @return La valeur du cours.
     */
    public Double getValeur() {
        return valeur;
    }

    /**
     * Définit la valeur du cours.
     * 
     * @param valeur La nouvelle valeur du cours.
     */
    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    /**
     * Récupère la date associée à la valeur du cours.
     * 
     * @return La date de la valeur du cours.
     */
    public String getDateValeurCours() {
        return dateValeurCours;
    }

    /**
     * Définit la date associée à la valeur du cours.
     * 
     * @param dateValeurCours La nouvelle date de la valeur du cours.
     */
    public void setDateValeurCours(String dateValeurCours) {
        this.dateValeurCours = dateValeurCours;
    }

    /**
     * Renvoie une représentation textuelle de l'objet Cours.
     * 
     * @return Une chaîne de caractères décrivant le cours (libellé, valeur et date).
     */
    @Override
    public String toString() {
        return "Cours [getLibCours()=" + getLibCours() + ", getValeur()=" + getValeur() + ", getDateValeurCours()="
                + getDateValeurCours() + "]";
    }
}
