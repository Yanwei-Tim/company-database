package cy.its.service.imageQuery.cfg.dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

public class DbAccess {
	private Connection conn;
	private Boolean isTransaction = false;

	DbAccess() throws SQLException {
		this.conn = ConnPool.getConnection();
	}

	void beginTransaction() throws SQLException {
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		isTransaction = true;
	}

	/**
	 * ִ����ɾ�Ĳ���
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public int executeNonQuery(String sql, Object... parameters) throws Exception {
		return DbCore.executeNonQuery(this.conn, sql, parameters);
	}

	/**
	 * �б��ѯ
	 * 
	 * @param consumer
	 * @param sql
	 * @param parameters
	 * @throws Exception
	 */
	public void executeReader(Consumer<ResultSet> consumer, String sql, Object... parameters) throws Exception {
		DbCore.executeReader(this.conn, consumer, sql, parameters);
	}
	
	/**
	 * ��ѯ�б�
	 * @param cls
	 * @param sql
	 * @param parameters
	 * @return
	 * @throws Exception 
	 */
	public <T> List<T> executeDataset(Class<T> cls, String sql, Object... parameters) throws Exception
	{
		return DbCore.executeDataset(this.conn, cls, sql, parameters);
	}

	/**
	 * ��ѯ��ֵ
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public Object executeScalar(String sql, Object... parameters) throws Exception {
		return DbCore.executeScalar(this.conn, sql, parameters);
	}

	/**
	 * �ύ
	 * 
	 * @throws SQLException
	 */
	void commit() throws SQLException {
		if (isTransaction) {
			conn.commit();
		}
	}

	/**
	 * �ع�
	 * 
	 * @throws SQLException
	 */
	void rollBack() throws SQLException {
		if (isTransaction) {
			conn.rollback();
		}
	}

	/**
	 * �ر�����
	 * 
	 * @throws SQLException
	 */
	void close() throws SQLException {
		if (this.conn != null) {
			conn.close();
		}
	}
}
