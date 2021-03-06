package ah.its.wrokflow.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.ApproveChk;
import ah.its.wrokflow.repository.dao.SysApprove;

/**
 * 申请单业务处理类 
 * @Title: SystemApproveServiceI.java
 * @Package ah.its.wrokflow.domain
 * @Description: TODO(这里要填写用途)
 * @author chengf chengf@cychina.cn
 * @date 2016年6月13日 下午5:54:25
 * @version V1.0
 */
public interface SysApproveServiceI {
	
	/**
	 * 保存系统申请单
	 * @Description:描述
	 * @param @param 
	 * @return Map    返回类型 
	 * @throws
	 */
	public  int  saveSystemApprove(SysApprove record);
	
	/**
	 * 流程实例ID，更新到申请单中
	 * @Description:描述
	 * @param @param 
	 * @return Map    返回类型 
	 * @throws
	 */
	public  int  updateSystemApprove(SysApprove record);
	
	/**
	 * 查询申请单
	 * @Description:描述
	 * @param @param 
	 * @return Map    返回类型 
	 * @throws
	 */
	public  List<SysApprove>  selectAllData(Map map);
	
	/**
	 * 删除申请单
	 * @Description:描述
	 * @param @param 
	 * @return Map    返回类型 
	 * @throws
	 */
	public  int  deleteSystemApprove(Map map);
	
	/**
	 * 根据id查找申请单
	 * @Description:描述
	 * @param @param 
	 * @return Map    返回类型 
	 * @throws
	 */
	public SysApprove querySystemApproveById(String approveId);

	/**
	 * 系统申请历史查询
	 * @Description:描述
	 * @param @param 
	 * @return Map    返回类型 
	 * @throws
	 */
	public List<SysApprove> querySystemApproveHistory(Map map);

	/**
	 *  查询与当前申请单相关的审批意见及审批单位和经办人
	 * @Description:描述
	 * @param @param 
	 * @return Map    返回类型 
	 * @throws
	 */
	public List<ApproveChk> querySystemApproveHistoryDetail(String approveId);

}
