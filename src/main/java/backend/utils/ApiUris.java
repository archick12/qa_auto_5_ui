package backend.utils;

public enum ApiUris {

    // TODO can be replaced with interface

    LOGIN("/rest/auth/1/session"),
    ISSUE("/rest/api/2/issue"),
    SEARCH("/rest/api/2/search");

    private String uri;

    ApiUris(String url) {
        this.uri = url;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUri(String suffix) {
        return this.uri + "/" + suffix;
    }

}
