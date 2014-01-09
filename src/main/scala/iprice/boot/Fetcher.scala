package iprice.boot

import fetcher.{DBAParser, DBAFetcher}
import com.typesafe.scalalogging.slf4j.Logging

object Fetcher extends App with Logging {

  logger.info("Starting fetcher...")
  val fetcher = new DBAFetcher()
  val parser = new DBAParser(fetcher request)
  val totalPages = parser getTotalPages

  logger.debug("Initial values set. Start collecting ads.")

  val allAds = for (page <- 1 to totalPages)
  yield {
    logger.debug("Getting page " + page + " of " + totalPages + "...")
    fetcher setPage (page)
    parser setRawInput (fetcher request)
    parser getAds
  }

  logger.debug("Done fetching pages...")
}

