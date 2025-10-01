package task1;

public class Square implements Shape {

    private Draw2d draw2d;
    private Draw3d draw3d;

    // Constructor Injection
    public Square(Draw2d draw2d, Draw3d draw3d) {
        this.draw2d = draw2d;
        this.draw3d = draw3d;
    }


    @Override
    public void draw2d() {
        draw2d.draw(getShapName());
    }

    @Override
    public void draw3d() {
        draw3d.draw(getShapName());
    }

    @Override
    public String getShapName() {
        return "Square";
    }
}
