package sblucenedemo.karl.service.search;

import java.io.IOException;

public interface ILuceneManageService {
    /**
     * 改变Lucene版本路径
     * @param versionPath
     */
    void changeLuceneIndexVersion(String versionPath) throws IOException;
}
