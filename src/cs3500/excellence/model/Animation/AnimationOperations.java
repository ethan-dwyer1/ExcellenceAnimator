package cs3500.excellence.model.Animation;


/**
 *
 */
public interface AnimationOperations {

  /**
   * Returns the objectId for the animation.
   *
   * @return objectId string.
   */
  String getObjectId();

  /**
   * Returns the start tick for the animation.
   *
   * @return startTick.
   */
  int getStartTick();

  /**
   * Returns the end tick for the animation.
   *
   * @return endTick.
   */
  int getEndTick();
}
