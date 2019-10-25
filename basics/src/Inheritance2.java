class Dessert{
    public void recipe (Object o) {
        System.out.println("Home-made dessert");
    }
    public void recipe (Dessert d) {
        System.out.println("Follow the Dessert recipe");
    }
}
class Cake extends Dessert {
    public void recipe (Dessert d) {
        System.out.println("Store-bought cake");
    }
    public void recipe (Cake c) {
        System.out.println("Follow the Cake recipe");
    }
}
class Pie extends Dessert {
    public void recipe (Dessert d) {
        System.out.println("Cook the dough");
    }
    public void recipe (Pie p) {
        System.out.println("Follow the Pie recipe");
    }
}

class ApplePie extends Pie {
    public void recipe (Pie p) {
        System.out.println("Cook the dough with sugar tossed apples");
    }
    public void recipe (ApplePie ap) {
        System.out.println("Follow the Apple Pie recipe");
    }
}

class ApplePieCake extends ApplePie {
    public void recipe (Object o) {
        System.out.println("Home-made Apple Pie Cake");
    }
    public void recipe (Pie p) {
        System.out.println("Beat Cake ingredients and pour into pan");
    }
    public void recipe (ApplePie ap) {
        System.out.println("Spread sugar tossed apple mixture evenly over cake batter");
    }
    public void recipe (ApplePieCake apc) {
        System.out.println("Follow the Apple Pie Cake recipe");
    }
}




public class Inheritance2 {
    public static void main(String[] args) {
        Pie p = new Pie();

        ApplePie ap = new ApplePie();

        Cake c = new Cake();

        ApplePieCake apc = new ApplePieCake();

        ap.recipe(ap);
        c.recipe(p);
        apc.recipe(ap);
        apc.recipe(p);
        ap.recipe(p);
    }
}



//    Follow the Apple Pie recipe
//        Store-bought cake
//        Spread sugar tossed apple mixture evenly over cake batter
//        Beat Cake ingredients and pour into pan
//        Cook the dough with sugar tossed apples