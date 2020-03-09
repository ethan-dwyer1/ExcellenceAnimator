package cs3500.excellence.model.Animation;

public class AnimationModel implements AnimationOperations {

  private final int startTick;
  private final int endTick;

  private final int startX;
  private final int endX;
  private final int startY;
  private final int endY;

  private final int startWidth;
  private final int endWidth;
  private final int startHeight;
  private final int endHeight;

  private final int startRed;
  private final int endRed;
  private final int startGreen;
  private final int endGreen;
  private final int startBlue;
  private final int endBlue;

  public int getEndTick() {
    return endTick;
  }

  public int getStartX() {
    return startX;
  }

  public int getEndX() {
    return endX;
  }

  public int getStartY() {
    return startY;
  }

  public int getEndY() {
    return endY;
  }

  public int getStartWidth() {
    return startWidth;
  }

  public int getEndWidth() {
    return endWidth;
  }

  public int getStartHeight() {
    return startHeight;
  }

  public int getEndHeight() {
    return endHeight;
  }

  public int getStartRed() {
    return startRed;
  }

  public int getEndRed() {
    return endRed;
  }

  public int getStartGreen() {
    return startGreen;
  }

  public int getEndGreen() {
    return endGreen;
  }

  public int getStartBlue() {
    return startBlue;
  }

  public int getEndBlue() {
    return endBlue;
  }

  /**
   *
   * @param startTick
   * @param endTick
   * @param startX
   * @param endX
   * @param startY
   * @param endY
   * @param startWidth
   * @param endWidth
   * @param startHeight
   * @param endHeight
   * @param startRed
   * @param endRed
   * @param startGreen
   * @param endGreen
   * @param startBlue
   * @param endBlue
   */
  public AnimationModel(int startTick, int endTick, int startX, int endX, int startY,
      int endY, int startWidth, int endWidth, int startHeight, int endHeight, int startRed,
      int endRed, int startGreen, int endGreen, int startBlue, int endBlue) {

    this.startTick = startTick;
    this.endTick = endTick;
    this.startX = startX;
    this.endX = endX;
    this.startY = startY;
    this.endY = endY;
    this.startWidth = startWidth;
    this.endWidth = endWidth;
    this.startHeight = startHeight;
    this.endHeight = endHeight;
    this.startRed = startRed;
    this.endRed = endRed;
    this.startGreen = startGreen;
    this.endGreen = endGreen;
    this.startBlue = startBlue;
    this.endBlue = endBlue;
  }

  @Override
  public String printAnimation() {
    String animation = "";
    return  startTick + " " + startX + " " + startY
        + " " + startWidth + " " + startHeight + " " + startRed + " " + startGreen + " "
        + startBlue + "   " +  endTick + " " + endX + " " + endY + " " + endWidth + " "
        + endHeight + " " + endRed + " " + endGreen + " " + endBlue + "\n";
  }

  @Override
  public void setAnimation(int startTick, int startX, int startY, int startWidth, int startHeight,
      int startRed, int startGreen, int startBlue, int endTick, int endX, int endY, int endWidth,
      int endHeight, int endRed, int endGreen, int endBlue) {
    //get shape with objectID from ShapeAnimation and add this animation to the list
  }

}
