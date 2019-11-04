package ru.scopus.service;

import org.jsoup.select.Elements;
import ru.scopus.models.AuthorInfo;

import static ru.scopus.models.ElementsMapper.toAuthorInfo;

public class ScopusServiceImpl implements ScopusService {

    private HttpInfoService httpInfoService;

    public ScopusServiceImpl(HttpInfoService httpInfoService) {
        this.httpInfoService = httpInfoService;
    }

    public AuthorInfo getInformation(Long authorId) {
        AuthorInfo authorFullInfo = null;
        try {
            AuthorInfo authorIdNameInfo = httpInfoService.getAuthorIdAndName();
            if (authorIdNameInfo.getAuthorId().equals(authorId)) {
                Elements infoElements = httpInfoService.getInfoNodeWithNotEmptyChild();
                authorFullInfo = toAuthorInfo(authorIdNameInfo, infoElements);
            } else {
                throw new RuntimeException("Bad parse page. Not equals Number");
            }
        } catch (Exception e) {
            System.err.println("Have troble with number [" + authorId + "] " + e.getMessage());
        }
        return authorFullInfo;
    }


}
