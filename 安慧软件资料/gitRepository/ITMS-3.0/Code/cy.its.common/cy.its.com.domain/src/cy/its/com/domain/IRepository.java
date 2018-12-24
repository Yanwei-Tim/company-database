package cy.its.com.domain;

public interface IRepository<T> {
	
	public T aggregateOfId(String id) throws Exception;
	
	/**
	 * ���ش洢�����ɵ�����ID
	 * @param obj
	 * @return
	 */
	public String save(T obj);
	
	public int delete(String id);
	
	public int update(T obj);
	
	
	
}