package iprice

import java.io.{FileNotFoundException, FileInputStream}
import java.util.Properties

object Config {
  val props = new Properties()
  try {
    load("config.properties")
  } catch {
    case e: Exception => load("config.default.properties")
  }

  private def load(filename: String) {
    props.load(new FileInputStream(filename))
  }

  object DB {
    val user = props.getProperty("DB.user")
    val password = props.getProperty("DB.password")
    val host = props.getProperty("DB.host")
    val port = props.getProperty("DB.port").toInt
    val database = props.getProperty("DB.database")
  }

  object DBA {
    val apikey = props.getProperty("DBA.apikey")
  }

}
