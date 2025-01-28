/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.exec;

import tp04.metier.Action;
import tp04.metier.ActionComposee;
import tp04.metier.ActionSimple;
import tp04.metier.Cours;
import tp04.metier.Jour;
import tp04.metier.Portefeuille;

public class Run {

    public static void main(String[] args) {
        // test de la classe Cours
        Cours cours = new Cours("CAC40", 20.4, "27/01/2025");
        System.out.println("Cours 1 : " + cours.toString());
 
    }

}
