package regex

import scala.util.matching.Regex
import org.scalatest.FunSuite
import regex.EA06Regex._

class RegexTestSuite extends FunSuite {

    def testRegex(reg: Regex, cases: List[(String, Boolean)]): Unit = {
        def runTest(reg: Regex, str: String): Boolean = {
            (reg findFirstIn str).isDefined
        }

        for ((n,r) <- cases) {
            expect(r, s"$n ${if (r) "should be" else "is not"} valid!")(runTest(reg, n))
        }
    }

    test("Phone number validation") {
        val cases = List(
            ("123-454-3210", true),
            ("321.987.5050", true),
            ("321^555v0010", false),
            ("1.2.3", false),
            ("are.you.here", false)
        )
        testRegex(phone, cases)
    }

    test("Email validation") {
        val emails = List(
            ("jane@gmail.com", true),
            ("w@@google.com", true),
            ("where.you@man.???", false),
            ("nope", false)
        )
        testRegex(email, emails)
    }

    test("Advanced Email validation") {
        val emails = List(
            ("jane@gmail.com", true),
            ("w@@google.com", false),
            ("where.you@man.???", false),
            ("nope", false)
        )
        testRegex(advEmail, emails)
    }

    test("Date validation") {
        val dates = List(
            ("12/34/5678", true),
            ("00/00/0000", true),
            ("1/2/33", false)
        )
        testRegex(date, dates)
    }

    test("Advanded Date validation") {
        val dates = List(
            ("31/01/2002", true),
            ("01/01/0001", true),
            ("12/12/1212", true),
            ("12/34/5678", false),
            ("00/00/0000", false),
            ("1/2/33", false)
        )
        testRegex(advDate, dates)
    }

    test("Name validation") {
        val names = List(
            ("Mrs. Martha Badname-Crumblesby", true),
            ("Dr. Juan C. Upona-Thyme", true),
            ("Michael F. Cordlessphone II", true),
            ("Mrs. Dr. Hapsburg von Middelschnitz", false),
            ("Bartholemew LM N'oppee", false),
            ("L33ts0n McH4cK4r", false)
        )

        testRegex(name, names)
    }
}
