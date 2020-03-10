package cs3500.excellence.model.ExcellenceAnimation;

import cs3500.excellence.model.ShapeAnimation.Shape;
import cs3500.excellence.model.ShapeAnimation.ShapeAnimationModel;
import cs3500.excellence.model.ShapeAnimation.ShapeAnimationOperations;
import java.util.ArrayList;
import java.util.List;

public class ExcellenceAnimationModel implements ExcellenceAnimationOperations {

  private final List<ShapeAnimationOperations> shapeAnimations;

  /**
   * Public constructor for the ExcellenceAnimationModel. Creates an empty list to hold the shape
   * objects.
   */
  public ExcellenceAnimationModel() {
    this.shapeAnimations = new ArrayList<ShapeAnimationOperations>();
  }

  @Override
  public void setShapeAnimation(String objectId, Shape shape) {
    if (shape == null || objectId == null) {
      throw new IllegalArgumentException("Parameters cannot be null");
    }
    for (ShapeAnimationOperations i : shapeAnimations) {
      if (i.getObjectId().equals(objectId)) {
        throw new IllegalArgumentException("Object Id's cannot be the same");
      }
    }
    ShapeAnimationOperations temp = new ShapeAnimationModel(objectId, shape);
    shapeAnimations.add(temp);
  }

  @Override
  public List<ShapeAnimationOperations> getShapeAnimations() {
    return shapeAnimations;
  }

  @Override
  public ShapeAnimationOperations getShapeWithObjectId(String objectId) {
    for (ShapeAnimationOperations i : shapeAnimations) {
      if (i.getObjectId().equals(objectId)) {
        return i;
      }
    }
    throw new IllegalArgumentException("A shape with this objectId does not exist.");
  }

  @Override
  public String toString() {
    String out = "";
    for (ShapeAnimationOperations i : shapeAnimations) {
      out += i.toString();
    }
    return out;
  }
}
