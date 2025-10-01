package task1;

public class Square implements Shape{
    public Draw2d draw2d;
    public Draw3d draw3d;

    //setter method for setter injection
    public void setDrawShapeFor2d(Draw2d draw2d) {
        this.draw2d = draw2d;
    }

    public void setDrawShapeFor3d(Draw3d draw3d) {
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
    public String getShapName() {
        return "Square";
    }
}
