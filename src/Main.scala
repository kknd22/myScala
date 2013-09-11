/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 4/10/13
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
object Hello extends App {
  if (args.length > 0)
    println("Hello, " + args(0))
  else
    println("Hello, World!")
}


object TrafficLightColor extends Enumeration {
  val Red, Yellow, Green = Value
}