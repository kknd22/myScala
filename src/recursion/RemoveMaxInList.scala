package recursion

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/9/13
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
class RemoveMaxInList {
  def removeMax(list: List[Int]):List[Int] = {
    @tailrec
    def doRemoveMax(list: List[Int], acc: List[Int]): List[Int] = list match {
      case Nil => Nil
      case x :: Nil => println("^^^^^ " + x); acc
      case x :: y :: rest =>

        if (x < y) {
          println("---> " + x)
          doRemoveMax(y :: rest, x :: acc)
        }
        else {
          println("--->> " + y)
          doRemoveMax(x :: rest, y :: acc)
        }
    }

    doRemoveMax(list, List.empty)
  }

}


object TestRemoveMax extends App {

  val list = List(1, 2, 3, 9, 4, 5, 6, 7)
  val rMax = new RemoveMaxInList()
  val xs = rMax.removeMax(list)

  println(xs.mkString(", "))

}