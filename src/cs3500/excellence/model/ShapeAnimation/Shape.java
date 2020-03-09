package cs3500.excellence.model.ShapeAnimation;

public enum Shape {
  RECTANGLE{
    @Override
    public String toString() {
      return "Rectangle";
    }
  }, OVAL{
    @Override
    public String toString() {
      return "Oval";
    }
  };

}
