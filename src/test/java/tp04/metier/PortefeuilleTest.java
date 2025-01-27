package tp04.metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PortefeuilleTest {
    @Test
    void testPortefeuille(){
        //Arange
        final Portefeuille portefeuille = new Portefeuille();

        //Action
        final String expectedToString = "{}";
        final String currentToString = portefeuille.toString();

        //Assert
        Assertions.assertEquals(expectedToString, currentToString, "Basic construction");
        
    }
}