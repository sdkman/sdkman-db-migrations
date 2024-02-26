@ChangeLog(order = "085")
class LiquibaseMigrations {
    @ChangeSet(order = "001", id = "001_add_liquibase_1_2_3", author = "jandroav")
    def migration001(implicit db: MongoDatabase) = {
        Candidate(
          candidate = "liquibase",
          name = "Liquibase",
          description = "Liquibase is an open-source database-independent library for tracking, managing and applying database schema changes.",
          websiteUrl = "https://liquibase.com/",
          distribution = "UNIVERSAL"
        ).insert()
    }
}
