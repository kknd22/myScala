package parser

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 6/21/13
 * Time: 9:36 AM
 * To change this template use File | Settings | File Templates.
 */

import scala.util.parsing.combinator._

class Arith extends JavaTokenParsers {
  def expr: Parser[Any] = term ~ rep("+" ~ term | "-" ~ term)

  def term: Parser[Any] = factor ~ rep("*" ~ factor | "/" ~ factor)

  def factor: Parser[Any] = floatingPointNumber | "(" ~ expr ~ ")"
}


