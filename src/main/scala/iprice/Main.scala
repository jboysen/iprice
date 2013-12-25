package iprice

import models.DB

object Main extends App {

  val dbUser = sys.env.getOrElse("IPRICE_USER", "root").asInstanceOf[String]

  DB.save(models.Unit("test", "to"))

}
