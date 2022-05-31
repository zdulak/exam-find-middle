import scala.annotation.tailrec

object FindMiddleApp extends App {
  println(findMiddleElement(List.empty[Int])) // None
  println(findMiddleElement(List(1))) // 1
  println(findMiddleElement(List(1,2))) // 1
  println(findMiddleElement(List(1,2,3))) // 2
  println(findMiddleElement(List(1,2,3,4))) // 2
  println(findMiddleElement(List(1,2,3,4,5))) // 3
  println(findMiddleElement(List(1,2,3,4,5,6))) // 3

  def findMiddleElement[T](xs: List[T]): Option[T] = {
    @tailrec
    def loop(ys: List[T], acc: List[T], cnt: Int): Option[T] = {
      ys match {
        case head :: tail if tail == Nil => Some(head)
        case head :: tail if tail.tail == Nil => acc.headOption
        case head :: tail if cnt % 2 == 0 => loop(tail, acc.tail, cnt + 1)
        case _ :: tail => loop(tail, acc, cnt + 1)
        case Nil => acc.headOption
      }
    }

    loop(xs, xs, 0)
  }
}
