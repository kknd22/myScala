package quicksort

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/13/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
object SpiewakQuickSort extends App{

  def qsort[A : Ordering](ls: List[A]) = {
    import Ordered._

    def sort(ls: List[A])(parent: List[A]): List[A] = {
      if (ls.size <= 1) ls ::: parent else {
        val pivot = ls.head

/*
        val (less, equal, greater) = ls.foldLeft(List[A](), List[A](), List[A]()) {
          case ((less, equal, greater), e) => {
            if (e < pivot)
              (e :: less, equal, greater)
            else if (e == pivot)
              (less, e :: equal, greater)
            else
              (less, equal, e :: greater)
          }
        }
*/
        val z = (List[A](), List[A](), List[A]())

        val r = ls.foldLeft(List[A](), List[A](), List[A]()) {
          (z, e) => {
            if (e < pivot)
              (e :: z._1, z._2, z._3)
            else if (e == pivot)
              (z._1, e :: z._2, z._3)
            else
              (z._1, z._2, e :: z._3)
          }
        }

        sort(r._1)(r._2 ::: sort(r._3)(parent))
      }
    }
    sort(ls)(Nil)
  }

  val list = List( 13 ,20, 21, 10, 3, 8, 2, 1, 9, 5, 6)
     val result = qsort(list)
     println("finally: " + result.mkString(", "))
}
