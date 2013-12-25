package iprice

import java.io.FileInputStream
import java.util.Properties

/**
 *
 */
object Config {
  val props = new Properties()
  props.load(new FileInputStream("config.properties"))

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
