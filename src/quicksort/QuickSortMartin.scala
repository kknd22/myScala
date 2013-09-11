package quicksort

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/9/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
class QuickSortMartin {
  def sort(xs: Array[Int]) {
    def swap(i: Int, j: Int) {
      val t = xs(i)
      xs(i) = xs(j)
      xs(j) = t
    }
    //@tailrec
    def sort1(l: Int, r: Int) {
      val pivot = xs((l + r) / 2)
      var i = l
      var j = r
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)
    }
    sort1(0, xs.length - 1)
  }

}

object TestQSortMartin extends App {
   var list = Array( 22 ,20, 21, 10, 3, 8, 2, 1, 9, 5, 6)
   val qs = new QuickSortMartin()
   qs.sort(list)
   println("finally: " + list.mkString(", "))
}


