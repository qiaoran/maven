package org.redis.common;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * @author joy-pc
 *
 */
public class RedisClientPool implements InitializingBean,DisposableBean {

    //Redis服务器IP
    private  String url = "192.168.0.100";

    //Redis的端口号
    private  int port = 6379;

    //访问密码private static String AUTH = "admin";
    private  String AUTH = "admin";
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private  int MAX_ACTIVE = 100;
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private  int MAX_IDLE = 200;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private  int MAX_WAIT = 10000;

    private  int TIMEOUT = 10000;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private  boolean TEST_ON_BORROW = true;

    private  JedisPool jedisPool = null;


    public RedisClientPool(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public void afterPropertiesSet() throws Exception {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWait(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, url, port, TIMEOUT, (String)null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取Jedis实例
     *
     * @return
     */
    public synchronized  Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    public  void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }



    public void destroy(){
        jedisPool.destroy();
    }

    public String getAUTH() {
        return AUTH;
    }

    public void setAUTH(String AUTH) {
        this.AUTH = AUTH;
    }

    public  int getMaxActive() {
        return MAX_ACTIVE;
    }

    public  void setMaxActive(int maxActive) {
        MAX_ACTIVE = maxActive;
    }

    public int getMAX_IDLE() {
        return MAX_IDLE;
    }

    public void setMAX_IDLE(int MAX_IDLE) {
        this.MAX_IDLE = MAX_IDLE;
    }

    public int getMAX_WAIT() {
        return MAX_WAIT;
    }

    public void setMAX_WAIT(int MAX_WAIT) {
        this.MAX_WAIT = MAX_WAIT;
    }

    public int getTIMEOUT() {
        return TIMEOUT;
    }

    public void setTIMEOUT(int TIMEOUT) {
        this.TIMEOUT = TIMEOUT;
    }
}
