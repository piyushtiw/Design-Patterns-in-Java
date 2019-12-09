import java.util.ArrayList;
import java.util.List;

interface Shape1 {

    public void draw(String fillColor);
}

class Triangle1 implements Shape1 {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color "+fillColor);
    }

}

class Circle implements Shape1 {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color "+fillColor);
    }

}

class Drawing implements Shape1{

    //collection of Shapes
    private List<Shape1> shapes = new ArrayList<Shape1>();

    @Override
    public void draw(String fillColor) {
        for(Shape1 sh : shapes)
        {
            sh.draw(fillColor);
        }
    }

    //adding shape to drawing
    public void add(Shape1 s){
        this.shapes.add(s);
    }

    //removing shape from drawing
    public void remove(Shape1 s){
        shapes.remove(s);
    }

    //removing all the shapes
    public void clear(){
        System.out.println("Clearing all the shapes from drawing");
        this.shapes.clear();
    }
}

class CompositePattern {

    public static void main(String[] args) {
        Shape1 tri = new Triangle1();
        Shape1 tri1 = new Triangle1();
        Shape1 cir = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(tri1);
        drawing.add(tri1);
        drawing.add(cir);

        drawing.draw("Red");

        drawing.clear();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Green");
    }
}
