package sblucenedemo.karl.service.search.impl;

import org.apache.lucene.queryparser.classic.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sblucenedemo.karl.dao.ILuceneDao;
import sblucenedemo.karl.entity.PageInfo;
import sblucenedemo.karl.entity.PageQuery;
import sblucenedemo.karl.entity.Product;
import sblucenedemo.karl.service.search.ILuceneService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LuceneServiceImpl implements ILuceneService {
    private Logger logger = LoggerFactory.getLogger(ILuceneService.class);

    @Autowired
    private ILuceneDao iLuceneDao;

    @Override
    public boolean synProductCreatIndex() throws IOException, ParseException {
        logger.info("同步索引数据！");
        Product product = new Product();
//        product.setId(1);
        product.setCategory("测试01");
//        product.setCode("m09102938192839123");
//        product.setName("GOODS name1");
//        product.setPlace("shenzhen");
//        product.setPrice(12.3F);

        PageQuery<Product> pageQuery = new PageQuery<>();
        pageQuery.setPageInfo(new PageInfo(1,100,100));
        Map<String, String> params = new HashMap<>();
        pageQuery.setQueryParam(params);
        pageQuery.setParams(product);

        PageQuery<Product> query = iLuceneDao.searchProduct(pageQuery);
        logger.info("搜索结果：{}", query);

        return true;
    }
}
