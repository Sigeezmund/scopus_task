package ru.scopus.service;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.scopus.models.AuthorInfo;

import java.io.IOException;

public interface HttpInfoService {
    void setDoc(Document doc);

    AuthorInfo getAuthorIdAndName();

    Elements getInfoNodeWithNotEmptyChild() throws IOException;
}
