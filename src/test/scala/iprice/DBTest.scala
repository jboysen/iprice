package iprice

import org.scalatest.FlatSpec
import iprice.models.{DBOperations, DB}
import com.mongodb.casbah.commons.MongoDBObject

class DBTest extends FlatSpec {

  object TestCollection extends DBOperations(DB.db("TestCollection"))


  "The DB method insert" should "add one to the collection" in {
    TestCollection.insert(MongoDBObject("hello" -> "world"))
    val result = TestCollection.findOne(MongoDBObject("hello" -> "world"))
    assert(result != null)
  }

  "Findall" should "return 1 row" in {
    val result = TestCollection.findAll(MongoDBObject("hello" -> "world"))
    assert(result != null)
    assertResult(result.size)(1)
  }

  "Clear" should "remove the collection entirely" in {
    TestCollection.insert(MongoDBObject("hello" -> "world"))

    assert(TestCollection.count() > 0)
    TestCollection.clear()
    assert(TestCollection.count() == 0)
  }
}