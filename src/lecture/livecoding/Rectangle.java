package lecture.livecoding;

/*
    O clasa derivata dintr-o clasa abstracta are 2 optiuni:
        - Este si ea clasa abstracta (poate implementa unele sau toate metodele abstracte
        mostenite
        - Devine clasa concreta (implementeaza toate metodele abstracte)
 */
public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(int id, int width, int height) {
        // daca avem doar acest constructor, pierdem numele obiectului
        // (nu se mai seteaza name din clasa Shape)
        super(id);
        this.width = width;
        this.height = height;
    }

    public Rectangle(int id, String name, int width, int height) {
        super(id, name);
        this.width = width;
        this.height = height;
    }

    @Override
    public float getArea() {
        return width * height;
    }
}
