package fetcher

import org.json4s.native.JsonMethods
import org.json4s.DefaultFormats
import org.json4s.JsonAST.JNothing

object DBAParser {
  object Keys {
    val Info = "info"
    val Pages = "pages"
  }
}

class DBAParser(private var rawInput: String = "") {

  implicit val formats = DefaultFormats

  def parse = JsonMethods.parse(rawInput)

  def setRawInput(i: String) {
    rawInput = i
  }

  def getTotalPages = {
    val pages = parse \ DBAParser.Keys.Info \ DBAParser.Keys.Pages
    if (pages == JNothing)
      sys.error("The entry " + DBAParser.Keys.Info + "." + DBAParser.Keys.Pages + " was not found in the given JSON object.")
    else pages.extract[Int]
  }

  def getAds = {

  }

}
