package models

import sorm.{InitMode, Entity, Instance}
import scala.sys.SystemProperties

/**
 * Created by jakob on 24/12/13.
 */
object DB extends Instance(
  entities = Set(
    Entity[models.Unit](),
    Entity[models.Calculation]()
  ),
  url = "jdbc:mysql://localhost:3306/sorm",
  user = sys.env.getOrElse("IPRICE_USER", "root"),
  password = sys.env.getOrElse("IPRICE_PASSWORD", ""),
  initMode = InitMode.DropAllCreate
)
