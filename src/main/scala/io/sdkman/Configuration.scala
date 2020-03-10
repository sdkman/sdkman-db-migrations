package io.sdkman

import com.typesafe.config.{Config, ConfigFactory}

trait Configuration {

  lazy val config: Config = ConfigFactory.load()

  lazy val mongoHost: String = config.getString("mongo.host")

  lazy val mongoPort: Int = config.getInt("mongo.port")

  lazy val mongoDatabase: String = config.getString("mongo.database")

  lazy val mongoUsernameO: Option[String] =
    Option(config.getString("mongo.username")).filter(!_.isEmpty)

  lazy val mongoPassword: String = config.getString("mongo.password")
}
