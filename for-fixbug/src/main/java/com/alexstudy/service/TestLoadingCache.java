package com.alexstudy.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author AlexTong
 * @ClassName TestLoadingCache
 * @Description TODO()
 * @date 2018/2/7 10:33:52
 */
public class TestLoadingCache {
//   <p>CacheBuilder作为LoadingCache 与 Cache实例的创建者，具有以下特征： </p>
//    <p>       1、自动载入键值至缓存；</p>
//    <p>       2、当缓存器溢出时，采用最近最少使用原则进行替换。</p>
//    <p>       3、过期规则可基于最后读写时间。</p>
//    <p>       4、设置键值引用级别。</p>
//    <p>       5、元素移出通知。</p>
//    <p>       6、缓存访问统计。</p>
//    <p> </p>
//    <p> </p>
//    <p> </p> 谷歌gavan开源开发包中的LoadingCache系统缓存机制，以下为创建缓存以及使用缓存机制实例

    /**
     * 谷歌LoadingCache缓存使用
     * @param args
     * */
    static LoadingCache<String, String> cahceBuilder = CacheBuilder.newBuilder()
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return cacheMap.get(key);
                }
            });

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 2; i++) {
            if(cahceBuilder.size()<1){
                test();
            }
            for (String s:cahceBuilder.asMap().keySet()) {
                System.err.println(s+"+++111::"+cahceBuilder.get(s));
            }
        }
        test2();
        for(int i = 0; i < 2; i++){
            for (String s:cahceBuilder.asMap().keySet()) {
                System.err.println(s+"+++222::"+cahceBuilder.get(s));
            }
        }
        //        cahceBuilder.invalidateAll();
    }
    private static Map<String,String> cacheMap = Maps.newHashMap();
         public static void test() throws Exception{
         cacheMap.put("test1", "test11");
         cacheMap.put("test2", "test12");
         cacheMap.put("test3", "test13");
         for (String s:cacheMap.keySet()) {
          if(!cahceBuilder.asMap().keySet().contains(s)){
                         cahceBuilder.get(s);
                     }
                 }
             }
         public static void test2() throws Exception{
                cacheMap.put("test5", "test21");
                cacheMap.put("test6", "test22");
                cacheMap.put("test4", "test23");
                 for (String s:cacheMap.keySet()) {
                    if(!cahceBuilder.asMap().keySet().contains(s)){
                         cahceBuilder.get(s);
                    }
                }
             }

        //  缓存机制更多方法如下：
        // <p>使用具体方法：</p>
        // <p> //缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存</p>
        // <p>LoadingCache<Integer,Student> studentCache</p>
        // <p><span style="color:#00ff;">//CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例</span></p>
        // <p><span style="color:#00ff;">= CacheBuilder.newBuilder()</span></p><p><span style="color:#33cccc;">//设置并发级别为8，并发级别是指可以同时写缓存的线程数</span></p>
        // <p><span style="color:#33cccc;">.concurrencyLevel(8)</span></p><p><span style="color:#ff0ff;">//设置写缓存后8秒钟过期</span></p>
        // <p><span style="color:#ff0ff;">.expireAfterWrite(8, TimeUnit.SECONDS)</span></p>
        // <p><span style="color:#ff00;">//设置缓存容器的初始容量为10</span></p>
        // <p><span style="color:#ff00;">.initialCapacity(10)</span></p>
        // <p><span style="color:#ffcc0;">//设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项</span></p>
        // <p><span style="color:#ffcc0;">.maximumSize(100)</span></p>
        // <p><span style="color:#969696;">//设置要统计缓存的命中率</span></p>
        // <p><span style="color:#969696;">.recordStats()</span></p>
        // <p><span style="color:#0ff0;">//设置缓存的移除通知</span></p>
        // <p><span style="color:#0ff0;">.removalListener(new RemovalListener<Object, Object>() {</span></p>
        // <p><span style="color:#0ff0;">@Override</span></p>
        // <p><span style="color:#0ff0;">public void onRemoval(RemovalNotification<Object, Object> notification) {</span></p>
        // <p><span style="color:#0ff0;">System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());</span></p>
        // <p><span style="color:#0ff0;">   }</span></p>
        // <p><span style="color:#0ff0;">})</span></p>
        // <p><span style="color:#ff0ff;">//build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存</span></p>
        // <p><span style="color:#ff0ff;">.build(</span></p>
        // <p><span style="color:#ff0ff;">     new CacheLoader<Integer, Student>() {</span></p>
        // <p><span style="color:#ff0ff;">     @Override</span></p>
        // <p><span style="color:#ff0ff;">     public Student load(Integer key) throws Exception {</span></p>
        // <p><span style="color:#ff0ff;">     System.out.println("load student " + key);</span></p>
        // <p><span style="color:#ff0ff;">      Student student = new Student();</span></p>
        // <p><span style="color:#ff0ff;">      student.setId(key);</span></p>
        // <p><span style="color:#ff0ff;">      student.setName("name " + key);</span></p>
        // <p><span style="color:#ff0ff;">      return student;</span></p>
        // <p><span style="color:#ff0ff;">                            }</span></p>
        // <p><span style="color:#ff0ff;">                        }</span></p>
        // <p><span style="color:#ff0ff;">                );</span></p>
}
