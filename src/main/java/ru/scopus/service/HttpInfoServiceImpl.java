package ru.scopus.service;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.scopus.models.AuthorInfo;

import java.io.IOException;

public class HttpInfoServiceImpl implements HttpInfoService {

    private Document doc;

    public HttpInfoServiceImpl() {
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public AuthorInfo getAuthorIdAndName() {
        String id = doc.select("#authorDetailsPage").get(0).getElementById("authId").val();
        String name = doc.getElementsByAttributeValue("class", "wordBreakWord").text();
        return new AuthorInfo(new Long(id), name);
    }

    public Elements getInfoNodeWithNotEmptyChild() throws IOException {
        Elements infoElements = doc.getElementsByAttributeValue("class", "row flexDisplay");
        return infoElements.get(0).getAllElements();
    }
}
