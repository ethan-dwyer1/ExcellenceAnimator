package cs3500.excellence.model.ShapeAnimation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

/**
 * An enumeration to represent different expected shapes in the ShapeAnimationModel class.
 */
public class Shape {

  public enum shapeType {
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
  }

  private shapeType type;
  private Color color;
  private Dimension2D dimensions;
  private Point2D position;

  public Shape(int red, int green, int blue, int width, int height, int x, int y, shapeType type) {
    this.color = new Color(red, green, blue);
    this.dimensions = new Dimension(width, height);
    this.position = new Point(x, y);
    this.type = type;
  }

  public Color getColor() {
    return color;
  }

  public Dimension2D getDimensions() {
    return dimensions;
  }

  public Point2D getPosition() {
    return position;
  }

  public void setColor(int red, int green, int blue) {
    this.color = new Color(color.getRed() + red, color.getGreen() + green,
        color.getBlue() + blue);

  }

  public void setDimensions(int width, int height) {
    this.dimensions = new Dimension((int) dimensions.getWidth() + width,
        (int) dimensions.getHeight() + height);
  }

  public void setPosition(int x, int y) {
    this.position = new Point((int) position.getX() + x, (int) position.getY() + y);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Shape)) {
      return false;
    }

    Shape s = (Shape) obj;

    return s.type == this.type && s.color.equals(this.color) && this.position.equals(s.position)
        && this.dimensions.equals(s.dimensions);
  }

  @Override
  public String toString() {
    return type.toString();
  }
}
