package iprice

import java.io.{FileNotFoundException, FileInputStream}
import java.util.Properties

object Config {
  val props = new Properties()
  try {
    props.load(new FileInputStream("config.properties"))
  } catch {
    case e: Exception => props.load(new FileInputStream("config.properties.default"))
  }

  object DB {
    val user = props.getProperty("DB.user")
    val password = props.getProperty("DB.password")
    val host = props.getProperty("DB.host")
    val port = props.getProperty("DB.port").asInstanceOf[Int]
    val database = props.getProperty("DB.database")
  }

  object DBA {
    val apikey = props.getProperty("DBA.apikey")
  }

}
