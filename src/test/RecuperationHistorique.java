import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

 @Test
    public void testAjouterCours() {
        // Créer un historique pour l'indice "CAC40"
        HistoriqueCours historique = new HistoriqueCours("CAC40");

        // Créer des objets Cours
        CoursHistorique cours1 = new CoursHistorique("CAC40", 6000.50, LocalDate.of(2025, 1, 1));
        CoursHistorique cours2 = new CoursHistorique("CAC40", 6050.30, LocalDate.of(2025, 1, 2));

        // Ajouter les cours à l'historique
        historique.ajouterCours(cours1);
        historique.ajouterCours(cours2);

        // Vérifier que l'historique contient bien les cours
        assertEquals(2, historique.obtenirHistorique().size());
        assertTrue(historique.obtenirHistorique().contains(cours1));
        assertTrue(historique.obtenirHistorique().contains(cours2));
    }

    @Test
    public void testAjouterCoursAvecLibelleIncorrect() {
        // Créer un historique pour l'indice "CAC40"
        HistoriqueCours historique = new HistoriqueCours("CAC40");

        // Créer un cours avec un libellé incorrect
        CoursHistorique coursIncorrect = new CoursHistorique("DAX30", 14000.00, LocalDate.of(2025, 1, 1));

        // Tenter d'ajouter un cours avec un libellé incorrect
        historique.ajouterCours(coursIncorrect);

        // Vérifier que le cours n'est pas ajouté
        assertEquals(0, historique.obtenirHistorique().size());
    }

    @Test
    public void testHistoriqueVide() {
        // Créer un historique pour l'indice "CAC40"
        HistoriqueCours historique = new HistoriqueCours("CAC40");

        // Vérifier que l'historique est vide au départ
        assertEquals(0, historique.obtenirHistorique().size());
    }

    @Test
    public void testAffichageHistorique() {
        // Créer un historique pour l'indice "CAC40"
        HistoriqueCours historique = new HistoriqueCours("CAC40");

        // Créer des objets Cours
        CoursHistorique cours1 = new CoursHistorique("CAC40", 6000.50, LocalDate.of(2025, 1, 1));
        CoursHistorique cours2 = new CoursHistorique("CAC40", 6050.30, LocalDate.of(2025, 1, 2));

        // Ajouter les cours à l'historique
        historique.ajouterCours(cours1);
        historique.ajouterCours(cours2);

        // Vérifier que l'affichage de l'historique fonctionne (cela va passer si aucune exception n'est lancée)
        historique.afficherHistorique();
    }


