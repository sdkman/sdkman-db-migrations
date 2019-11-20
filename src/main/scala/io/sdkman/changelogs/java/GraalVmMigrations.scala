package io.sdkman.changelogs.java

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import io.sdkman.changelogs.{Graal, Linux64, MacOSX, Version, Windows}

@ChangeLog(order = "021")
class GraalVmMigrations {

	@ChangeSet(order = "001", id = "001-add_graalvm_19_3_0", author = "eddumelendez")
	def migrate001(implicit db: MongoDatabase) = {
		List(
			Version(
				candidate = "java",
				version = "19.3.0.r11-grl",
				url = "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java11-linux-amd64-19.3.0.tar.gz",
				platform = Linux64,
				vendor = Some(Graal)),
			Version(
				candidate = "java",
				version = "19.3.0.r11-grl",
				url = "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java11-darwin-amd64-19.3.0.tar.gz",
				platform = MacOSX,
				vendor = Some(Graal)),
			Version(
				candidate = "java",
				version = "19.3.0.r11-grl",
				url = "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java11-windows-amd64-19.3.0.zip",
				platform = Windows,
				vendor = Some(Graal)),
			Version(
				candidate = "java",
				version = "19.3.0.r8-grl",
				url = "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java8-linux-amd64-19.3.0.tar.gz",
				platform = Linux64,
				vendor = Some(Graal)),
			Version(
				candidate = "java",
				version = "19.3.0.r8-grl",
				url = "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java8-darwin-amd64-19.3.0.tar.gz",
				platform = MacOSX,
				vendor = Some(Graal)),
			Version(
				candidate = "java",
				version = "19.3.0.r8-grl",
				url = "https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-19.3.0/graalvm-ce-java8-windows-amd64-19.3.0.zip",
				platform = Windows,
				vendor = Some(Graal)))
			.validate()
			.insert()
	}

}
