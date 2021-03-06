import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.excellence.model.animation.AnimationModel;
import org.junit.Test;

/**
 * A class to test the AnimationModel class.
 */
public class AnimationModelTests {

  @Test
  public void testToString() {
    AnimationModel a = new AnimationModel("R", 1, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);

    String match = "1 0 0 0 0 0 0 0   5 5 5 5 5 5 5 5\n";

    assertEquals(match, a.toString());
  }


  @Test(expected = IllegalArgumentException.class)
  public void testNegativeStartTick() {
    AnimationModel a = new AnimationModel("R", -1, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeEndTick() {
    AnimationModel a = new AnimationModel("R", 0, -1, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartTickGreaterThanEndTick() {
    AnimationModel a = new AnimationModel("R", 5, 0, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeStartWidth() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, -1, 5, 0, 5, 0,
        5, 0, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeEndWidth() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, 0, -1, 0, 5, 0,
        5, 0, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeStartHeight() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, 0, 5, -1, 5, 0,
        5, 0, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeEndHeight() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, 0, 5, 0, -1, 0,
        5, 0, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStartRed() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, 0, 5, 0, 5, -1,
        5, 0, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidEndRed() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        -1, 0, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStartGreen() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, -1, 5, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidEndGreen() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, -1, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStartBlue() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, -1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidEndBlue() {
    AnimationModel a = new AnimationModel("R", 0, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, -1);
  }

  @Test
  public void testGetObjectId() {
    AnimationModel a = new AnimationModel("R", 1, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);

    assertEquals("R", a.getObjectId());
  }

  @Test
  public void testGetStartTick() {
    AnimationModel a = new AnimationModel("R", 1, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);

    assertEquals(1, a.getStartTick());
  }

  @Test
  public void testGetEndTick() {
    AnimationModel a = new AnimationModel("R", 1, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);

    assertEquals(5, a.getEndTick());
  }

  @Test
  public void testEquals() {
    AnimationModel a = new AnimationModel("R", 1, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);

    AnimationModel a1 = new AnimationModel("R", 1, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);

    assertTrue(a.equals(a1));
  }

  @Test
  public void testDoesNotEqual() {
    AnimationModel a = new AnimationModel("R", 1, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);

    AnimationModel a1 = new AnimationModel("G", 1, 5, 0, 5,
        0, 5, 0, 5, 0, 5, 0,
        5, 0, 5, 0, 5);

    assertFalse(a.equals(a1));
  }
}
