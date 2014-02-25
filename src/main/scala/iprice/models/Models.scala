package iprice.models

case class Unit(
                  title: String,
                  meta_data: String
                 )

case class Calculation(
                  unit: Unit,
                  avg: Int,
                  num: Int,
                  not_used_prices: String,
                  used_prices: String,
                  all_prices: String
                        )

case class Ad(
                price: Int,
                metaData: Map[String, String]
               )