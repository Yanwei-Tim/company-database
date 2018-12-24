package cy.its.service.imageQuery.cfg.dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.Consumer;

public final class DbExecuter {

	/**
	 * ִ����ɾ�Ĳ���
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public static int executeNonQuery(String sql, Object... parameters) throws Exception {
		Connection conn = null;
		try {
			conn = ConnPool.getConnection();
			return DbCore.executeNonQuery(conn, sql, parameters);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * �б��ѯ
	 * 
	 * @param consumer
	 * @param sql
	 * @param parameters
	 * @throws Exception
	 */
	public static void executeReader(Consumer<ResultSet> consumer, String sql, Object... parameters) throws Exception {
		Connection conn = null;
		try {
			conn = ConnPool.getConnection();
			DbCore.executeReader(conn, consumer, sql, parameters);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * �б��ѯ
	 * 
	 * @param cls
	 * @param sql
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> executeDataset(Class<T> cls, String sql, Object... parameters) throws Exception {
		Connection conn = null;
		try {
			conn = ConnPool.getConnection();
			return DbCore.executeDataset(conn, cls, sql, parameters);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * ��ѯ��ֵ
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public static Object executeScalar(String sql, Object... parameters) throws Exception {
		Connection conn = null;
		try {
			conn = ConnPool.getConnection();
			return DbCore.executeScalar(conn, sql, parameters);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * ��������
	 * 
	 * @param sql
	 * @param paramsList
	 * @throws Exception
	 */
	public static void batchInsert(String sql, List<List<Object>> paramsList) throws Exception {
		Connection conn = null;
		try {
			conn = ConnPool.getConnection();
			DbCore.batchNonQuery(conn, sql, paramsList);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public static void singleInsert(String sql, List<Object> params) throws Exception {
		Connection conn = null;
		try {
			conn = ConnPool.getConnection();
			DbCore.singleNonQuery(conn, sql, params);
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * �Զ��崦��:һ�����Ӷ�η������ݿ�
	 * 
	 * @param custom
	 * @throws Exception
	 */
	public static void customNonQuerys(Action<DbAccess> custom) throws Exception {
		DbAccess dbAccess = null;
		try {
			dbAccess = new DbAccess();
			custom.accept(dbAccess);
		} catch (Exception e) {
			throw e;
		} finally {
			if (dbAccess != null) {
				dbAccess.close();
			}
		}
	}

	/**
	 * �Զ��崦��:һ�����Ӷ�δ���,����ͬһ������
	 * 
	 * @param sql
	 * @param paramsList
	 * @throws Exception
	 */
	public static void customTransNonQuerys(Action<DbAccess> custom) throws Exception {
		DbAccess dbAccess = null;
		try {
			dbAccess = new DbAccess();
			dbAccess.beginTransaction();
			custom.accept(dbAccess);
			dbAccess.commit();
		} catch (Exception e) {
			if (dbAccess != null) {
				dbAccess.rollBack();
			}
			throw e;
		} finally {
			if (dbAccess != null) {
				dbAccess.close();
			}
		}
	}
}
