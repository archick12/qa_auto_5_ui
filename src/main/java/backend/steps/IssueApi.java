package backend.steps;

import backend.utils.ApiUris;
import backend.utils.RequestSender;
import com.jayway.restassured.response.Response;


public class IssueApi {

    RequestSender requestSender;

    public Response secureCreateIssue(String body) {
        requestSender = new RequestSender();

        requestSender
                .secureCreateRequest(body)
                .post(ApiUris.ISSUE.getUri());
        return requestSender.response;

    }

    public Response createIssue(String body) {
        requestSender = new RequestSender();
        requestSender
                .createRequest(body)
                .post(ApiUris.ISSUE.getUri());
        return requestSender.response;
    }

    public Response getIssue(String issueId) {
        requestSender = new RequestSender();
        requestSender
                .createRequest()
                .get(ApiUris.ISSUE.getUri(issueId));
        return requestSender.response;

    }

    public Response deleteIssue(String issueId) {
        requestSender = new RequestSender();
        requestSender
                .createRequest()
                .delete(ApiUris.ISSUE.getUri(issueId));
        return requestSender.response;

    }

    public Response secureDeleteIssue(String issueId) {
        requestSender = new RequestSender();
        requestSender
                .secureCreateRequest()
                .delete(ApiUris.ISSUE.getUri(issueId));
        return requestSender.response;
    }

    public Response secureAddComment(String issueId, String body) {
        requestSender = new RequestSender();
        requestSender
                .secureCreateRequest(body)
                .post(ApiUris.ISSUE.getUri() + "/" + issueId + "/comment");
        return requestSender.response;

    }

    public Response deleteComment(String issueId) {
        requestSender = new RequestSender();
        requestSender
                .createRequest()
                .delete(ApiUris.ISSUE.getUri() + "/" + issueId + "/comment");
        return requestSender.response;


    }

    public Response addComment(String issueId, String body) {
        requestSender = new RequestSender();
        requestSender
                .createRequest(body)
                .post(ApiUris.ISSUE.getUri() + "/" + issueId + "/comment");
        return requestSender.response;
    }

    public Response getSecureIssue(String issueId) {
        requestSender = new RequestSender();
        requestSender
                .secureCreateRequest()
                .get(ApiUris.ISSUE.getUri(issueId));
        return requestSender.response;
    }

    public Response editSummarySecure(String issueId, String body) {
        requestSender = new RequestSender();
        requestSender
                .secureCreateRequest(body)
                .put(ApiUris.ISSUE.getUri(issueId));
        return requestSender.response;
    }

    public Response editSummary(String issueId, String body) {
        requestSender = new RequestSender();
        requestSender
                .createRequest(body)
                .put(ApiUris.ISSUE.getUri(issueId));
        return requestSender.response;
    }

    public Response secureGetComment(String issueId, String CommentId) {
        requestSender = new RequestSender();
        requestSender
                .secureCreateRequest()
                .get(ApiUris.ISSUE.getUri() + "/" + issueId + "/comment/" + CommentId);
        return requestSender.response;
    }

    public Response changeIssueType(String issueId, String body) {
        requestSender = new RequestSender();
        requestSender
                .secureCreateRequest(body)
                .put(ApiUris.ISSUE.getUri(issueId));
        return requestSender.response;

    }

    public Response secureSearch(String issueId, String body) {
        requestSender = new RequestSender();

        requestSender
                .secureCreateRequest(body)
                .get(ApiUris.SEARCH.getUri(issueId));
        return requestSender.response;
    }

    public Response search(String issueId, String body) {
        requestSender
                .createRequest(body)
                .get(ApiUris.SEARCH.getUri(issueId));
        return requestSender.response;
    }

    public Response secureAssign(String issueId, String body) {
        requestSender = new RequestSender();
        requestSender
                .secureCreateRequest(body)
                .put(ApiUris.ISSUE.getUri(issueId) + "/assignee");
        return requestSender.response;

    }

    public Response assign(String issueId, String body) {
        requestSender = new RequestSender();
        requestSender
                .createRequest(body)
                .put(ApiUris.ISSUE.getUri(issueId) + "/assignee");
        return requestSender.response;
    }
}
