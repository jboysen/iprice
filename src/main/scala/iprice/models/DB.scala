package models

import sorm.{InitMode, Entity, Instance}
import iprice.config.Config

object DB extends Instance(
  entities = Set(
    Entity[models.Unit](),
    Entity[models.Calculation]()
  ),
  url = "jdbc:mysql://localhost:3306/" + Config.DB.name,
  user = Config.DB.user,
  password = Config.DB.password,
  initMode = InitMode.DropAllCreate
)