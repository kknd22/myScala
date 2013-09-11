package whyitismainapp

/**
 * Created with IntelliJ IDEA.
 * User: u1cc32
 * Date: 7/2/13
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
   trait Helper extends DelayedInit {
     def delayedInit(body: => Unit) = {
       println("dummy text, printed before initialization of C")
       body // evaluates the initialization code of C
     }
   }

   class C extends Helper {
     println("this is the initialization code of C")
   }

   object Test extends App {
     val c = new C
   }
