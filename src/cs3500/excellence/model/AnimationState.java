package cs3500.excellence.model;

import java.awt.Color;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

/**
 *
 */
public interface AnimationState {

  /**
   *
   * @return
   */
  Point2D getCurrentPosition();

  /**
   *
   * @return
   */
  Dimension2D getCurrentDimensions();

  /**
   *
   * @return
   */
  Color getCurrentColor();


}
