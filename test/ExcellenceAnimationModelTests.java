import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import cs3500.excellence.model.ExcellenceAnimation.ExcellenceAnimationModel;
import cs3500.excellence.model.ShapeAnimation.Shape.shapeType;
import cs3500.excellence.model.ShapeAnimation.ShapeAnimationModel;
import cs3500.excellence.model.ShapeAnimation.ShapeAnimationOperations;
import org.junit.Test;

public class ExcellenceAnimationModelTests {


  @Test(expected = IllegalArgumentException.class)
  public void testSetShapeAnimationObjectIdExists() {
    ExcellenceAnimationModel e = new ExcellenceAnimationModel();
    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    ShapeAnimationModel s2 = new ShapeAnimationModel("R", shapeType.OVAL);
    e.addShapeAnimation(s1);
    e.addShapeAnimation(s2);
  }

  @Test
  public void testSetGetShapeAnimation() {
    ExcellenceAnimationModel e = new ExcellenceAnimationModel();
    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    e.addShapeAnimation(s1);
    assertTrue(e.getShapeAnimations().contains(s1));
  }

  @Test
  public void testGetEmptyShapeAnimationList() {
    ExcellenceAnimationModel e = new ExcellenceAnimationModel();
    assertTrue(e.getShapeAnimations().isEmpty());
  }

  @Test
  public void testToStringNoAnimations() {
    ExcellenceAnimationModel e = new ExcellenceAnimationModel();
    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    ShapeAnimationModel s2 = new ShapeAnimationModel("O", shapeType.OVAL);
    e.addShapeAnimation(s1);
    e.addShapeAnimation(s2);
    assertEquals("Shape R Rectangle\n"
        + "\n"
        + "Shape O Oval\n"
        + "\n", e.toString());
  }

  @Test
  public void testToStringWithAnimations() {
    ExcellenceAnimationModel e = new ExcellenceAnimationModel();
    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s1.addAnimation(1, 10, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s1.addAnimation(10, 12, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    ShapeAnimationModel s2 = new ShapeAnimationModel("O", shapeType.OVAL);
    s2.addAnimation(1, 5, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s2.addAnimation(5, 10, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s2.addAnimation(10, 11, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    e.addShapeAnimation(s1);
    e.addShapeAnimation(s2);
    assertEquals("Shape R Rectangle\n"
        + "motion R 1 0 0 0 0 0 0 0   10 1 1 1 1 1 1 1\n"
        + "motion R 10 0 0 0 0 0 0 0   12 1 1 1 1 1 1 1\n"
        + "\n"
        + "Shape O Oval\n"
        + "motion O 1 0 0 0 0 0 0 0   5 1 1 1 1 1 1 1\n"
        + "motion O 5 0 0 0 0 0 0 0   10 1 1 1 1 1 1 1\n"
        + "motion O 10 0 0 0 0 0 0 0   11 1 1 1 1 1 1 1\n"
        + "\n", e.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetShapeWithObjectIdDNE() {
    ExcellenceAnimationModel e = new ExcellenceAnimationModel();
    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    e.addShapeAnimation(s1);
    e.getShapeWithObjectId("NOT REAL ID");
  }

  @Test
  public void testGetShapeWithObjectIdSuccess() {
    ExcellenceAnimationModel e = new ExcellenceAnimationModel();
    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    e.addShapeAnimation(s1);
    ShapeAnimationOperations s2 = e.getShapeWithObjectId("R");
    assertEquals(s1, s2);
  }

  @Test
  public void testEquals() {
    ExcellenceAnimationModel e = new ExcellenceAnimationModel();
    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s1.addAnimation(1, 10, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s1.addAnimation(10, 12, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    ShapeAnimationModel s2 = new ShapeAnimationModel("O", shapeType.OVAL);
    s2.addAnimation(1, 5, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s2.addAnimation(5, 10, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s2.addAnimation(10, 11, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    e.addShapeAnimation(s1);
    e.addShapeAnimation(s2);

    ExcellenceAnimationModel e1 = new ExcellenceAnimationModel();
    e1.addShapeAnimation(s1);
    e1.addShapeAnimation(s2);

    assertEquals(e, e1);
  }

  @Test
  public void testNotEquals() {
    ExcellenceAnimationModel e = new ExcellenceAnimationModel();
    ShapeAnimationModel s1 = new ShapeAnimationModel("R", shapeType.RECTANGLE);
    s1.addAnimation(1, 10, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s1.addAnimation(10, 12, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    ShapeAnimationModel s2 = new ShapeAnimationModel("O", shapeType.OVAL);
    s2.addAnimation(1, 5, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s2.addAnimation(5, 10, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    s2.addAnimation(10, 11, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    e.addShapeAnimation(s1);
    e.addShapeAnimation(s2);

    ExcellenceAnimationModel e1 = new ExcellenceAnimationModel();
    ShapeAnimationModel s3 = new ShapeAnimationModel("L", shapeType.RECTANGLE);
    s3.addAnimation(1, 10, 0, 1, 0, 1, 0, 1,
        0, 1, 0, 1, 0, 1, 0,
        1);
    e1.addShapeAnimation(s1);
    e1.addShapeAnimation(s3);
    assertNotEquals(e, e1);
  }
}
