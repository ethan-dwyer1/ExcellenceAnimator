package cs3500.excellence.model.ShapeAnimation;

/**
 * An enumeration to represent different expected shapes in the ShapeAnimationModel class.
 */
public enum Shape {
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
  };

}
