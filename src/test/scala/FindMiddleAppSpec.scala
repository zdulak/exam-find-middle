import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks._

class FindMiddleAppSpec extends AnyFlatSpec with should.Matchers {
  behavior of "FindMiddleApp"
  it should "return middle element for the given lists" in {
    val args = Table(
      ("arg", "result"),
      (List.empty[Int], None),
      (List(1), Some(1)),
      (List(1, 2), Some(1)),
      (List(1, 2, 3), Some(2)),
      (List(1, 2, 3, 4), Some(2)),
      (List(1, 2, 3, 4, 5), Some(3)),
      (List(1, 2, 3, 4, 5, 6), Some(3))
    )

    forAll(args) {
      (arg, result) => FindMiddleApp.findMiddleElement(arg) shouldBe result
    }
  }
}
