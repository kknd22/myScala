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

        sort(less)(equal ::: sort(greater)(parent))
      }
    }
    sort(ls)(Nil)
  }

  val list = List( 13 ,20, 21, 10, 3, 8, 2, 1, 9, 5, 6)
     val result = qsort(list)
     println("finally: " + result.mkString(", "))
}
