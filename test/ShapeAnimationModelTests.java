import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import cs3500.excellence.model.animation.AnimationModel;
import cs3500.excellence.model.animation.AnimationOperations;
import cs3500.excellence.model.shapeanimation.Shape.shapeType;
import cs3500.excellence.model.shapeanimation.ShapeAnimationModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * A class to test the ShapeAnimationModel class.
 */
public class ShapeAnimationModelTests {

  @Test(expected = IllegalArgumentException.class)
  public void testNullObjectId() {
    ShapeAnimationModel s = new ShapeAnimationModel(null, shapeType.RECTANGLE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullShape() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", null);
  }

  @Test
  public void testEmptyListCreated() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    assertTrue(s.getAnimations().isEmpty());
  }

  @Test (expected = IllegalStateException.class)
  public void testToStringEmptyAnimations() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    assertEquals("Shape R Rectangle\n\n", s.toString());
  }

  @Test
  public void testGetObjectId() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    assertEquals("R", s.getObjectId());
  }

  @Test
  public void testValidTicks() {
    try {
      ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
      s.addAnimation(1, 10, 0, 1, 0, 1, 0, 1,
          0, 1, 0, 1, 0, 1, 0,
          1);
      s.addAnimation(10, 15, 0, 1, 0, 1, 0, 1,
          0, 1, 0, 1, 0, 1, 0,
          1);
    } catch (Exception e) {
      fail();
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartTickInsideOtherInterval() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(0, 10, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(5, 15, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
  }

  @Test(expected = IllegalStateException.class)
  public void testEndTickInsideOtherInterval() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(5, 10, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(0, 7, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEqualIntervals() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(0, 1, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(0, 1, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartTickSameEndValid() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(0, 1, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(0, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
  }

  @Test(expected = IllegalStateException.class)
  public void testEndTickSameStartValid() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(0, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
  }

  @Test
  public void testToString() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(2, 3, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(3, 4, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    assertEquals("Shape R Rectangle\n"
        + "motion R 1 0 0 0 0 0 0 0   2 1 1 1 1 1 1 1\n"
        + "motion R 2 0 0 0 0 0 0 0   3 1 1 1 1 1 1 1\n"
        + "motion R 3 0 0 0 0 0 0 0   4 1 1 1 1 1 1 1\n"
        + "\n", s.toString());
  }

  @Test
  public void testGetAnimations() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(2, 3, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(3, 4, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);

    List<AnimationOperations> sList = new ArrayList<>();
    sList.add(new AnimationModel("R", 1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1));
    sList.add(new AnimationModel("R", 2, 3, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1));
    sList.add(new AnimationModel("R", 3, 4, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1));

    assertEquals(sList, s.getAnimations());
  }

  @Test
  public void testGetEmptyAnimations() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    assertTrue(s.getAnimations().isEmpty());
  }

  @Test
  public void testEquals() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(2, 3, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(3, 4, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);

    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s1.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s1.addAnimation(2, 3, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s1.addAnimation(3, 4, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);

    assertEquals(s, s1);
  }

  @Test
  public void testDoesNotEqual() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(2, 3, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(3, 4, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);

    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.OVAL);
    s1.addAnimation(1, 2, 0, 1, 1, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s1.addAnimation(2, 3, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s1.addAnimation(3, 4, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);

    assertNotEquals(s, s1);
  }

  //TODO: Do this test below
  @Test
  public void testMoveAtCurrentTick() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(2, 3, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s.addAnimation(3, 4, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
  }

  @Test(expected = IllegalStateException.class)
  public void testMoveAtCurrentTickIllegalState() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.moveAtCurrentTick(10);
  }

  @Test
  public void testGetCurrentPosition() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    assertEquals(new Point(0, 0), s.getCurrentPosition());
  }

  @Test (expected = IllegalStateException.class)
  public void testGetCurrentPositionIllegalState() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    assertEquals(new Point(0, 0), s.getCurrentPosition());
  }

  @Test
  public void testGetCurrentColor() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    assertEquals(new Color(0,0,0), s.getCurrentColor());
  }

  @Test (expected = IllegalStateException.class)
  public void testGetCurrentColorIllegalState() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    assertEquals(new Color(0,0,0), s.getCurrentColor());
  }

  @Test
  public void testGetCurrentDimension() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s.addAnimation(1, 2, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    assertEquals(new Dimension(0,0), s.getCurrentDimensions());
  }

  @Test (expected = IllegalStateException.class)
  public void testGetCurrentDimensionIllegalState() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    assertEquals(new Dimension(0,0), s.getCurrentDimensions());
  }

}
