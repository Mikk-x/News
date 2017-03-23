/*
 * Copyright 2017 lizhaotailang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikk.news.util;

/**
 * Created by Mikk on 2017/3/23.
 * 包含了主要的api接口
 * this class contain the main APIs
 */
public class Api {

    // 消息内容获取与离线下载
    // 在最新消息中获取到的id，拼接到这个NEWS之后，可以获得对应的JSON格式的内容
    public static final String ZHIHU_NEWS = "http://news-at.zhihu.com/api/4/news/";

    // 过往消息
    // 若要查询的11月18日的消息，before后面的数字应该为20161118
    // 知乎日报的生日为2013 年 5 月 19 日，如果before后面的数字小于20130520，那么只能获取到空消息
    public static final String ZHIHU_HISTORY = "http://news.at.zhihu.com/api/4/news/before/";


    // 获取果壳精选的文章列表,通过组合相应的参数成为完整的url
    public static final String GUOKR_ARTICLES = "http://apis.guokr.com/handpick/article.json?retrieve_type=by_since&category=all&limit=25&ad=1";

    // 获取果壳文章的具体信息 V1
    // specific information of guokr post V1
    public static final String GUOKR_ARTICLE_LINK_V1 = "http://jingxuan.guokr.com/pick/";


    // 豆瓣一刻
    // 根据日期查询消息列表
    public static final String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";

    // 获取文章具体内容
    public static final String DOUBAN_ARTICLE_DETAIL = "https://moment.douban.com/api/post/";

}
