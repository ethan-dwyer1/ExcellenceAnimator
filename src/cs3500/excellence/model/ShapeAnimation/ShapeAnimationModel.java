package cs3500.excellence.model.ShapeAnimation;

import cs3500.excellence.model.Animation.AnimationModel;
import cs3500.excellence.model.Animation.AnimationOperations;
import cs3500.excellence.model.AnimationState;
import java.awt.Color;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class ShapeAnimationModel implements ShapeAnimationOperations, AnimationState {

  private final String objectId;
  private final Shape shape;
  private List<AnimationOperations> animationList;

  /**
   * Public constructor for a ShapeAnimationModel.  Initializes an empty list of Animations and sets
   * the object ID and type of shape.
   *
   * @param objectId ID for the shape.
   * @param shape    type of shape.
   * @throws IllegalArgumentException if either of the inputs are null.
   */
  public ShapeAnimationModel(String objectId, Shape shape) {
    if (objectId == null || shape == null) {
      throw new IllegalArgumentException("Parameters cannot be null");
    }
    this.objectId = objectId;
    this.shape = shape;
    this.animationList = new ArrayList<>();
  }

  @Override
  public Point2D getCurrentPosition() {
    //TODO: Implement once we can get the current position from the controller.
    return null;
  }

  @Override
  public Dimension2D getCurrentDimensions() {
    //TODO: Implement once we can get the current dimensions from the controller.
    return null;
  }

  @Override
  public Color getCurrentColor() {
    //TODO: Implement once we can get the current color from the controller.
    return null;
  }

  @Override
  public List<AnimationOperations> getAnimations() {
    return animationList;
  }

  @Override
  public void setAnimation(String objectId, int startTick, int endTick, int startX, int endX,
      int startY, int endY,
      int startWidth, int endWidth, int startHeight, int endHeight, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue) {

    for (AnimationOperations i : animationList) {
      //We need to check that the animations do not overlap
      if ((startTick > i.getStartTick() && startTick < i.getEndTick())
          || (endTick > i.getStartTick() && endTick < i.getEndTick())) {
        throw new IllegalArgumentException(
            "Cannot start a new animation until the first is complete.");
      }
    }

    AnimationModel a = new AnimationModel(objectId, startTick, endTick, startX, endX, startY, endY,
        startWidth, endWidth, startHeight, endHeight, startRed, endRed, startGreen, endGreen,
        startBlue, endBlue);
    animationList.add(a);
  }

  @Override
  public String getObjectId() {
    return objectId;
  }

  @Override
  public String toString() {
    String out = "Shape " + objectId + " " + shape.toString() + "\n";
    for (AnimationOperations i : animationList) {
      out += "motion " + objectId + i.toString();
    }
    out += "\n";
    return out;
  }
}
