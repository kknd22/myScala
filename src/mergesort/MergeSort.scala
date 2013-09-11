package mergesort

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/10/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */
class MergeSort[T <% Ordered[T]] {
  def mSort (xs: List[T]): List[T] = {
    def merge (left: List[T], right: List[T]): List[T]= (left, right) match {
      case (xs, Nil) =>
        return xs
      case (Nil, ys) =>
        return ys
      case (x::xs, y::ys) =>
        if (x < y)
          return x::merge(xs, right)
        else
          return y::merge(left, ys)

      }

    if (xs.size <2 ) return xs

    val (left, right) = xs.splitAt(xs.size/2)
    merge (mSort(left), mSort(right))
  }
}

object TestMergSort extends App {
  val xs = List(22 ,20, 21, 10, 3, 8, 2, 1, 9, 5, 6)
     val ms = new MergeSort[Int]()
     val result = ms.mSort(xs)
     println("finally: " + result.mkString(", "))
}
