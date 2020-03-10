package sblucenedemo.karl.service.search;

import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;

public interface ILuceneService {
    boolean synProductCreatIndex() throws IOException, ParseException;
}
