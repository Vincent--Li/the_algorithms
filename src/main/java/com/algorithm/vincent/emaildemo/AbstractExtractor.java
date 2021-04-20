package com.algorithm.vincent.emaildemo;

import java.util.List;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public interface AbstractExtractor {
    void extract();
    void insertToWiki();
    List<Article> extractEmail();
}
