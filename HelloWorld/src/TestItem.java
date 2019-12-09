class Item
{
    private final String name;
    private final String cuisine;
    private final float price;
    private final boolean homeDelivery;
    private final String category;

    public class ItemBuilder(Item obj) {
        this.name = obj.name;
        this.cuisine = obj.cuisine;
        this.price = obj.price;
        this.homeDelivery = obj.homeDelivery;
        this.category = obj.category;
    }

    public String getName() {  return name;  }
    public String getCuisine() {   return cuisine;  }
    public float getPrice() {    return price;   }
    public boolean getHomeDelivery() {   return homeDelivery;  }
    public String getCategory() {     return category;  }

    @Override
    public String toString() {
        if (this.homeDelivery)
            return "Item: "+this.name+", "+this.cuisine+", "+this.price+", Home Delivery available, "+this.category;

        return "Item: "+this.name+", "+this.cuisine+", "+this.price+", Home Delivery not available, "+this.category;

    }

    public static class ItemBuilder
    {
        private final String name;
        private final String cuisine;
        private float price;
        private boolean homeDelivery;
        private String category;

        public ItemBuilder(String name, String cuisine) {
        this.name = name;
        this.cuisine = cuisine;
    }
        public ItemBuilder price(float price) {
        this.price = price;
        return this;
    }
        public ItemBuilder homeDelivery(boolean homeDelivery) {
        this.homeDelivery = homeDelivery;
        return this;
    }
        public ItemBuilder category(String category) {
        this.category = category;
        return this;
    }
        public Item build() {
        return new Item;
    }
    }
}

public class TestItem {
    public static void main(String[] args) {
        Item item1 = new Item.ItemBuilder("Pumpkin Pie", "American").price(15).homeDelivery(true).category("Dessert").build();
        Item item2 = new Item.ItemBuilder("Grilled Tomato-Peach Pizza", "Italian").price(10).category("Appetizer").build();

        System.out.println(item1);
        System.out.println(item2);
    }
}