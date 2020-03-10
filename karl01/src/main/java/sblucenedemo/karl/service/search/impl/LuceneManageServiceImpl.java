package sblucenedemo.karl.service.search.impl;

import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import sblucenedemo.karl.config.LuceneConfig;
import sblucenedemo.karl.service.search.ILuceneManageService;

import java.io.IOException;

@Service
public class LuceneManageServiceImpl implements ILuceneManageService {
    @Autowired
    private LuceneConfig luceneConfig;
    @Autowired
    private ApplicationContext ctx;

    @Override
    public void changeLuceneIndexVersion(String versionPath) throws IOException {
        //获取BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory();

        luceneConfig.setLuceneIndexPath(versionPath);

        Directory directory = luceneConfig.directory();
        defaultListableBeanFactory.removeBeanDefinition("directory");
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(directory.getClass());
        defaultListableBeanFactory.registerBeanDefinition("directory", beanDefinitionBuilder.getBeanDefinition());

        defaultListableBeanFactory.removeBeanDefinition("searcherManager");
        BeanDefinitionBuilder searchManageBuilder = BeanDefinitionBuilder.genericBeanDefinition(luceneConfig.searcherManager(directory).getClass());
        defaultListableBeanFactory.registerBeanDefinition("searcherManager", searchManageBuilder.getBeanDefinition());
    }
}
