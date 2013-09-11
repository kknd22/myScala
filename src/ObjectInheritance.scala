/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 4/10/13
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */

abstract class UndoableAction(val description: String) {
  def undo(): Unit

  def redo(): Unit
}

object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo() {}

  override def redo() {}
}
