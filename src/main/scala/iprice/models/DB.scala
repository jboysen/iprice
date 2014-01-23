package models

import com.mongodb.casbah.Imports._

class DBOperations(val coll: MongoCollection) {
  def insert(doc: MongoDBObject) {
    coll.insert(doc)
  }

  def find(doc: MongoDBObject) = {
    coll.findOne(doc)
  }

  def replace(query: MongoDBObject, update: MongoDBObject) = {
    coll.update(query, update)
  }

  def update(query: MongoDBObject, update: (String, Any)*) = {
    $set("3"->3, "2"->"d")
    //coll.update(query, $set(update))
  }

  def remove(query: MongoDBObject) = {
    coll.remove(query)
  }
}

object DB {
  lazy val mongoClient = MongoClient("localhost", 27017)
  lazy val db = mongoClient("iprice")

  object Unit extends DBOperations(db("Unit"))

}

