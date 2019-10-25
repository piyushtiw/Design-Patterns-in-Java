//class Cake {
//    public void taste (Cake c) {
//        System.out.println("In taste of Cake class");
//    }
//}
//
//class ChocolateCake extends Cake {
//    public void taste(Cake c) {
//        System.out.println("In taste (Cake version) of ChocolateCake class");
//    }
//    public void taste(ChocolateCake cc) {
//        System.out.println("In taste (ChocolateCake version) of ChocolateCake class");
//    }
//}
//
//class BirthdayCake extends ChocolateCake {
//    public void taste(Cake c) {
//        System.out.println("In taste (Cake version) of BirthdayCake class");
//    }
//    public void taste (ChocolateCake cc) {
//        System.out.println("In taste (ChocolateCake version) of BirthdayCake class");
//    }
//    public void taste(BirthdayCake bc) {
//        System.out.println("In taste (BirthdayCake version) of BirthdayCake class");
//    }
//}
//
//
//public class Main {
//    public static void main(String[] args){
//        System.out.println("Hello world!!!");
//
//        Cake c1 = new Cake();
//
//        System.out.println(c1.getClass().getName());
//        ChocolateCake cc = new ChocolateCake();
//
//        System.out.println(cc.getClass().getName());
//
//        Cake c2 = new ChocolateCake();
//
//        System.out.println(c2.getClass().getName());
//        Cake c3 = new BirthdayCake();
//
//        System.out.println(c3.getClass().getName());
//
//        c1.taste(cc);
//        cc.taste(cc);
//        c2.taste(cc);
//        ((BirthdayCake) c3).taste(cc);
//        ((BirthdayCake) c3).taste((BirthdayCake) c3);
//    }
//}
