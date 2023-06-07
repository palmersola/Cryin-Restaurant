package inventoryManagment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;


import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private IngredientList ingredientList;

    @BeforeEach
    public void setup() {
        ingredientList = new IngredientList();
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = new Ingredient("Flour", 50);
        ingredientList.addIngredient(ingredient);

        Ingredient expectedIngredient = new Ingredient("Flour", 50);

        assertEquals("Flour", ingredientList.printName("Flour"));
        assertEquals(50, ingredientList.printQuantity("Flour"));
    }

    @Test
    public void testGetIngredient() {
        Ingredient ingredient = new Ingredient("Sugar", 100);
        ingredientList.addIngredient(ingredient);

        assertEquals("Sugar", ingredientList.printName("Sugar"));
        assertEquals(100, ingredientList.printQuantity("Sugar"));
    }

    @Test
    public void testPrintQuantity() {
        Ingredient ingredient = new Ingredient("Salt", 20);
        ingredientList.addIngredient(ingredient);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ingredientList.printQuantity("Salt");

        String expectedOutput = "20";
        assertEquals(expectedOutput.toString(), outputStream.toString().trim());
    }

    @Test
    public void testPrintAll() {
        Ingredient ingredient1 = new Ingredient("Milk", 30);
        Ingredient ingredient2 = new Ingredient("Eggs", 40);
        ingredientList.addIngredient(ingredient1);
        ingredientList.addIngredient(ingredient2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ingredientList.printAll();

        String expectedOutput = "Eggs: 40" + System.lineSeparator() +
                "Milk: 30" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testLowStock() {
        Ingredient ingredient1 = new Ingredient("Butter", 5);
        Ingredient ingredient2 = new Ingredient("Cheese", 15);
        ingredientList.addIngredient(ingredient1);
        ingredientList.addIngredient(ingredient2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ingredientList.lowStock();

        String expectedOutput = "Butter is low. 5 remaining." + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    public void testUseStock() {
        Ingredient ingredient = new Ingredient("Sugar", 10);
        ingredientList.addIngredient(ingredient);

        ingredientList.useStock("Sugar");
        assertEquals(9, ingredient.getQuantity());
    }

    @Test
    public void testUseStockWithAmount() {
        Ingredient ingredient = new Ingredient("Flour", 50);
        ingredientList.addIngredient(ingredient);

        ingredientList.useStock("Flour", 20);
        assertEquals(30, ingredient.getQuantity());
    }

    @Test
    public void testAddStock() {
        Ingredient ingredient = new Ingredient("Milk", 20);
        ingredientList.addIngredient(ingredient);

        ingredientList.addStock("Milk");
        assertEquals(21, ingredient.getQuantity());
    }

    @Test
    public void testAddStockWithAmount() {
        Ingredient ingredient = new Ingredient("Eggs", 10);
        ingredientList.addIngredient(ingredient);

        ingredientList.addStock("Eggs", 5);
        assertEquals(15, ingredient.getQuantity());
    }
}
