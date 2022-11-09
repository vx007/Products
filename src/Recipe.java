import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    private String name;
    private double sumPrice;
    private ArrayList<Product> products;

    public Recipe(String name) {
        this(name, new ArrayList<>());
    }

    public Recipe(String name, ArrayList<Product> products) {
        setName(name);
        setProducts(products);
    }

    public String getName() {
        return name;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new InvalidParameterException("Не заполнено НАЗВАНИЕ!");
        }
    }

    public void setProducts(ArrayList<Product> products) {
        this.sumPrice = calcPrice(products);
        this.products = products;
    }

    public double calcPrice(ArrayList<Product> products) {
        double price = 0.0;
        for (Product element : products) {
            price += element.getPrice();
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
