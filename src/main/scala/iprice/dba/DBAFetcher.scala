package fetcher

import spray.http.Uri
import java.net.URL
import java.util.zip.GZIPInputStream
import iprice.config.Configuration

/**
 * Companion object holding constants and defining general methods.
 */
object DBAFetcher {
  val ApiKeyPage = "pn"
  val ApiUrl = "http://api.dba.dk/api/v2/ads/cassearch"

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
class DBAFetcher(private var page: Int = 1, additionalParams: Map[String, Any] = Map()) extends Configuration {
  val headers = Map(
    "X-Dba-AppVersion" -> "2.2",
    "Accept-Encoding" -> "gzip,deflate",
    "Accept" -> "application/json",
    "dbaapikey" -> Config.DBA.apiKey,
    "Accept-Language" -> "da-dk",
    "Cache-Control" -> "no-cache"
  )

  def request = {
    val connection = new URL(url toString).openConnection
    headers.foreach({
      case (name, value) => connection.setRequestProperty(name, value)
    })
    val stream =
      if (connection.getHeaderField("Content-Encoding") == "gzip")
        new GZIPInputStream(connection.getInputStream)
      else
        connection.getInputStream
    scala.io.Source.fromInputStream(stream).getLines.mkString("\n")
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
      DBAFetcher.ApiKeyPage -> page,
      "f" -> "json",
      "filters" -> 1
    )
    DBAFetcher.mergeParams(defaultParams, additionalParams)
  }

  def url = Uri(DBAFetcher.ApiUrl) withQuery params
}
