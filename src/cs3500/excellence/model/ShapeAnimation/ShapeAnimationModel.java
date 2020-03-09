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

  public ShapeAnimationModel(String objectId, Shape shape) {
    if(objectId == null || shape == null) {
      throw new IllegalArgumentException("Parameters cannot be null");
    }
    this.objectId = objectId;
    this.shape = shape;
    this.animationList = new ArrayList<AnimationOperations>();
  }

  @Override
  public Point2D getCurrentPosition() {
    //TODO: Implement later
    return null;
  }

  @Override
  public Dimension2D getCurrentDimensions() {
    //TODO: Implement later
    return null;
  }

  @Override
  public Color getCurrentColor() {
    //TODO: Implement later
    return null;
  }

  @Override
  public List<AnimationOperations> getAnimations() {
    return animationList;
  }

  @Override
  public void setAnimation(int startTick, int endTick, int startX, int endX, int startY, int endY,
      int startWidth, int endWidth, int startHeight, int endHeight, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue) {
    if(startTick > endTick || startX < 0 || endX < 0 || startY < 0 || endY < 0 || startWidth < 0 ||
        endWidth < 0 || startHeight < 0 || endHeight < 0 || !isValidColor(startRed) ||
        !isValidColor(endRed) || !isValidColor(startGreen) || !isValidColor(endGreen) ||
        !isValidColor(startBlue) || !isValidColor(endBlue)) {
      throw new IllegalArgumentException("Invalid parameters");
    }

    AnimationModel a = new AnimationModel(startTick, endTick, startX, endX, startY, endY,
        startWidth, endWidth,
        startHeight, endHeight, startRed, endRed, startGreen, endGreen, startBlue, endBlue);
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
  private boolean isValidColor(int color) {
    return color >= 0 && color < 256;
  }
}
