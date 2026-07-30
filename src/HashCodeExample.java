class Laptop{
    String model;
    int price;

    public String toString() {
        return "Laptop [model=" + model + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (price != other.price)
            return false;
        return true;
    }

    
}
class Demo{
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.model = "Dell";
        l1.price = 50000;

        Laptop l2 = new Laptop();
        l2.model = "Dell";
        l2.price = 50000;

        System.out.println(l1.hashCode());
        System.out.println(l2.hashCode());

        System.out.println(l1.equals(l2));
    }
}


/*

class Laptop {
    private final String model;
    private final int price;

    private static final Map<Laptop, Laptop> cache = new HashMap<>();

    private Laptop(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public static Laptop of(String model, int price) {
        Laptop key = new Laptop(model, price);
        Laptop existing = cache.get(key);
        if (existing != null) {
            return existing;
        }
        cache.put(key, key);
        return key;
    }

    @Override
    public boolean equals(Object obj) { ... }
    @Override
    public int hashCode() { ... }
}

Then use:
Laptop l1 = Laptop.of("Dell", 50000);
Laptop l2 = Laptop.of("Dell", 50000);


*/