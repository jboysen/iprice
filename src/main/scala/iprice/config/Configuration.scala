package iprice.config

import com.typesafe.config.ConfigFactory

object Config {
  lazy val config = ConfigFactory.load()

  object DB {
    lazy val user = config.getString("db.user")
    lazy val password = config.getString("db.password")
    lazy val port = config.getInt("db.port")
    lazy val name = config.getString("db.name")
    lazy val host = config.getString("db.host")
  }

  object DBA {
    lazy val apiKey = config.getString("DBA.apiKey")
  }

}
