package ru.scopus.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ru.scopus.models.AuthorInfo;

import java.io.IOException;
import java.util.List;

public class WorkWithIdService {

    private static final String URL = "https://www.scopus.com/authid/detail.uri?authorId=%id";
    private HttpInfoService httpInfoService;

    public WorkWithIdService(HttpInfoService httpInfoServiceImpl) {
        this.httpInfoService = httpInfoServiceImpl;
    }

    public void workWithAuthors(List<Long> authorsId) {
        for (Long author : authorsId) {
            try {
                ScopusService scopusService = createScopusService(author);
                AuthorInfo authorsInfo = scopusService.getInformation(author);
                System.out.println(authorsInfo);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    private ScopusService createScopusService(Long author) throws IOException {
        String urlWithAuthor = URL.replace("%id", author.toString());
        Document doc = Jsoup.connect(urlWithAuthor).get();
        httpInfoService.setDoc(doc);
        return new ScopusServiceImpl(httpInfoService);
    }
}
