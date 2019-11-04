package ru.scopus.models;

public class AuthorInfo {

    private Long authorId;
    private String authorName;
    private Integer countOfAllDocument;
    private String byDocuments;
    private Integer countOfCitations;
    private Integer hIndex;

    public AuthorInfo(Long authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Integer getCountOfAllDocument() {
        return countOfAllDocument;
    }

    public void setCountOfAllDocument(Integer countOfAllDocument) {
        this.countOfAllDocument = countOfAllDocument;
    }

    public Integer getCountOfCitations() {
        return countOfCitations;
    }

    public void setCountOfCitations(Integer countOfCitations) {
        this.countOfCitations = countOfCitations;
    }

    public Integer gethIndex() {
        return hIndex;
    }

    public void sethIndex(Integer hIndex) {
        this.hIndex = hIndex;
    }

    public String getByDocuments() {
        return byDocuments;
    }

    public void setByDocuments(String byDocuments) {
        this.byDocuments = byDocuments;
    }

    @Override
    public String toString() {
        return  "authorId = " + authorId +
                ", authorName = '" + authorName + '\'' +
                ", Documents by author = " + countOfAllDocument +
                ", Total citations = " + countOfCitations +
                " by " + byDocuments + " documents " +
                ", hIndex = " + hIndex;
    }
}
