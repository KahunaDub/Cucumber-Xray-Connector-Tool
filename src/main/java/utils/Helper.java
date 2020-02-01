package utils;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Helper {

    public static void importTestsFromJIRA(String jiraKeys) throws IOException {

        makeDirectory(Constant.IMPORTED_SCENARIO_DIRECTORY);

        RestAssured.baseURI = Constant.JIRA_ROOT_URL + "/rest/raven/1.0/export/test";

        InputStream inputResponse = RestAssured.given().relaxedHTTPSValidation()
                .auth().preemptive().basic(
                Constant.JIRA_USERNAME,
                Constant.JIRA_PASSWORD).header("Content-Type", "application/json").param("keys", jiraKeys).get().asInputStream();

        File downloadedFile = new File(Constant.IMPORTED_SCENARIO_DIRECTORY + "/jiraTEST.feature");

        FileUtils.copyInputStreamToFile(inputResponse, downloadedFile);
    }

    private static boolean fileExists(String pathToFile) {
        return new File(pathToFile).exists();
    }

    public static void exportReportToJIRA() throws IOException {

        String content = new String(Files.readAllBytes(Paths.get("target/cucumber.json")));

        RestAssured.baseURI = Constant.JIRA_ROOT_URL + "/rest/raven/1.0/import/execution/cucumber";

        Response response  = RestAssured.given().relaxedHTTPSValidation()
                .auth().preemptive().basic(
                        Constant.JIRA_USERNAME,
                        Constant.JIRA_PASSWORD).header("Content-Type", "application/json")
                .body(content)
                .post();

        System.out.println("response.statusCode() = " + response.statusCode());
    }


    static void makeDirectory(String newDirString) {
        File file = new File(newDirString);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("\ninfo: Directory was created!\n");
            } else {
                System.out.println("\nerror: Failed to create directory!\n");
            }
        } else {
            System.out.println("Directory exists");
        }
    }
}
