@ChangeLog(order = "036")
class LiquibaseMigrations {
    @ChangeSet(order = "001", id = "001_add_liquibase_1_2_3", author = "jandroav")
    def migration001(implicit db: MongoDatabase) = {
        Candidate(
          candidate = "liquibase",
          name = "Liquibase",
          description = "Innovate faster with database DevOps. Automated, secure, and compliant database change management pipelines that accelerate delivery and reduce toil",
          websiteUrl = "https://liquibase.com/",
          distribution = "UNIVERSAL"
        ).insert()
    }
}
