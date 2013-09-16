package quicksort

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/9/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
class QuickSortMe {

  //@tailrec
  def quickSort(list:  List[Int]): List[Int]= {
    @tailrec
    def partition(left:List[Int], p: Int, right: List[Int], list: List[Int]):(List[Int], Int, List[Int]) = {
      list match {
        case Nil => (left, p, right)
        case x::ys => if (x < p) partition(x::left, p, right, ys) else partition(left, p, x::right, ys)
      }
    }

    if (list.isEmpty) return list

    val (l, p, r) = partition(Nil, list.head, Nil, list.tail)
    //List.concat(quickSort(l), list.head::Nil, quickSort(r))
    List.concat(quickSort(l), p::Nil, quickSort(r))
  }

}

object TestQSortMe extends App {
   val list = List( 13 ,20, 21, 10, 3, 8, 2, 1, 9, 5, 6)
   val qs = new QuickSortMe()
   val result = qs.quickSort(list)
   println("finally: " + result.mkString(", "))
}