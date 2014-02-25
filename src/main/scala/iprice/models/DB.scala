package iprice.models

import iprice.config.Config
import com.mongodb.casbah.{MongoClient, MongoCredential, MongoCollection}
import com.mongodb.ServerAddress
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.Imports.$set

class DBOperations(val coll: MongoCollection) {
  def insert(doc: com.mongodb.DBObject) {
    coll.insert(doc)
  }

  def findOne(doc: com.mongodb.DBObject) = {
    coll.findOne(doc)
  }

  def findAll(doc: com.mongodb.DBObject) = {
    coll.find(doc)
  }
  /*
  def replace(query: MongoDBObject, update: MongoDBObject) = {
    coll.update(query, update)
  }

  def update(query: MongoDBObject, update: (String, Any)*) = {
    $set("3"->3, "2"->"d")
    //coll.update(query, $set(update))
  }
*/
  def remove(query: com.mongodb.DBObject) = {
    coll.remove(query)
  }

  def clear() {
    coll.dropCollection()
  }

  def count() = {
    coll.size
  }
}

object DB {
  private lazy val server = new ServerAddress(Config.DB.host, Config.DB.port)
  private lazy val credentials = MongoCredential(Config.DB.user, Config.DB.name, Config.DB.password.toCharArray)
  private lazy val mongoClient = MongoClient(server, List(credentials))
  lazy val db = mongoClient(Config.DB.name)

  object Unit extends DBOperations(db("Unit"))

}

