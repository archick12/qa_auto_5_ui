package backend.utils;

import org.json.simple.JSONObject;


public class JiraJsonFixture {


    public String generateJSONForLogin() {
        JSONObject credentials = new JSONObject();
        credentials.put("username", "gubernatorova.sn");
        credentials.put("password", "11111111");

        return credentials.toJSONString();
    }

    public String generateJSONForIssue(){

        // Call method that reads properties from specified file as collection


        JSONObject issueData = new JSONObject();
        JSONObject fields = new JSONObject();
        JSONObject project = new JSONObject();
        JSONObject issuetype = new JSONObject();
        JSONObject assignee = new JSONObject();
        JSONObject reporter = new JSONObject();

            project.put("id", "10012");
            issuetype.put("id", "10006");
            assignee.put("name", "gubernatorova.sn");
            reporter.put("name", "gubernatorova.sn");

        fields.put("project", project);
        fields.put("summary", "something's wrong Snizhanna-test");
        fields.put("issuetype", issuetype);
        fields.put("assignee", assignee);
        fields.put("reporter", reporter);

        issueData.put("fields", fields);

        //fields.putAll(projects);
        return issueData.toString();
    }
}
