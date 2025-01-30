package tp04.metier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class RecuperationHistorique{


 @Test
    public void testAjouterCours() {
        // Créer un historique pour l'indice "CAC40"
        HistoriqueCours historique = new HistoriqueCours("CAC40");

        // Créer des objets Cours
        Cours cours1 = new Cours("CAC40", 6000.50, "30/01/2025");
        Cours cours2 = new Cours("CAC40", 6050.30,"30/01/2025");

        // Ajouter les cours à l'historique
        historique.ajouterCours(cours1);
        historique.ajouterCours(cours2);

        // Vérifier que l'historique contient bien les cours
        assertEquals(2, historique.obtenirHistorique("CAC40").size());
        assertTrue(historique.obtenirHistorique("CAC40").contains(cours1));
        assertTrue(historique.obtenirHistorique("CAC40").contains(cours2));
    }

    @Test
    public void testAjouterCoursAvecLibelleIncorrect() {
        // Créer un historique pour l'indice "CAC40"
        HistoriqueCours historique = new HistoriqueCours("CAC40");

        // Créer un cours avec un libellé incorrect
        Cours coursIncorrect = new Cours("DAX30", 14000.00,"30/01/2025");

        // Tenter d'ajouter un cours avec un libellé incorrect
        historique.ajouterCours(coursIncorrect);

        // Vérifier que le cours n'est pas ajouté
        assertEquals(0, historique.obtenirHistorique("CAC40").size());
    }

    @Test
    public void testHistoriqueVide() {
        // Créer un historique pour l'indice "CAC40"
        HistoriqueCours historique = new HistoriqueCours("CAC40");

        // Vérifier que l'historique est vide au départ
        assertEquals(0, historique.obtenirHistorique("CAC40").size());
    }

    @Test
    public void testAffichageHistorique() {
        // Créer un historique pour l'indice "CAC40"
        HistoriqueCours historique = new HistoriqueCours("CAC40");

        // Créer des objets Cours
        Cours cours1 = new Cours("CAC40", 6000.50, "30/01/2025");
        Cours cours2 = new Cours("CAC40", 6050.30, "30/01/2025");
        // Ajouter les cours à l'historique
        historique.ajouterCours(cours1);
        historique.ajouterCours(cours2);

        // Vérifier que l'affichage de l'historique fonctionne (cela va passer si aucune exception n'est lancée)
        historique.afficherHistorique();
    }
}

