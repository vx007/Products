import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static ArrayList<Recipe> recipes = new ArrayList<>();
    public static HashMap<Product, Double> products1 = new HashMap<>();
    public static HashMap<Product, Double> products2 = new HashMap<>();

    public static void main(String[] args) {

        try {
            addProduct(products1, new Product("Хлеб", 20));
            addProduct(products1, new Product("Масло", 50));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            addProduct(products2, new Product("Помидор", 30), 10d);
            addProduct(products2, new Product("Огурец", 20), 10d);
            addProduct(products2, new Product("Майонез", 100));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            addRecipe(recipes, new Recipe("Бутерброд", products1));
            addRecipe(recipes, new Recipe("Салад", products2));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(recipes);

    }

    public static void addProduct(HashMap<Product, Double> map, Product product, Double amount) {
        if (!map.containsKey(product)) {
            map.put(product, amount);
        } else {
            throw new IllegalArgumentException("Продукт уже есть!");
        }
    }

    public static void addProduct(HashMap<Product, Double> map, Product product) {
        if (!map.containsKey(product)) {
            map.put(product, 1d);
        } else {
            throw new IllegalArgumentException("Продукт уже есть!");
        }
    }

    public static void addRecipe(ArrayList<Recipe> list, Recipe recipe) {
        if (!list.contains(recipe)) {
            list.add(recipe);
        } else {
            throw new IllegalArgumentException("Рецепт уже есть!");
        }
    }

}
