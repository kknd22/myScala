package mergesort

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/10/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
class MergsortTailRec {

  def mergeSort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      //@tailrec
      def merge(xs: List[Int], ys: List[Int], accu: List[Int]): List[Int] =
        (xs, ys) match {
          case (Nil, Nil) => {
            println("0 accu: " + accu.mkString(", ") + " -id: " + System.identityHashCode(accu))
            accu.reverse
          }
          case (Nil, y :: ys1) =>
            println("1 accu: " + accu.mkString(", ")+ " -id: " + System.identityHashCode(accu))
            val res = merge(xs, ys1, y :: accu)
            res
          case (x :: xs1, Nil) =>
            println("2 accu: " + accu.mkString(", ")+ " -id: " + System.identityHashCode(accu))
            val res = merge(xs1, ys, x :: accu)
            res
          case (x :: xs1, y :: ys1) =>
            if (x < y) {
              println("3 accu: " + accu.mkString(", ")+ " -id: " + System.identityHashCode(accu))
              val res = merge(xs1, ys, x :: accu)
              res
            }
            else {
              println("4 accu: " + accu.mkString(", ")+ " -id: " + System.identityHashCode(accu))
              val res =merge(xs, ys1, y :: accu)
              res
            }
        }
      val (left, right) = xs splitAt (n)

      merge(mergeSort(left), mergeSort(right), List.empty )
    }
  }

}

object TestMergTailRecSort extends App {

  val xs = List(22 ,20, 21, 10, 3, 8, 2, 1, 9, 5, 6)
     val ms = new MergsortTailRec()
     val result = ms.mergeSort(xs)
     println("finally: " + result.mkString(", "))
}
