/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

/**
 *
 * @author perussel
 */
public class Cours {
    // libellé de la cours d'action
    private String libCours;
    // la valeur du cours
    private Double valeur;
    // date de la valeur en cours
    private String dateValeurCours;

    public Cours(){
        this.libCours = null;
        this.valeur = null;
        this.dateValeurCours = null;
    }

    public String getLibCours() {
        return libCours;
    }

    public void setLibCours(String libCours) {
        this.libCours = libCours;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public String getDateValeurCours() {
        return dateValeurCours;
    }

    public void setDateValeurCours(String dateValeurCours) {
        this.dateValeurCours = dateValeurCours;
    }

    public Cours(String lib, Double val, String date){
        this.libCours = lib;
        this.valeur = val;
        this.dateValeurCours = date;
    }

    @Override
    public String toString() {
        return "Cours [getLibCours()=" + getLibCours() + ", getValeur()=" + getValeur() + ", getDateValeurCours()="
                + getDateValeurCours() + "]";
    }

    public Object getLibelle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLibelle'");
    }

    

    
    
}
