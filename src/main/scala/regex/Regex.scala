package regex

import scala.util.matching.Regex

object EA06Regex {
    val phone: Regex = """^[0-9]{3}[\.|\-][0-9]{3}[\.|\-][0-9]{4}$""".r

    val email: Regex = """^.+@.+\.[a-zA-Z0-9]{3}$""".r

    val advEmail: Regex = """^[^@]+@[^\.|^@]+\.[a-zA-Z0-9]{3}$""".r

    val date: Regex = """^[0-9]{2}/[0-9]{2}/[0-9]{4}$""".r

    val advDate: Regex = """^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{3}[1-9]$""".r

    val name: Regex = """^(Mr\. |Mrs\. |Dr\. |Hon\. |Prof\. )?[a-zA-Z]+ ([A-Z]\. )?[a-zA-Z]+(\-[a-zA-Z]+)?( Ph\.D| M\.D\.| Jr\.| II| III| IV)?$""".r
}