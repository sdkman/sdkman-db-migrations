package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "003")
class ScalaMigrations {

  @ChangeSet(order = "001", id = "001-add_scala_2_12_6", author = "marc0der")
  def migration001(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.12.6",
      url = "https://downloads.lightbend.com/scala/2.12.6/scala-2.12.6.zip"
    ).validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(
    order = "002",
    id = "002-add_scala_2_11_11_and_12",
    author = "marc0der"
  )
  def migration002(implicit db: MongoDatabase) =
    List(
      Version(
        candidate = "scala",
        version = "2.11.11",
        url = "https://downloads.lightbend.com/scala/2.11.11/scala-2.11.11.zip"
      ),
      Version(
        candidate = "scala",
        version = "2.11.12",
        url = "https://downloads.lightbend.com/scala/2.11.12/scala-2.11.12.zip"
      )
    ).validate()
      .insert()

  @ChangeSet(
    order = "003",
    id = "003-add_scala_2_12_7_as_default",
    author = "marc0der"
  )
  def migration003(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.12.7",
      url = "https://downloads.lightbend.com/scala/2.12.7/scala-2.12.7.zip"
    ).validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(
    order = "004",
    id = "004-add_scala_2_12_8_as_default",
    author = "marc0der"
  )
  def migration004(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.12.8",
      url = "https://downloads.lightbend.com/scala/2.12.8/scala-2.12.8.zip"
    ).validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(
    order = "005",
    id = "005-add_scala_2_13_0_as_default",
    author = "marc0der"
  )
  def migration005(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.13.0",
      url = "https://downloads.lightbend.com/scala/2.13.0/scala-2.13.0.tgz"
    ).validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(order = "006", id = "006-add_scala_2_12_9", author = "lrlucena")
  def migration006(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.12.9",
      url = "https://downloads.lightbend.com/scala/2.12.9/scala-2.12.9.zip"
    ).validate()
      .insert()

  @ChangeSet(order = "007", id = "007-add_scala_2_12_10", author = "marc0der")
  def migration007(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.12.10",
      url = "https://downloads.lightbend.com/scala/2.12.10/scala-2.12.10.zip"
    ).validate()
      .insert()

  @ChangeSet(
    order = "008",
    id = "008-add_scala_2_13_1_as_default",
    author = "lrlucena"
  )
  def migration008(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.13.1",
      url = "https://downloads.lightbend.com/scala/2.13.1/scala-2.13.1.zip"
    ).validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(
    order = "009",
    id = "009-add_scala_2_12_11",
    author = "lrlucena"
  )
  def migration009(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.12.11",
      url = "https://downloads.lightbend.com/scala/2.12.11/scala-2.12.11.zip"
    ).validate()
      .insert()

  @ChangeSet(
    order = "010",
    id = "010-add_scala_2_13_2_as_default",
    author = "lrlucena"
  )
  def migration010(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.13.2",
      url = "https://downloads.lightbend.com/scala/2.13.2/scala-2.13.2.zip"
    ).validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(
    order = "011",
    id = "011-add_scala_2_13_3_as_default",
    author = "balmungsan"
  )
  def migration011(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.13.3",
      url = "https://downloads.lightbend.com/scala/2.13.3/scala-2.13.3.zip"
    ).validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(
    order = "012",
    id = "012-add_scala_2_12_12",
    author = "jvdp"
  )
  def migration012(implicit db: MongoDatabase) =
    Version(
      candidate = "scala",
      version = "2.12.12",
      url = "https://downloads.lightbend.com/scala/2.12.12/scala-2.12.12.zip"
    ).validate()
      .insert()

  @ChangeSet(
    order = "013",
    id = "013_add_scala3_3_0_0_M1",
    author = "catap"
  )
  def migration013(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "scala",
      version = "3.0.0-M1",
      url = "https://github.com/lampepfl/dotty/releases/download/" +
        "3.0.0-M1/scala3-3.0.0-M1.zip"
    ).validate()
      .insert()

  @ChangeSet(
    order = "014",
    id = "014_add_scala_2_13_4_as_default",
    author = "balmungsan"
  )
  def migration014(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "scala",
      version = "2.13.4",
      url = "https://downloads.lightbend.com/scala/2.13.4/scala-2.13.4.zip"
    ).validate()
      .insert()
      .asCandidateDefault()

  @ChangeSet(
    order = "015",
    id = "015_add_scala3_3_0_0_M2",
    author = "anaumidis"
  )
  def migration015(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "scala",
      version = "3.0.0-M2",
      url = "https://github.com/lampepfl/dotty/releases/download/" +
        "3.0.0-M2/scala3-3.0.0-M2.zip"
    ).validate()
      .insert()

  @ChangeSet(
    order = "016",
    id = "016_add_scala3_3_0_0_M3",
    author = "anaumidis"
  )
  def migration016(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "scala",
      version = "3.0.0-M3",
      url = "https://github.com/lampepfl/dotty/releases/download/" +
        "3.0.0-M3/scala3-3.0.0-M3.zip"
    ).validate()
      .insert()

  @ChangeSet(
    order = "017",
    id = "017_add_scala_2_12_13",
    author = "lrlucena"
  )
  def migration017(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "scala",
      version = "2.12.13",
      url = "https://downloads.lightbend.com/scala/2.12.13/scala-2.12.13.zip"
    ).validate()
      .insert()
}
