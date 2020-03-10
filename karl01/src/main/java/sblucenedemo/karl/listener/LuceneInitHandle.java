package sblucenedemo.karl.listener;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sblucenedemo.karl.service.search.ILuceneManageService;
import sblucenedemo.karl.service.search.ILuceneService;

import java.io.IOException;

@Component
@Order(value = 1)
public class LuceneInitHandle implements ApplicationRunner {
    @Autowired
    private ILuceneManageService iLuceneManageService;
    @Autowired
    private ILuceneService service;

    @Override
    public void run(ApplicationArguments arg0) throws IOException, ParseException {
        service.synProductCreatIndex();
        iLuceneManageService.changeLuceneIndexVersion("D:\\code\\java\\release\\Lucene01" );
        service.synProductCreatIndex();
    }
}
