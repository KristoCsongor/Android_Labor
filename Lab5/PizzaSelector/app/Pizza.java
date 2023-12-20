// Pizza.java
public class Pizza {
    private String name;
    private double basePrice;
    private boolean selected;
    private List<Topping> toppings;

    public Pizza(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.selected = false;
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(String name, double price) {
        toppings.add(new Topping(name, price));
    }
}

