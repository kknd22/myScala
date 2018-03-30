package recursion

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 9/5/13
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
object Fibonacci {
  def main(args: Array[String]): Unit = {
    println(fib(6))
  }

  import scala.annotation.tailrec


  def fib(n: Int) = {
    @tailrec
    def fib_tr(n: Int, b: Int, a: Int): Int = n match {

      case 0 => a
      case _ => fib_tr(n - 1, a + b, b)
    }
    fib_tr(n, 1, 0)
  }

  /*

      private def fibonacci(n:Int):Int={

        @tailrec
        def fibonacciTCO(n:Int,accu:Int):Int={
          if(n==1) return 0
          else if(n==2) return 1
          else if(n==3) return 1
          fibonacciTCO(n-1,n+accu)
        }

        fibonacciTCO(n,0)
      }

  */
  

/***************************************************************
private def fibonacci(n:Int):Int={
  
  @scala.annotation.tailrec
  def fibonacciTCO(n:Int,accu:Int):Int= n match {
      case 1 => return 0
      case 2 => return 1
      case 3 => return 1
      case _ => fibonacciTCO(n-1,n+accu)
  }
  fibonacciTCO(n,0)
}

*/
}
