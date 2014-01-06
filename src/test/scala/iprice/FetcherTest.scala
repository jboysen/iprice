package iprice

import _root_.fetcher.DBAFetcher
import org.scalatest.FlatSpec

class FetcherMergeParamsTest extends FlatSpec {
  val map1 = Map(
    "key1" -> 1,
    "key2" -> "test"
  )
  val map2 = Map(
    "key1" -> 2,
    "key3" -> 100
  )
  val resultMap = DBAFetcher.mergeParams(map1, map2)

  "The result of mergeParams" should "merge two maps into a map with Strings as keys and values" in {
    assert(resultMap.isInstanceOf[Map[String, String]])
  }

  it should "replace keys in the first map if they exists in the second map" in {
    assertResult(Some("2"))(resultMap.get("key1"))
  }

  it should "have the length of the combined unique keys" in {
    assertResult(3)(resultMap.size)
  }

  it should "convert Ints to Strings" in {
    assert(!resultMap.get("key3").equals(Some(100)))
  }
}

class FetcherTest extends FlatSpec {
  val fetcher10 = new DBAFetcher(page=10)

  "The params of the iprice.dba" should "contain 10 at the DBAFetcher.KeyPage" in {
    assertResult(Some("10"))(fetcher10.params.get(DBAFetcher.ApiKeyPage))
  }

  it should "return 20 when setPage has been called" in {
    fetcher10.setPage(20)
    assertResult(Some("20"))(fetcher10.params.get(DBAFetcher.ApiKeyPage))
  }
}

class FetcherUrlTest extends FlatSpec {
  val fetcher = new DBAFetcher()

  "The url" should "contain the default parameters" in {
    assertResult("http://api.dba.dk/api/v2/ads/cassearch?pn=1&f=json&pe=0&ps=100&at=2&filters=1&cla=27160")(fetcher.url.toString())
  }
}

class FetcherRequestTest extends FlatSpec {
  val req = new DBAFetcher() request

  "The request" should "return a non-empty string" in {
    assert(!req.isEmpty)
  }
}
