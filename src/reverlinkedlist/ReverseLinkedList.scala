package reverlinkedlist

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/11/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */

abstract class AbstractLinkedList() {}
case class LinkedList(val head:Int, val tail:LinkedList) {

  override def toString():String = {
    var h = this.head
    var t = this.tail
    val b = StringBuilder.newBuilder
    b.append(h).append(", ")
    while (t != null) {
      h=t.head
      b.append(h).append(", ")
      t=t.tail
    }
    b.toString()
  }
}

class ReverseLinkedList {
  def reverse(xs: LinkedList): LinkedList = {
    def doReverse(xs: LinkedList, acc: LinkedList): LinkedList= {
      if (xs.tail == null) return LinkedList(xs.head, acc)
      return doReverse(xs.tail, LinkedList(xs.head, acc))
    }
    doReverse(xs, null)
  }

}

object TestLinkedListReverse extends App {
  val xs = LinkedList(1, LinkedList(2, LinkedList(3, LinkedList(4, null))))

  println("original: " + xs)

  val rl = new ReverseLinkedList
  val ys = rl.reverse(xs)

  println("reversed: " + ys)

}
