package com.alexstudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author AlexTong
 * @ClassName RedisService
 * @Description TODO()
 * @date 2018/2/7 14:28:39
 */
public class RedisService {
    private static String redisCode = "utf-8";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 从指定的列表右边出队,添加到目的列表中
     *
     * @param srckey
     *            源列表
     * @param dstkey
     *            　目的列表
     * @return
     */
    public String rpoppush(final String srckey, final String dstkey) {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                try {
                    return new String (connection.rPopLPush(srckey.getBytes(), dstkey.getBytes()), redisCode);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return "";
            }
        });
    }
    /**
     * 获取指定列表的范围数据
     *
     * @param key
     *            　列表名
     * @param start
     *            　开始位置
     * @param end
     *            　结束位置
     * @return
     */
    public List<String> lrange(final String key, final int start, final int end) {
        return redisTemplate.execute(new RedisCallback<List<String>>() {
            List<String> result = new ArrayList<String>();
            public List<String> doInRedis(RedisConnection connection)
                    throws DataAccessException {
                List<byte[]> bytelist= connection.lRange(key.getBytes(), start, end);
                for (byte[] b : bytelist) {
                    try {
                        result.add(new String(b, redisCode));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                return result;
            }
        });
    }
    /**
     * 从队列的左边取出一条数据
     *
     * @param key
     *            　列表名
     * @return
     */
    public String lpop(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] result = connection.lPop(key.getBytes());
                if (result != null) {
                    try {
                        return new String (result , redisCode);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                return "";
            }
        });
    }

    /**
     * 从队列的左边取出一条数据
     *
     * @param key
     *            　列表名
     * @return
     */
    public List<?> lpop(final String key,final int size) {
        List<Object> list =  redisTemplate.executePipelined(new RedisCallback<List<Object>>() {
            public List<Object> doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keyBytes = key.getBytes();
                for(int i =0 ; i< size; i++){
                    connection.lPop(keyBytes);
                }
                return null;
            }
        });
        list.removeAll(Collections.singleton(null));
        return list;
    }

    /**
     * 从列表右边添加数据
     *
     * @param key
     *            列表名
     * @param values
     *            数据
     * @return
     */
    public long rpush(final String key, final String... values) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                long result = 0;
                for (String v : values) {
                    result = connection.rPush(key.getBytes(), v.getBytes());
                }
                return result;
            }
        });
    }

    /**
     * 从列表右边添加数据
     *
     * @param key
     *            列表名
     * @param values
     *            数据
     * @return
     */
    public long rpush(final String key, final Collection<String> values) {
        return redisTemplate.opsForList().rightPushAll(key, values);
    }

    public int hmset(final String key, final Map<String,String> values) {
        try{
            redisTemplate.opsForHash().putAll(key, values);
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0 ;
    }
    public String hget(final String key, final String field){
        Object obj =redisTemplate.opsForHash().get(key, field);
        return String.valueOf(obj);
    }

    public List<?> hkeys(final String key){
        return redisTemplate.execute(new RedisCallback<List<Object>>(){
            List<Object> list = new ArrayList<Object>();
            public List<Object> doInRedis(RedisConnection connection)
                    throws DataAccessException {
                Set<byte[]> sets=connection.hKeys(key.getBytes());
                if(!sets.isEmpty()){
                    for(byte[] b : sets){
                        list.add(redisTemplate.getValueSerializer().deserialize(b).toString());
                    }
                    return list;
                }
                return null;
            }
        });
    }

    /**
     * 删除hash表中field
     */
    public void hdel(final String key,final String field){
        redisTemplate.opsForHash().delete(key, field);
    }
    /**
     * 从列表右边添加数据,并且设置列表的存活时间
     *
     * @param key
     *            列表名
     * @param liveTime
     *            存活时间(单位 秒)
     * @param values
     *            数据
     * @return
     */
    public long rpush(final String key, final int liveTime, final String... values) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                long result = 0;
                for (String v : values) {
                    connection.rPush(key.getBytes(), v.getBytes());
                }
                if (liveTime > 0) {
                    connection.expire(key.getBytes(), liveTime);
                }
                return result;
            }
        });
    }
    /**
     * 从队列的右边取出一条数据
     *
     * @param key
     *            列表名
     * @return
     */
    public String rpop(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] result = connection.rPop(key.getBytes());
                if(result != null ){
                    try {
                        return new String (result, redisCode);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                return "";
            }
        });
    }
    /**
     * 把一个值添加到对应列表中
     *
     * @param key
     *            列表名
     * @param index
     *            　添加的位置
     * @param value
     *            　数据
     * @return
     */
    public String lset(final String key, final long index, final String value) {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.lSet(key.getBytes(), index, value.getBytes());
                return "success";
            }
        });
    }
    /**
     * 把所有数据添加到一个列表中
     *
     * @param key
     *            列表名
     * @param values
     *            　数据
     * @return
     */
    public long lpush(String key, String... values) {
        return this.lpush(key, 0, values);
    }
    /**
     * 把所有数据添加到一个列表中,并且设置列表的存活时间
     *
     * @param key
     *            列表名
     * @param values
     *            数据
     * @param liveTime
     *            存活时间--单位(秒)
     * @return
     */
    public long lpush(final String key,final  int liveTime, final String... values) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                long result = 0;
                for (String v : values){
                    result = connection.lPush(key.getBytes(), v.getBytes());
                }
                if (liveTime > 0) {
                    connection.expire(key.getBytes(), liveTime);
                }
                return result;
            }
        });
    }
    /**
     * 返回列表的长度
     *
     * @param key
     * @return
     */
    public long llen(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.lLen(key.getBytes());
            }
        });
    }
    /**
     * 删除列表中对应值的元素
     *
     * @param key
     *            列表名
     * @param count
     *            删除多少个相同的元素
     * @param value
     *            数据
     * @return
     */
    public long lrem(final String key, final long count, final String value) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.lRem(key.getBytes(), count, value.getBytes());
            }
        });
    }
    /**
     * 通过keys批量删除
     *
     * @param key
     */
    public long del(final String... keys) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                long result = 0;
                for (String k : keys) {
                    result = connection.del(k.getBytes());
                }
                return result;
            }
        });
    }

    /**
     *
     * //DESC 删除单个key
     * @time: 2016年5月27日 上午9:00:36
     * @param key
     * @return
     * @throws
     */
    public long del(final String key){
        return redisTemplate.execute(new RedisCallback<Long>(){
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.del(key.getBytes());
            }

        });
    }


    /**
     * 添加key value 并且设置存活时间(byte)
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(final byte[] key, final byte[] value, final long liveTime) {
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.set(key, value);
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }
                return 1L;
            }
        });

    }
    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime
     *            单位秒
     */
    public void set(String key, String value, long liveTime) {
        this.set(key.getBytes(), value.getBytes(), liveTime);

    }
    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        this.set(key, value, 0L);
    }

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void setMulti(final Map<String,String> map) {
        setMulti(map,0L);
    }

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void setMulti(final Map<String,String> map,final long liveTime) {
        redisTemplate.executePipelined(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                Set<Map.Entry<String, String >> set = map.entrySet();
                for (Map.Entry<String, String> entry : set) {
                    connection.set(entry.getKey().getBytes(), entry.getValue().getBytes());
                    if (liveTime > 0) {
                        connection.expire(entry.getKey().getBytes(), liveTime);
                    }
                }
                return null;
            }
        });
    }
    /**
     * 添加key value (字节)(序列化)
     *
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value) {
        this.set(key, value, 0L);

    }
    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] result = connection.get(key.getBytes());
                if (result != null) {
                    try {
                        return new String (result ,redisCode);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                return "";
            }
        });
    }
    /**
     * 如果key不存在添加key value 并且设置存活时间(byte)，当key已经存在时，就不做任何操作
     *
     * @param key
     * @param value
     * @param liveTime
     */
    @SuppressWarnings("")
    private long setnx(final byte[] key, final byte[] value, final long liveTime) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                long result = 0l;
                boolean isSuccess = connection.setNX(key, value);
                if (isSuccess) {
                    if (liveTime > 0) {
                        connection.expire(key, liveTime);
                    }
                    result = 1l;
                }
                return result;
            }
        });
    }
    /**
     * 如果key不存在添加key value 并且设置存活时间，当key已经存在时，就不做任何操作
     *
     * @param key
     * @param value
     * @param liveTime
     *            单位秒
     */
    public long setnx(String key, String value, long liveTime) {
        return this.setnx(key.getBytes(), value.getBytes(), liveTime);

    }
    /**
     * 如果key不存在添加key value，当key已经存在时，就不做任何操作
     *
     * @param key
     * @param value
     */
    public long setnx(String key, String value) {
        return this.setnx(key, value, 0L);
    }
    /**
     * 如果key不存在添加key value (字节)(序列化)，当key已经存在时，就不做任何操作
     *
     * @param key
     * @param value
     */
    public long setnx(byte[] key, byte[] value) {
        return this.setnx(key, value, 0L);

    }
    /**
     * 通过正则匹配keys
     *
     * @param pattern
     * @return
     */
    public Set<String> keys(final String pattern) {
        return redisTemplate.execute(new RedisCallback<Set<String>>() {
            public Set<String> doInRedis(RedisConnection connection)
                    throws DataAccessException {
                Set<String> result = new HashSet<String>();
                Set<byte[]>   data = connection.keys(pattern.getBytes());
                for(byte[] d : data){
                    try {
                        result.add(new String(d,redisCode));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                return result;
            }
        });
    }
    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.exists(key.getBytes());
            }

        });
    }
    /**
     * 清空redis 所有数据
     *
     * @return
     */
    public String flushDB() {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.flushDb();
                return "success";
            }
        });
    }
    /**
     * 查看redis里有多少数据
     */
    public long dbSize() {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.dbSize();
            }
        });
    }
    /**
     * 检查是否连接成功
     *
     * @return
     */
    public String ping() {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.ping();
            }
        });
    }
    /**
     * 设置key的生命周期
     *
     * @param key
     * @param seconds
     *            单位(秒)
     * @return
     */
    public boolean expire(final String key, final long seconds) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.expire(key.getBytes(), seconds);
            }
        });
    }
    /**
     * 自增长
     *
     * @param key
     * @param length 增长步长
     * @return
     */
    public long incr (final String key){
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.incr(key.getBytes());
            }

        });
    }
    /**
     * 自增长
     *
     * @param key
     * @param length 增长步长
     * @return
     */
    public long incrBy (final String key, final long len){
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.incrBy(key.getBytes(), len);
            }
        });

    }
    /**
     * 自增长
     *
     * @param key
     * @param length 增长步长
     * @return
     */
    public double incrBy (final String key, final double len){
        return redisTemplate.execute(new RedisCallback<Double>() {
            public Double doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.incrBy(key.getBytes(), len);
            }
        });
    }

    public long eval(final String luaCommand) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.eval(luaCommand.getBytes(), null,0);
            }
        });
    }
}
