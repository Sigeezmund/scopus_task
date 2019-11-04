package ru.scopus.service;

import ru.scopus.models.AuthorInfo;

import java.net.MalformedURLException;
import java.util.List;

public interface ScopusService {

    public AuthorInfo getInformation(Long authorsId);
}
