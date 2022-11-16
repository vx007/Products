import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Recipe {
    private String name;
    private double sumPrice;
    private HashMap<Product, Double> products;

    public Recipe(String name, HashMap<Product, Double> products) {
        setName(name);
        setProducts(products);
    }

    public String getName() {
        return name;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public HashMap<Product, Double> getProducts() {
        return products;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new InvalidParameterException("Не заполнено НАЗВАНИЕ!");
        }
    }

    public void setProducts(HashMap<Product, Double> products) {
        this.sumPrice = calcPrice(products);
        this.products = products;
    }

    public double calcPrice(HashMap<Product, Double> products) {
        double price = 0d;
        for (Map.Entry<Product, Double> element: products.entrySet()) {
            price += element.getKey().getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("'%s'(Цена %.2f руб, Список продуктов: %s)", name, sumPrice, products.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return name.equals(recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
