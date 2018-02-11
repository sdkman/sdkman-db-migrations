package io.sdkman;

import com.github.mongobee.Mongobee;
import com.github.mongobee.exception.MongobeeException;

public class DbMigration {
    public static void main(String[] args) throws MongobeeException {
        Mongobee runner = new Mongobee("mongodb://scopuli:27017/sdkman");
        runner.setDbName("sdkman");
        runner.setChangeLogsScanPackage("io.sdkman.changelogs");
        runner.execute();
        System.out.println("Run db migration.");
    }
}
