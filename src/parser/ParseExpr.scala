package parser

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 6/21/13
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
object ParseExpr extends Arith {
  def main(args: Array[String]) {
    println("input : " + args(0))
    println(parseAll(expr, args(0)))
  }
}
