package cs3500.excellence.model.ExcellenceAnimation;

import cs3500.excellence.model.ShapeAnimation.ShapeAnimationModel;
import cs3500.excellence.model.ShapeAnimation.ShapeAnimationOperations;
import java.util.List;

public interface ExcellenceAnimationOperations {

  /**
   * Adds a shape to the list of ShapeAnimationModel objects.
   *
   * @param shapeAnimation Object of type interface ShapeAnimationOperations.
   */
  void addShapeAnimation(ShapeAnimationModel shapeAnimation);

  /**
   * Returns a list of all the shape objects in the list.
   *
   * @return List of shape objects.
   */
  List<ShapeAnimationOperations> getShapeAnimations();

  /**
   * Returns the shape with the given objectId.
   *
   * @param objectId String representing objectId of a shape.
   * @return ShapeAnimationModel for the shape with given objectId.
   * @throws IllegalArgumentException if a shape with the given objectId does not exist.
   */
  ShapeAnimationOperations getShapeWithObjectId(String objectId);

  /**
   * Updates the ShapeAnimationOperations given the current tick
   *
   * @param tick the current tick of the animation
   */

  void animationAtCurrentTick(int tick);
}
