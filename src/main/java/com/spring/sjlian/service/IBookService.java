package com.spring.sjlian.service;

import com.spring.sjlian.model.Book;

import java.util.List;

/**
 * 业务层接口
 * Created by lian on 17/7/13.
 */
public interface IBookService {
    List<Book> queryAll(int offset, int limit);
}
