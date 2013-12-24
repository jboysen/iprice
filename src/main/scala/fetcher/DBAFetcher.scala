package fetcher

import spray.http.Uri

object DBAFetcher {
  val KeyPage = "pn"
}
class DBAFetcher(private var page: Int = 1, additionalParams: Map[String, Any] = Map()) {

  def request {

  }

  def setPage(p: Int) {
    page = p
  }

  def params = {
    val defaultParams = Map(
      "cla" -> 27160,
      "at" -> 2,
      "pe" -> 0,
      "ps" -> 100,
      DBAFetcher.KeyPage -> page,
      "f" -> "json",
      "filters" -> 1
    )
    mergeParams(defaultParams, additionalParams)
  }

  def url = Uri("http://api.dba.dk/api/v2/ads/cassearch") withQuery params

  def mergeParams(map1: Map[String, Any], map2: Map[String, Any]) = {
    map1.map {
      case (k, v) => k -> ("" + v)
    } ++ map2.map {
      case (k, v) => k -> ("" + v)
    }
  }
}
