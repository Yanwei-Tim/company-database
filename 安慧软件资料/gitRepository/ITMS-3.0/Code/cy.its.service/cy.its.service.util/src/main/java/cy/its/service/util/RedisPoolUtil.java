package cy.its.service.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
* @Title: RedisConfig.java 
* @Package cy.its.service.surveillance.util 
* @Description: redis����������ӳ�
* @author lil@cychina.cn
* @date 2015��10��20�� ����6:34:19 
* @version V1.0   
 */
public class RedisPoolUtil {
	
	   private static  Logger log=Logger.getLogger(RedisPoolUtil.class);
	   //����ֵ
	   private  static   String  propertity="";
	   //�����ļ�·��
	   private  static   String  resource="";
	   
	   //����ʱ��
	   private static int timeOut = 10000;
	   //IP ��ַ
	   private  static   String  ip;
	   
	   //����˿ں�
	   private  static   int    port;
	   //����
	   private  static   String  pwd;
	   
	   //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������MaxTotal��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��  
	   private  static   int  maxTotal;
	   //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����  
	   private  static   int  maxIdle;
	   //��ʾ��borrow(����)һ��jedisʵ��ʱ�����ĵȴ�ʱ�䣬��������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException�� 
	   private  static   int  maxWaitMillis;
	   //��ǰ��ʵ���±� 
	   public  static   int  index;
	   
	   private static JedisPool  pool = null;  
	   
	   private RedisPoolUtil(){}
	   
	   private RedisPoolUtil(String  propertity1,String  resource1){
		   propertity=propertity1;
		   resource=resource1;
		   //��ʼ����������Ϣ
		   try {
			  initAllProperties();
			} catch (IOException e) {
				log.error("redis���ӳس�ʼ���쳣�����������ļ���");
				e.printStackTrace();
			}
	   }
	   
	   
	 /**
	 * @throws IOException 
	 * @throws FileNotFoundException  
	* @Title: initAllProperties 
	* @Description: ��ʼ��������Ϣ
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private static  void initAllProperties() throws IOException {
		OrderedProperties prop = new OrderedProperties();//���Լ��϶��� 
		InputStream fis =  new FileInputStream(resource);
		prop.load(fis);// �������ļ���װ�ص�Properties������ 
		fis.close();// �ر��� 
		ip = prop.getProperty("redis.ip");
		port = Integer.valueOf(prop.getProperty("redis.port"));
		maxTotal =  Integer.valueOf(prop.getProperty("redis.maxTotal"));
		pwd = prop.getProperty("redis.pwd");
		maxIdle =  Integer.valueOf(prop.getProperty("redis.maxIdle"));
		maxWaitMillis =  Integer.valueOf(prop.getProperty("redis.maxWaitMillis"));
	}
	/** 
	     * ����redis���ӳ� 
	     *  
	     * @param ip 
	     * @param port 
	     * @return JedisPool 
	     */  
	    public static JedisPool getPool() {  
	        if (pool == null) {  
	            JedisPoolConfig config = new JedisPoolConfig();
	            config.setMaxTotal(10);  
	            config.setMaxIdle(maxIdle);  
	            config.setMaxWaitMillis(maxWaitMillis*100);  
	            //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�  
	            config.setTestOnBorrow(true);  
	            pool = new JedisPool(config, ip, port,timeOut,pwd);  
	        }  
	        return pool;  
	    }  
	    /** 
	     * ���������ӳ� 
	     * @param pool  
	     * @param redis 
	     */  
	    public static void returnResource(JedisPool pool, Jedis redis) {  
	        if (redis != null) {  
	            pool.returnResource(redis);  
	        }  
	    } 
	    /** 
	     * ��ȡ���� 
	     * @param key 
	     * @return 
	     */  
	    public static String get(String key){  
	        String value = null;  
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();
	            jedis.flushAll();
	            jedis.select(index);
	            value = jedis.get(key);  
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	        return value;  
	    }  
	    
	    /** 
	     * ��ȡ���� 
	     * @param key 
	     * @return 
	     */  
	    public static long pttl(String key){  
	    	long value = -1;  
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            value= jedis.pttl(key);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	        return value;  
	    }  
	    
	    /** 
	     * ��ȡ���� 
	     * @param key 
	     * @return 
	     */  
	    public static String hget(String key,String filed){  
	        String value = "";  
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            value= jedis.hget(key,filed); 
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	        return value;  
	    }  
	    
	    /** 
	     * @param key 
	     * @return 
	     */  
	    public static void hdel(String key,String filed){  
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	           jedis.hdel(key,filed); 
	        } catch (Exception e) {  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	    }  
	    
	    
	    /** 
	     * ��ȡ���� 
	     * @param key 
	     * @return 
	     */  
	    public static boolean hexists(String key,String filed){  
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            return jedis.hexists(key,filed);  
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	        return false;  
	    }  
	    
	    /** 
	     * д������
	     * @param key 
	     * @return 
	     */  
	    public static void put(String key,String jsonString){  
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            jedis.set(key, jsonString);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	    }
	    
	    /** 
	     * д������
	     * @param key 
	     * @return 
	     */  
	    public static void lpush(String key,String jsonString){  
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            jedis.lpush(key, jsonString);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	    }
	    
	    
	    /** 
	     * ɾ������
	     * @param key 
	     * @return 
	     */  
	    public static void lrem(String key,int index,String value){  
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            jedis.lrem(key, index, value);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	    }
	    
	    /** 
	    * @Title: lranage 
	    * @Description:  ȡLIST����
	    * @param @param key
	    * @param @param firstIndex
	    * @param @param lastIndex
	    * @param @return    �趨�ļ� 
	    * @return List<String>    �������� 
	    * @throws 
	    */
	    public static List<String> lranage(String key,int firstIndex,int lastIndex){  
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        List<String>  str  = null;
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            str = jedis.lrange(key,firstIndex,lastIndex);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	        return str;
	    }
	    
	    
	    /** 
	    * @Title: expire 
	    * @Description: ��ĳһ��KEY���ù���ʱ��
	    * @param @param key
	    * @param @param seconds    �趨�ļ� 
	    * @return void    �������� 
	    * @throws 
	    */
	    public static void expire(String key,int seconds){ 
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            jedis.expire(key,seconds);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	    }
	    
	    /** 
	    * @Title: keys 
	    * @Description: ģ������
	    * @param @param pattern
	    * @param @return    �趨�ļ� 
	    * @return Set<String>    �������� 
	    * @throws 
	    */
	    public static Set<String> keys(String pattern){ 
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        Set<String> sets =  null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            sets = jedis.keys(pattern);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        } 
	        return sets;
	    }
	    
	    
	    /** 
	    * @Title: putExpire 
	    * @Description: д�������ʱ������� 
	    * @param @param key
	    * @param @param jsonString
	    * @param @param seconds ʱ�䵥λ�� 
	    * @return void    �������� 
	    * @throws 
	    */
	    public static void putExpire(String key,String jsonString,int seconds){ 
	        JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            jedis.set(key, jsonString);
	            jedis.expire(key,seconds);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	    }

		/**
		 * @return  
		* @Title: exists 
		* @Description: �ж������Ƿ���ڴ���KEY 
		* @param @param string    �趨�ļ� 
		* @return void    �������� 
		* @throws 
		*/
		public static Boolean exists(String key) {
			JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            return jedis.exists(key);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }  
	        return false;
		}

		/** 
		* @Title: hset 
		* @Description: TODO(������һ�仰�����������������) 
		* @param @param dataKey
		* @param @param filed    �趨�ļ� 
		* @return void    �������� 
		* @throws 
		*/
		public static void hset(String key, String filed,String value) {
			 JedisPool pool = null;  
		        Jedis jedis = null;  
		        try {  
		            pool = getPool();  
		            jedis = pool.getResource();  
		            jedis.select(index);
		            jedis.hset(key,filed, value);
		        } catch (Exception e) {  
		            //�ͷ�redis����  
		        	log.error("�ͷ�redis����");
		            pool.returnBrokenResource(jedis);  
		            e.printStackTrace();  
		        } finally {  
		            //���������ӳ�  
		            returnResource(pool, jedis);  
		        }  
		}
		
		/** 
		* @Title: hkeys 
		* @Description: map����
		* @param @param key    �趨�ļ� 
		* @return void    �������� 
		* @throws 
		*/
		public static Set<String> hkeys(String key) {
			JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            return jedis.hkeys(key);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }
			return null;  
		}

		/** 
		* @Title: del 
		* @Description: ���ݴ����key ɾ��������Ϣ
		* @param @param key    �趨�ļ� 
		* @return void    �������� 
		* @throws 
		*/
		public static void del(String key) {
			JedisPool pool = null;  
	        Jedis jedis = null;  
	        try {  
	            pool = getPool();  
	            jedis = pool.getResource();  
	            jedis.select(index);
	            jedis.del(key);
	        } catch (Exception e) {  
	            //�ͷ�redis����  
	        	log.error("�ͷ�redis����");
	            pool.returnBrokenResource(jedis);  
	            e.printStackTrace();  
	        } finally {  
	            //���������ӳ�  
	            returnResource(pool, jedis);  
	        }
		}  
}