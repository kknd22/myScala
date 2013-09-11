package eightqueens

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 6/11/13
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
class EightQueens {
  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] = {
      if (k == 0)
        List(List())
      else {
        val temp =
        for {
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens
        println(temp.length)
        temp foreach (Predef println _  )
          //(x=> println(x.mkString("{", ", ", "}")) )
        temp
      }
    }
    placeQueens(n)
  }


  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
//    queens forall (q => !inCheck(queen, q))
      queens forall (!inCheck(queen, _))

  def inCheck(q1: (Int, Int), q2: (Int, Int)) =
    q1._1 == q2._1 || // same row
      q1._2 == q2._2 || // same column
      (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // on diagonal
}

object Driver extends App {
  val e = new EightQueens()
  e.queens(5)
  Iterable
}
