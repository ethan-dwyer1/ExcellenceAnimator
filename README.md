# ExcellenceAnimator

## AnimationOperations.class
This interface defines the necessary actions for a single animation, such as getting the parameters related to its start and end time, position, color, and size
## AnimationModel.class
This class implements the AnimationOperations describes a simple animation which represents a change in color, size, or position of a shape over a given tick interval
## Shape
This class holds a positon, size, and color of a shape as well as the type of shape, currently defined as an enum. This will later be extended to implement polygons.
## ShapeAnimationOperations.class
This interface determines the operations a Shape animation should have, such as being able to move and get the position of the Shape's animation given a tick from a controller.
## ShapeAnimationModel.class
This class implements the ShapeAnimationOperations interface and includes fields to store multiple AnimationModels as well as a shape to determine what shape must be drawn
## ExcellenceAnimationOperations.class
This interface details the methods an Excellence Animation should have, such as adding ShapeAnimations as well as a method to update all of the Shapes in the ShapeAnimations to have the correct position.
## ExcellenceAnimationModel.class
This class implements the ExcellenceAnimationOperations interface and includes a list of ShapeAnimations that all create the full animation.
## AnimationModelTests.class
This class tests the AnimationModelTests class
## ShapeAnimationModeTests.class
This class tests the ShapeAnimationModeTests class
## ExcellenceAnimationModelTests.class
This class tests the ExcellenceAnimationModelTests class
