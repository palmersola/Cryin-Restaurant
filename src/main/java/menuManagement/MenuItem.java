package menuManagement;

import inventoryManagment.Ingredient;

import java.util.List;

public class MenuItem {
    private String name;
    private String description;
    private int preparationTime;
    private double price;
    private List<Ingredient> ingredients;
    private int timesOrdered;

    public MenuItem(String name, String description, int preparationTime, double price, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.preparationTime = preparationTime;
        this.price = price;
        this.ingredients = ingredients;
        this.timesOrdered = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public double getPrice() {
        return price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getTimesOrdered() {
        return "   " + this.name + ": " + this.timesOrdered + "\n";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setTimesOrdered(double amount){
        this.timesOrdered += amount;
    }
}


