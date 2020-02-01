package utils;

public class Constant {
    public static String JIRA_ROOT_URL = System.getProperty("jiraRootURL", "https://jira.company.com").toLowerCase();
    public static String JIRA_USERNAME = System.getProperty("jiraUsername", "username").toLowerCase();
    public static String JIRA_PASSWORD = System.getProperty("jiraPassword", "password");
    public static String JIRA_ISSUE_KEYS = System.getProperty("jiraIssueKeys", "TD-2461");
    public static String IMPORTED_SCENARIO_DIRECTORY = System.getProperty("importedScenarioDirectory", "target/TestsImportedFromJira");
}
