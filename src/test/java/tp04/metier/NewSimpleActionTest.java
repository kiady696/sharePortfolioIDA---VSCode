package tp04.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewSimpleActionTest {
     private NewActionSimple action;
    private Map<String, Cours> mapCours;
    private static final String TEST_LIBELLE = "Test Action";
    private static final String TEST_DATE = "2025-01-30";
    private static final Double TEST_VALEUR = 100.0;
    
    @BeforeEach
    void setUp() {
        mapCours = new HashMap<>();
        action = new NewActionSimple(TEST_LIBELLE, mapCours);
    }
    
    @Test
    void testConstructorWithValidParameters() {
        assertNotNull(action);
        assertEquals(TEST_LIBELLE, action.getLibelle());
        assertNotNull(action.getMapCours());
    }
    
    @Test
    void testConstructorWithNullMap() {
        NewActionSimple actionWithNullMap = new NewActionSimple(TEST_LIBELLE, null);
        assertNotNull(actionWithNullMap.getMapCours());
        assertTrue(actionWithNullMap.getMapCours().isEmpty());
    }
    
    @Test
    void testSetAndGetLibelle() {
        String newLibelle = "New Test Libelle";
        action.setLibelle(newLibelle);
        assertEquals(newLibelle, action.getLibelle());
    }
    
    @Test
    void testSetAndGetMapCours() {
        Map<String, Cours> newMap = new HashMap<>();
        newMap.put(TEST_DATE, new Cours("Test", 200.0, TEST_DATE));
        action.setMapCours(newMap);
        assertEquals(newMap, action.getMapCours());
    }
    
    @Test
    void testEnregistrerCoursNewEntry() {
        action.enregistrerCours(TEST_DATE, "Test Cours", TEST_VALEUR);
        assertTrue(action.getMapCours().containsKey(TEST_DATE));
        assertEquals(TEST_VALEUR, action.getMapCours().get(TEST_DATE).getValeur());
    }
    
    @Test
    void testEnregistrerCoursExistingEntry() {
        // First entry
        action.enregistrerCours(TEST_DATE, "Test Cours", TEST_VALEUR);
        
        // Attempt to override with different value
        action.enregistrerCours(TEST_DATE, "New Test Cours", 200.0);
        
        // Should keep the original value
        assertEquals(TEST_VALEUR, action.getMapCours().get(TEST_DATE).getValeur());
    }
    
    @Test
    void testEnregistrerCoursWithNullMap() {
        action.setMapCours(null);
        action.enregistrerCours(TEST_DATE, "Test Cours", TEST_VALEUR);
        assertNotNull(action.getMapCours());
        assertTrue(action.getMapCours().containsKey(TEST_DATE));
    }
    
    @Test
    void testValeurExistingDate() {
        action.enregistrerCours(TEST_DATE, "Test Cours", TEST_VALEUR);
        assertEquals(TEST_VALEUR, action.valeur(TEST_DATE));
    }
    
    @Test
    void testValeurNonExistingDate() {
        assertEquals(0.0, action.valeur("2025-02-01"));
    }
    
    @Test
    void testValeurWithNullMap() {
        action.setMapCours(null);
        assertEquals(0.0, action.valeur(TEST_DATE));
    }
    
    @Test
    void testToString() {
        action.enregistrerCours(TEST_DATE, "Test Cours", TEST_VALEUR);
        String toString = action.toString();
        assertTrue(toString.contains(TEST_LIBELLE));
        assertTrue(toString.contains("mapCours"));
    }
}
