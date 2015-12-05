package regex

import scala.util.matching.Regex

object EA06Regex {
    val phone: Regex = """^[0-9]{3}[.|-][0-9]{3}[.|-][0-9]{4}$""".r

    val email: Regex = """^.+@.+\.[a-zA-Z0-9]{3}$""".r

    val advEmail: Regex = """^[^@]+@[^.|@]+\.[a-zA-Z0-9]{3}$""".r

    val date: Regex = """^[0-9]{2}/[0-9]{2}/[0-9]{4}$""".r

    val advDate: Regex = """^$""".r

    val name: Regex = """^$""".r
}