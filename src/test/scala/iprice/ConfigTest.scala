package iprice

import org.scalatest.FlatSpec

class ConfigTest extends FlatSpec {

  "The DB.host field of the Config object" should "equal to localhost (should work in most configurations)" in {
    assertResult("localhost")(Config.DB.host)
  }

  "The DB.port field of the Config object" should "equal to the Integer 3306 (should work in most configurations)" in {
    assertResult(3306)(Config.DB.port)
  }
}