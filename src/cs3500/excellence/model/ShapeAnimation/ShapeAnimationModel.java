package cs3500.excellence.model.ShapeAnimation;

import cs3500.excellence.model.Animation.AnimationModel;
import cs3500.excellence.model.Animation.AnimationOperations;
import java.awt.Color;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A model to represent the animations applied to a single shape over a period of ticks.
 */
public class ShapeAnimationModel implements ShapeAnimationOperations {

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

  /**
   * Copy constructor for a ShapeAnimationModel.
   *
   * @param s ShapeAnimationModel object.
   */
  public ShapeAnimationModel(ShapeAnimationModel s) {
    this.objectId = s.objectId;
    this.shape = s.shape;
    this.animationList = s.animationList;
  }

  @Override
  public Point2D getCurrentPosition() {
    return shape.getPosition();
  }

  @Override
  public Dimension2D getCurrentDimensions() {
    return shape.getDimensions();
  }

  @Override
  public Color getCurrentColor() {
    return shape.getColor();
  }

  @Override
  public List<AnimationOperations> getAnimations() {
    return animationList;
  }

  @Override
  public void addAnimation(int startTick, int endTick, int startX, int endX,
      int startY, int endY,
      int startWidth, int endWidth, int startHeight, int endHeight, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue) {

    for (AnimationOperations i : animationList) {
      //We need to check that the animations do not overlap
      if ((startTick > i.getStartTick() && startTick < i.getEndTick())
          || (endTick > i.getStartTick() && endTick < i.getEndTick())
          || (endTick == i.getEndTick() || startTick == i.getStartTick())) {
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
  public void moveAtCurrentTick(int currentTick) {
    for (AnimationOperations a : animationList) {
      if (currentTick > a.getStartTick() && currentTick <= a.getEndTick()) {
        shape.setDimensions(a.getWidthChange(), a.getHeightChange());
        shape.setPosition(a.getXChange(), a.getYChange());
        shape.setColor(a.getRedChange(), a.getGreenChange(), a.getBlueChange());
      }

    }
  }

  @Override
  public String toString() {
    String out = "Shape " + objectId + " " + shape.toString() + "\n";
    for (AnimationOperations i : animationList) {
      out += "motion " + objectId + " " + i.toString();
    }
    out += "\n";
    return out;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof ShapeAnimationModel)) {
      return false;
    }

    ShapeAnimationModel s = (ShapeAnimationModel) obj;

    if (s.animationList.size() != this.animationList.size()) {
      return false;
    }

    for (int i = 0; i < this.animationList.size(); i++) {
      if (!s.animationList.get(i).equals(this.animationList.get(i))) {
        return false;
      }
    }

    return this.objectId.equals(s.objectId) && this.shape == s.shape;
  }

  @Override
  public int hashCode() {
    ArrayList<String> values = new ArrayList<>();
    for (int i = 0; i < animationList.size(); i++) {
      values.add(animationList.get(i).toString());
    }
    Collections.sort(values);
    String hashable = "";
    for (String i : values) {
      hashable += i;
    }
    return Objects.hash(objectId, shape, hashable);
  }
}
