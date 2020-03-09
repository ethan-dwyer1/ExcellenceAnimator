package cs3500.excellence.model.ExcellenceAnimation;

import cs3500.excellence.model.ShapeAnimation.Shape;
import cs3500.excellence.model.ShapeAnimation.ShapeAnimationOperations;
import java.util.List;

public interface ExcellenceAnimationOperations {

  public void setShapeAnimation(String objectId, Shape shape);

  public List<ShapeAnimationOperations> getShapeAnimations();
}
