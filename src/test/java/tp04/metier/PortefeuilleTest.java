package tp04.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PortefeuilleTest {
    @Test
    void testPortefeuille() {
        // Arange
        final Portefeuille portefeuille = new Portefeuille();

        // Action
        final String expectedToString = "{}";
        final String currentToString = portefeuille.toString();

        // Assert
        Assertions.assertEquals(expectedToString, currentToString, "Basic construction");

    }

    @Test
    void testAddAndRemoveActions() {
        // Arrange
        Portefeuille portefeuille = new Portefeuille();

        ActionSimple action1 = new ActionSimple("Action1");
        ActionSimple action2 = new ActionSimple("Action2");

        // Our test will include the insertion and removal of two actions in one
        // Portefeuille

        // Action
        Jour jour1 = new Jour(2025, 1);
        // We define the values of our two actions on a single day
        action1.enrgCours(jour1, 10);
        action2.enrgCours(jour1, 20);

        // Assert

        // We add the first action, then check if the action is correctly added by
        // comparing it to our predefined String structure
        portefeuille.acheter(action1, 10);
        assertEquals("{Action1=10}", portefeuille.toString());

        // We add the second action, then check if both actions are represented in the
        // correct way in order to verify the addition
        portefeuille.acheter(action2, 20);
        assertEquals("{Action1=10, Action2=20}", portefeuille.toString());

        // We add more to our first action and expect to see the addition on our
        // Portefeuille.
        portefeuille.acheter(action1, 5);
        assertEquals("{Action1=15, Action2=20}", portefeuille.toString());

        // We remove from the first action, we expect to see the decrease on our action
        // quantity
        portefeuille.vendre(action1, 10);
        assertEquals("{Action1=5, Action2=20}", portefeuille.toString());

        // Here we sell all the quantity of our first action, we expect to see only our
        // second action and its value
        portefeuille.vendre(action1, 5);
        assertEquals("{Action2=20}", portefeuille.toString());

        // Here we sell again from the first action, we expect to have no effects on our
        // Portefeuille since all of the action1 is sold
        portefeuille.vendre(action1, 5);
        assertEquals("{Action2=20}", portefeuille.toString());

        // Here we sell the rest of the second action to verify the Portefeuille will be
        // empty
        portefeuille.vendre(action2, 20);
        assertEquals("{}", portefeuille.toString());
    }

    @Test
    void testChangePrix() {
        // Arrange
        final Portefeuille portefeuille = new Portefeuille();
        final ActionSimple action1 = new ActionSimple("Action1");
        final Jour jour1 = new Jour(2025, 29);
        final Jour jour2 = new Jour(2025, 30);

        // Action change le valeur
        action1.enrgCours(jour1, 10);
        portefeuille.acheter(action1, 10);
        action1.enrgCours(jour2, 20);

        // Action
        final String currenToString = portefeuille.verifierChangement(jour1, jour2, action1);
        final String expectedToString = "Le prix du Action1 a changé 10";

        // Assert
        Assertions.assertEquals(expectedToString, currenToString);

    }
}