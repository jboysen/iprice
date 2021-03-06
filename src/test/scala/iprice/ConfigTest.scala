package iprice

import org.scalatest.FlatSpec
import iprice.config.Config

class ConfigTest extends FlatSpec {

  "The DB.host field of the Config object" should "equal to localhost (should work in most configurations)" in {
    assertResult("localhost")(Config.DB.host)
  }

  "The DB.port field of the Config object" should "equal to the Integer 3306 (should work in most configurations)" in {
    assertResult(27017)(Config.DB.port)
  }
}