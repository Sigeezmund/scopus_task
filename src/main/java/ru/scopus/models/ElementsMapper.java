package ru.scopus.models;

import org.jsoup.select.Elements;

public class ElementsMapper {

    private ElementsMapper(){}

    private static final String FIELDS_WITH_NUMBER_NAME = "span.fontLarge";
    private static final String FIELDS_WITH_BY_DOCUMENT_NAME = "span.btnText";

    public static AuthorInfo toAuthorInfo(AuthorInfo author, Elements infoElements){
        String countOfAllDocument = infoElements.select(FIELDS_WITH_NUMBER_NAME).get(0).text();
        String countOfCitations = infoElements.select(FIELDS_WITH_NUMBER_NAME).get(1).text();
        String hIndex = infoElements.select(FIELDS_WITH_NUMBER_NAME).get(2).text();
        String byDoc = infoElements.select(FIELDS_WITH_BY_DOCUMENT_NAME).get(0).text();
        author.setCountOfAllDocument(new Integer(countOfAllDocument));
        author.setCountOfCitations(new Integer(countOfCitations));
        author.setByDocuments(byDoc);
        author.sethIndex(new Integer(hIndex));
        return author;
    }
}
