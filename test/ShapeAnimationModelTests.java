import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs3500.excellence.model.Animation.AnimationModel;
import cs3500.excellence.model.Animation.AnimationOperations;
import cs3500.excellence.model.ShapeAnimation.Shape;
import cs3500.excellence.model.ShapeAnimation.ShapeAnimationModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ShapeAnimationModelTests {

  @Test(expected = IllegalArgumentException.class)
  public void testNullObjectId(){
    ShapeAnimationModel s = new ShapeAnimationModel(null, Shape.OVAL);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullShape() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", null);
  }

  @Test
  public void testEmptyListCreated() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", Shape.RECTANGLE);
    assertTrue(s.getAnimations().isEmpty());
  }

  @Test
  public void testToStringEmptyAnimations() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", Shape.RECTANGLE);
    assertEquals("Shape R Rectangle\n\n", s.toString());
  }

  @Test
  public void testGetObjectId() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", Shape.RECTANGLE);
    assertEquals("R", s.getObjectId());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartTickInsideOtherInterval() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", Shape.RECTANGLE);
    s.setAnimation(0,10,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
    s.setAnimation(5,15,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEndTickInsideOtherInterval() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", Shape.RECTANGLE);
    s.setAnimation(5,10,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
    s.setAnimation(0,7,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEqualIntervals() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", Shape.RECTANGLE);
    s.setAnimation(0,1,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
    s.setAnimation(0,1,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
  }
  @Test
  public void testToString() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", Shape.RECTANGLE);
    s.setAnimation(0,1,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
    s.setAnimation(1,2,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
    s.setAnimation(2,3,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
    assertEquals("Shape R Rectangle\n"
        + "motion R 0 0 0 0 0 0 0 0   1 1 1 1 1 1 1 1\n"
        + "motion R 1 0 0 0 0 0 0 0   2 1 1 1 1 1 1 1\n"
        + "motion R 2 0 0 0 0 0 0 0   3 1 1 1 1 1 1 1\n\n", s.toString());
  }

  @Test
  public void testGetAnimations(){
    ShapeAnimationModel s = new ShapeAnimationModel("R", Shape.RECTANGLE);
    s.setAnimation(0,1,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
    s.setAnimation(1,2,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);
    s.setAnimation(2,3,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1);

    List<AnimationOperations> sList = new ArrayList<>();
    sList.add(new AnimationModel("R", 0,1,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1));
    sList.add(new AnimationModel("R", 1,2,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1));
    sList.add(new AnimationModel("R", 2,3,0,1,0,1,0,1,
        0,1,0,1,0,1,0,
        1));

    assertEquals(sList, s.getAnimations());
  }

  @Test
  public void testGetEmptyAnimations() {
    ShapeAnimationModel s = new ShapeAnimationModel("R", Shape.RECTANGLE);
    assertTrue(s.getAnimations().isEmpty());
  }


}
