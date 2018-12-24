package ah.its.workFlow.util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
* @Title: DBUtil.java 
* @Package ah.its.workFlow.util 
* @Description: �Զ���SQLȡ���ݵķ���
* @author lil@cychina.cn
* @date 2016��4��8�� ����10:22:24 
* @version V1.0   
 */
public class DBUtil {

	/** 
	* @Title: queryData 
	* @Description: ���ݴ����SQL��ȡ���� 
	* @param @param sql
	* @param @param dataSource
	* @param @return    �趨�ļ� 
	* @return List    �������� 
	* @throws 
	*/
	public static List queryData(String sql, DataSource dataSource) {
		List  list =null;
		Connection conn = null; //��ʾ���ݿ�����Ӷ���  
	    Statement  stmt = null;   
	    ResultSet  rs = null; //��ʾ�������ݿ�Ĳ�ѯ���
		try {
			conn=openConnect(dataSource);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list = createList(rs,"ah.its.workFlow.util.CacheDao");
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close(); //�����쳣�ر�����
				}
				if(stmt!=null){
					stmt.close();//�����쳣�ر�����
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}


	/**
	 * @throws SQLException  
	* @Title: createList 
	* @Description: ��װLIST OBJ
	* @param @param rs
	* @param @param string
	* @param @return    �趨�ļ� 
	* @return List    �������� 
	* @throws 
	*/
	private static List createList(ResultSet rs, String className) throws SQLException {
		List list  = new ArrayList();
		while(rs.next()){
		    Class<?> object=null;
		    Object objInstance=null;
	        try{
	        	object=Class.forName(className);
	        	objInstance=object.newInstance();
	        	Method setMethod =	 object.getDeclaredMethod("setProperty",new Class[]{String[].class});
	        	if(rs.getMetaData().getColumnCount()==4){
	        		String[]  args = new String[4];
	        		args[0] =rs.getString(1);
	        		args[1] =rs.getString(2);
	        		args[2] =rs.getString(3);
	        		args[3] =rs.getString(4);
	        		setMethod.invoke(objInstance,new Object[]{args});
	        	}else if(rs.getMetaData().getColumnCount()==3){
	        		String[]  args = new String[3];
	        		args[0] =rs.getString(1);
	        		args[1] =rs.getString(2);
	        		args[2] =rs.getString(3);
	        		setMethod.invoke(objInstance,new Object[]{args});
	        	}else {
	        		String[]  args = new String[2];
	        		args[0] =rs.getString(1);
	        		args[1] =rs.getString(2);
	        		setMethod.invoke(objInstance, new Object[]{args});
				}
	            list.add(objInstance);
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		return list;
	}
	/**
	 * @throws SQLException  
	* @Title: openConnect 
	* @Description: �����ݿ����� 
	* @param @param dataSource
	* @param @return    �趨�ļ� 
	* @return Connection    �������� 
	* @throws 
	*/
	private static Connection openConnect(DataSource dataSource) throws SQLException {
		// TODO Auto-generated method stub
		return dataSource.getConnection();
	}

}
