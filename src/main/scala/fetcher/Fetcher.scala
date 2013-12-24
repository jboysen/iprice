import fetcher.DBAFetcher

object Fetcher extends App {
  val fetcher = new DBAFetcher()
  fetcher request
}

