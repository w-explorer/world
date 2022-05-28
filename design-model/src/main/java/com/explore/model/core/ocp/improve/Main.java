package com.explore.model.core.ocp.improve;

/**
 * @author wencheng
 * @create 2022/5/24 20:41
 */
public class Main {

    public static void main(String[] args) {
        GraphicREdit graphicREdit = new GraphicREdit();
        graphicREdit.drawShape(new Cycle());
        graphicREdit.drawShape(new Rectangle());

    }

}


class GraphicREdit{
    public void drawShape(Shape shape){
        shape.draw();
    }
}



abstract class Shape{
    int type;

    public abstract void draw();
}

class Cycle extends Shape{

    Cycle(){
        super.type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Rectangle extends Shape{
    public Rectangle() {
        super.type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}
