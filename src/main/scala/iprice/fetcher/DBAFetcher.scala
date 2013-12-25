package fetcher

import spray.http.Uri
import iprice.Config
import java.net.URL

/**
 * Companion object holding constants and defining general methods.
 */
object DBAFetcher {
  val KeyPage = "pn"

  /**
   *
   * @param map1
   * @param map2
   * @return
   */
  def mergeParams(map1: Map[String, Any], map2: Map[String, Any]) = {
    map1.map {
      case (k, v) => k -> ("" + v)
    } ++ map2.map {
      case (k, v) => k -> ("" + v)
    }
  }
}

/**
 *
 * @param page
 * @param additionalParams
 */
class DBAFetcher(private var page: Int = 1, additionalParams: Map[String, Any] = Map()) {

  val headers = Map(
      "X-Dba-AppVersion" -> "2.2",
      //"Accept-Encoding" -> "gzip,deflate", // don't encode response on second request
      "Accept" -> "application/json",
      "dbaapikey" -> Config.DBA.apikey,
      "Accept-Language" -> "da-dk",
      "Cache-Control" -> "no-cache"
  )

  def request = {
    val connection = new URL(url toString).openConnection
    headers.foreach({
      case (name, value) => connection.setRequestProperty(name, value)
    })
    scala.io.Source.fromInputStream(connection.getInputStream).getLines.mkString("\n")
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
    DBAFetcher.mergeParams(defaultParams, additionalParams)
  }

  def url = Uri("http://api.dba.dk/api/v2/ads/cassearch") withQuery params
}
