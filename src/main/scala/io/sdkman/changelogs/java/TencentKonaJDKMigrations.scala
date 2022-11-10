package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{
  Tencent,
  Linux64,
  LinuxARM64,
  MacOSX,
  Version,
  Windows
}

@ChangeLog(order = "074")
class TencentKonaJDKMigrations {

  @ChangeSet(
    order = "001",
    id = "001-add_konajdk-8u352",
    author = "johnshajiang"
  )
  def migrate001(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "TencentKona8.0.12.b1_jdk_linux-aarch64_8u352.tar.gz",
      Linux64    -> "TencentKona8.0.12.b1_jdk_linux-x86_64_8u352.tar.gz",
      MacOSX     -> "TencentKona8.0.12.b1_jdk_macosx-x86_64_8u352_notarized.tar.gz",
      Windows    -> "TencentKona8.0.12.b1_jdk_windows-x86_64_8u352_signed.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "8u262-tencent",
            s"https://github.com/Tencent/TencentKona-8/releases/download/8.0.12-GA/$binary",
            platform,
            Some(Tencent)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "002",
    id = "002-add_konajdk-11.0.17",
    author = "johnshajiang"
  )
  def migrate002(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "TencentKona-11.0.17.b1-jdk_linux-aarch64.tar.gz",
      Linux64    -> "TencentKona-11.0.17.b1-jdk_linux-x86_64.tar.gz",
      MacOSX     -> "TencentKona-11.0.17.b1_jdk_macosx-x86_64_notarized.tar.gz",
      Windows    -> "TencentKona-11.0.17.b1_jdk_windows-x86_64_signed.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "11.0.17-tencent",
            s"https://github.com/Tencent/TencentKona-11/releases/download/kona11.0.17/$binary",
            platform,
            Some(Tencent)
          )
      }
      .toList
      .validate()
      .insert()

  @ChangeSet(
    order = "003",
    id = "003-add_konajdk-17.0.5",
    author = "johnshajiang"
  )
  def migrate003(implicit db: MongoDatabase): Unit =
    Map(
      LinuxARM64 -> "TencentKona-17.0.5.b1-jdk_linux-aarch64.tar.gz",
      Linux64    -> "TencentKona-17.0.5.b1-jdk_linux-x86_64.tar.gz",
      MacOSX     -> "TencentKona-17.0.5.b1_jdk_macosx-x86_64_notarized.tar.gz",
      Windows    -> "TencentKona-17.0.5.b1_jdk_windows-x86_64_signed.zip"
    ).map {
        case (platform, binary) =>
          Version(
            "java",
            "17.0.5-tencent",
            s"https://github.com/Tencent/TencentKona-17/releases/download/TencentKona-17.0.5/$binary",
            platform,
            Some(Tencent)
          )
      }
      .toList
      .validate()
      .insert()
}
