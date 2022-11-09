import java.security.InvalidParameterException;
import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private double weight;

    public Product(String name, double price, double weight) {
        setName(name);
        setPrice(price);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new InvalidParameterException("Не заполнено НАЗВАНИЕ!");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        } else {
            throw new InvalidParameterException("Неверно указана цена!");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new InvalidParameterException("Неверно указано КОЛИЧЕСТВО!");
        }
    }

    @Override
    public String toString() {
        return String.format("'%s'(Цена %.2f руб, Вес %.2f кг)", name, price, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 &&
               Double.compare(product.weight, weight) == 0 &&
               name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }
}
