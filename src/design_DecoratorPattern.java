
//https://en.wikipedia.org/wiki/Decorator_pattern

interface Shape {
    public String draw() ;
}

class Triangle implements Shape {
    public String draw() {
        return "Triangle" ;
    }
}

class Circle implements Shape {
    public String draw() {
        return "Circle" ;
    }
}

abstract class ShapeDecorator implements Shape {
    Shape shape ;
    ShapeDecorator(Shape shape) {
        this.shape = shape ;
    }
}

class ColorDecorator extends ShapeDecorator {
    String color ;
    ColorDecorator(String color, Shape shape) {
        super(shape );
        this.color = color ;
    }
    public String draw() {
        return color + " " + shape.draw() ;
    }
}

class BorderDecorator extends ShapeDecorator {
    String border ;
    BorderDecorator(String border, Shape shape) {
        super(shape );
        this.border = border ;
    }
    public String draw() {
        return border + " " + shape.draw() ;
    }
}

public class design_DecoratorPattern {
    public static void main(String[] args) {
        Shape triangle = new Triangle() ;
        System.out.println(triangle.draw()) ;
        ShapeDecorator cd = new ColorDecorator("Orange",triangle) ;
        System.out.println(cd.draw());
        ShapeDecorator bcd = new BorderDecorator("Dotted Fill",cd) ;
        System.out.println(bcd.draw());
    }
}
