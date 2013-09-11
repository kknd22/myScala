package quicksort

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/9/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
class QuickSort {

  def quickSort(list:  Array[Int]) {
    def swap(i:Int, j:Int, list: Array[Int]) {
      val x = list(i)
      list(i)=list(j)
      list(j)=x
    }

    //@tailrec
    def doQuickSort(left: Int, right: Int, list: Array[Int]) {
      println("#################left: " + left + ", right: " + right)
      if (right-left <= 1) {println ("list size is: " + (right-left)); return}


      val mid = (right + left) /2
      val pivot = list(mid)
      println("pivot is: " + pivot)
      var i = left
      var j = right

      while (i < j) {
        while (list(i) < pivot) i += 1
        while (list(j) > pivot) {
          j -= 1
        }
        if (i<=j) {

          println("---> swapping: %d and %d. List is: %s".format(list(i), list(j), list.mkString(", ")))
/*
          if (list(i) == list(j)) {
            println ("list(i) == %s".format(list (i)))
            throw new RuntimeException("HERE!!!!")
          }
*/
          swap(i, j, list)
          i += 1
          j -= 1
        }
      }

      doQuickSort(left, i-1, list)
      doQuickSort(i, right, list)
    }

    doQuickSort(0, list.size-1, list)
  }

}

object TestQSort extends App {
   var list = Array( 22 ,20, 21, 10, 3, 8, 2, 1, 9, 5, 6)
   val qs = new QuickSort()
   qs.quickSort(list)
   println("finally: " + list.mkString(", "))
}