package choi.oop.model.support;

public enum ResultContentType {
    TEXT("Text"), FILE("File"), TAG("Tag"), UNKNOWN("Unknown");

    private String value;

    ResultContentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
