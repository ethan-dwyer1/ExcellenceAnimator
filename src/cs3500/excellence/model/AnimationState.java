package cs3500.excellence.model;

import java.awt.Color;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

/**
 * Interface representing the state of a given animation.  Describes the position, dimensions, and
 * color of an animation.
 */
public interface AnimationState {

  /**
   * Returns the current position of a shape.
   *
   * @return 2D point for current position of a shape.
   */
  Point2D getCurrentPosition();

  /**
   * Returns the current dimensions of a shape undergoing animation.
   *
   * @return current 2D dimensions of a shape.
   */
  Dimension2D getCurrentDimensions();

  /**
   * Return current color of a shape.
   *
   * @return current color of a shape.
   */
  Color getCurrentColor();


}
