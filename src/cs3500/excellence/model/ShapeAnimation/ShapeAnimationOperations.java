package cs3500.excellence.model.ShapeAnimation;

import cs3500.excellence.model.Animation.AnimationOperations;
import cs3500.excellence.model.AnimationState;
import java.util.List;

public interface ShapeAnimationOperations {

  List<AnimationOperations> getAnimations();

  void setAnimation(int startTick, int endTick, int startX, int endX, int startY,
      int endY, int startWidth, int endWidth, int startHeight, int endHeight, int startRed,
      int endRed, int startGreen, int endGreen, int startBlue, int endBlue);

  String getObjectId();

}
