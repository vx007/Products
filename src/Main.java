import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static ArrayList<Product> products1 = new ArrayList<>();
    public static ArrayList<Product> products2 = new ArrayList<>();
    public static HashSet<Recipe> recipes = new HashSet<>();

    public static void main(String[] args) {

        try {
            addProductToList(products1, new Product("Бананы", 120, 0.125));
            addProductToList(products1, new Product("Хлеб", 30, 3));
            addProductToList(products1, new Product("Молоко", 100, 1));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("1й список продуктов: " + products1);
        }

        try {
            addProductToList(products2, new Product("Яйцо", 200, 0.1));
            addProductToList(products2, new Product("Майонез", 50, 1));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("2й список продуктов: " + products2);
        }

        try {
            addRecipe(recipes, new Recipe("Банановый хлеб с молоком", products1));
            addRecipe(recipes, new Recipe("Яйцо с майонезом", products2));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Список рецептов: " + recipes);
        }


    }

    public static void addProductToList(ArrayList<Product> products, Product product) {
        if (!products.contains(product)) {
            products.add(product);
        } else {
            throw new IllegalArgumentException("Продукт уже есть!");
        }
    }

    public static void addRecipe(HashSet<Recipe> recipes, Recipe recipe) {
        if (!recipes.contains(recipe)) {
            recipes.add(recipe);
        } else {
            throw new IllegalArgumentException("Рецепт с таким названием уже есть!");
        }
    }


}
