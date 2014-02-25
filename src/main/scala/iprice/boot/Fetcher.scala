package iprice.boot

import iprice.dba.{DBAParser, DBAFetcher}
import com.typesafe.scalalogging.log4j.Logging
import iprice.models.Ad
import iprice.dba.DBACalc

object Fetcher extends App with Logging {

  logger.debug("Starting fetcher...")

  val fetcher = new DBAFetcher()
  val parser = new DBAParser(fetcher request)
  val totalPages = parser getTotalPages

  logger.debug("Initial values set. Start collecting ads.")

  def addAds(list: List[Ad], page: Int): List[Ad] = {
    if (page <= totalPages) {
      logger.debug("Getting page " + page + " of " + totalPages + "...")
      fetcher setPage (page)
      parser setRawInput (fetcher request)
      addAds((parser getAds) ++ list, page+1)
    } else
      list
  }

  val allAds = addAds(List[Ad](), 1)

  val calc = new DBACalc(allAds)



  logger.debug("Done fetching pages...\nStarting calculations...")
}

