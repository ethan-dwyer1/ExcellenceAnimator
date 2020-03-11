package cs3500.excellence.model.ShapeAnimation;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * An enumeration to represent different expected shapes in the ShapeAnimationModel class.
 */
public enum Shape {
//  private enum shapeType {
    RECTANGLE {
      @Override
      public String toString() {
        return "Rectangle";
      }
    }, OVAL {
      @Override
      public String toString() {
        return "Oval";
      }
    }
//  }

//  private shapeType type;
//  private Color color;
//  private int width;
//  private int height;
//  private Point2D position;
//
//  public Shape(int red, int green, int blue, int width, int height, int x, int y, shapeType type) {
//    this.color = new Color(red, green, blue);
//    this.width = width;
//    this.height = height;
//    this.position = new Point(x, y);
//    this.type = type;
//  }
}
