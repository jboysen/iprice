import models.DB

/**
 * Created by jakob on 24/12/13.
 */
object Main extends App {
  override def main(args: Array[String]) {
    val dbUser = sys.env.getOrElse("IPRICE_USER", "root").asInstanceOf[String]

    DB.save(models.Unit("test", "to"))
  }
}
