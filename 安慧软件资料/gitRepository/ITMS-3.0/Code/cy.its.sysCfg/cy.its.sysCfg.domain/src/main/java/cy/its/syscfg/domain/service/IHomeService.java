package cy.its.syscfg.domain.service;

import java.util.List;

import org.springframework.web.servlet.config.VelocityConfigurerBeanDefinitionParser;

import cy.its.syscfg.domain.criteria.DownloadCriteria;
import cy.its.syscfg.domain.criteria.NoticeCriteria;
import cy.its.syscfg.domain.model.home.SysDailyMenu;
import cy.its.syscfg.domain.model.home.SysDownload;
import cy.its.syscfg.domain.model.home.SysNotice;
import cy.its.syscfg.domain.model.home.SysSiteLink;

public interface IHomeService {

	/**
	 * ��ѯ������������������֪ͨ����
	 * 
	 * @param recentMax
	 * @param userId
	 * @param noticeTitle
	 * @param createTimeFrom
	 * @param createTimeTo
	 * @return
	 */
	List<SysNotice> findNotices(NoticeCriteria criteria);

	/**
	 * ����ϵͳ����
	 * 
	 * @param notice
	 * @throws Exception
	 */
	void createSysNotice(SysNotice notice) throws Exception;

	/**
	 * ɾ��ϵͳ����
	 * 
	 * @param noticeId
	 */
	void removeSysNotice(String noticeId);

	/**
	 * ����ϵͳ����
	 * 
	 * @param notice
	 * @throws Exception
	 */
	void updateSysNotice(SysNotice notice) throws Exception;

	/**
	 * ��ѯָ����ϵͳ����
	 * 
	 * @param noticdId
	 * @return
	 * @throws Exception
	 */
	SysNotice sysNoticeOfId(String noticdId) throws Exception;

	/**
	 * ������֪ͨ
	 */
	void sysNoticeChanged();

	/**
	 * �г����е���������
	 * 
	 * @return
	 */
	List<SysDownload> allDownloads();
	
	/**
	 * 
	 * @return
	 */
	List<SysDownload> findDownloads(DownloadCriteria criteria);

	/**
	 * ��ѯָ������������
	 * 
	 * @throws Exception
	 */
	SysDownload downLoadOfId(String downLoadId) throws Exception;

	/**
	 * ��������
	 * 
	 * @param sysDownload
	 */
	void createDownload(SysDownload sysDownload);
	
	/**
	 * ɾ������
	 * @param downloadId
	 */
	void removeDownload(String downloadId);

	/**
	 * ��������
	 * 
	 * @param sysDownload
	 * @throws Exception
	 */
	void updateDownload(SysDownload sysDownload) throws Exception;

	/**
	 * �������ݱ��֪ͨ
	 */
	void downloadChanged();

	/**
	 * ��ȡָ���û��ĳ��ò˵�
	 * 
	 * @param userId
	 * @return
	 */
	List<SysDailyMenu> dailyMenusOfUser(String userId);

	/**
	 * �Ƴ�ָ�����ճ��˵�
	 * 
	 * @param dailyMenuId
	 */
	void removeDailyMenu(String dailyMenuId);

	/**
	 * �����ճ��˵�
	 * 
	 * @param dailyMenu
	 * @throws Exception
	 */
	void createDailyMenu(SysDailyMenu dailyMenu) throws Exception;
	
	/**
	 * �����û���Ȩ�����������ճ��˵�
	 * @param userId
	 */
	void resetUserDailyMenus();

	/**
	 * ��ѯ���еĳ�������
	 * 
	 * @return
	 */
	List<SysSiteLink> allSiteLinks();

	/**
	 * ������������
	 * 
	 * @param siteLink
	 */
	void createSiteLink(SysSiteLink siteLink);

	/**
	 * �Ƴ�ָ���ĳ�������
	 * 
	 * @param linkId
	 */
	void removeSiteLink(String linkId);

	/**
	 * ���³�������
	 * 
	 * @param siteLink
	 * @throws Exception
	 */
	void updateSiteLink(SysSiteLink siteLink) throws Exception;
}
