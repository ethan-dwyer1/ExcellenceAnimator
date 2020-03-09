package cs3500.excellence.model.Animation;


/**
 *
 */
public interface AnimationOperations {

  /**
   *
   * @return
   */
  String printAnimation();

  /**
   *
   * @param startTick
   * @param startX
   * @param startY
   * @param startWidth
   * @param startHeight
   * @param startRed
   * @param startGreen
   * @param startBlue
   * @param endTick
   * @param endX
   * @param endY
   * @param endWidth
   * @param endHeight
   * @param endRed
   * @param endGreen
   * @param endBlue
   */
  void setAnimation(int startTick, int startX, int startY, int startWidth, int startHeight, int startRed,
      int startGreen, int startBlue, int endTick, int endX, int endY, int endWidth, int endHeight,
      int endRed, int endGreen, int endBlue);


}
