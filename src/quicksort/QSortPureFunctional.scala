package quicksort

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/9/13
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
class QSortPureFunctional {
  //@tailrec
  def qsort(list: Array[Int]): Array[Int] = {
    val size = list.size
    if (size == 0 || size == 1) return list

    val pivot = list((0 + list.size / 2))
    Array.concat(
      qsort(list filter (pivot > _)),
      list filter (pivot == _),
      qsort(list filter (pivot < _))
    )
  }

}

object TestQSortPureFunctional extends App {
   var list = Array( 22 ,20, 21, 10, 3, 8, 2, 1, 9, 5, 6)
   val qs = new QSortPureFunctional()
   qs.qsort(list)
   println("finally: " + list.mkString(", "))
}