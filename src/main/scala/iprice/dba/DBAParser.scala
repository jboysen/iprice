package fetcher

import org.json4s.native.JsonMethods
import org.json4s.DefaultFormats
import org.json4s.JsonAST._
import models.Ad
import org.json4s.JsonAST.JDouble
import org.json4s.JsonAST.JInt
import org.json4s.JsonAST.JArray

object DBAParser {

  object Keys {
    val Info = "info"
    val Pages = "pages"
    val Ads = "ads"
    val Filters = "filters"

    object Filter {
      val Name = "Name"
      val Kay = "Key"
    }

  }

  object Meta {
    val Model = "MODEL"
    val Memory = "MEMORY"
  }

}

class DBAParser(private var rawInput: String = "") {

  implicit val formats = DefaultFormats

  val filterMatrix = createFilterMatrix

  def createFilterMatrix = {
    //val rawFilters = parse \ DBAParser.Keys.Info \ DBAParser.Keys.Filters
    val defaultFilters = Map(
      "Mærke" -> DBAParser.Meta.Model,
      "Hukommelse (GB)" -> DBAParser.Meta.Memory
    )
    /*rawFilters.children.foreach(
      filter => println(filter \ DBAParser.Keys.Filter.Name)
    )*/
    defaultFilters
  }

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
    val info = parse \ DBAParser.Keys.Info
    val ads = parse \ DBAParser.Keys.Ads
    if (ads == JNothing || info == JNothing)
      sys.error("Some entries was not found in the given JSON object.")
    else for {
      JObject(ad) <- ads
      JField("ad-owner", JObject(adOwner)) <- ad
      JField("ad-ownertype", JInt(ownerType)) <- adOwner
      JField("matrixdata", JArray(matrixData)) <- ad
      JField("price", JDouble(price)) <- ad
      if ownerType == 1 && matrixData.size > 0
    } yield {
      val matrixList = for (JObject(entry) <- matrixData)
      yield {
        val label = entry(1)._2.extract[String]
        val value = entry(0)._2.extract[String]
        label -> value
      }
      Ad(price.toInt, matrixList.toMap)
    }

  }

}
