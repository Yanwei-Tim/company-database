package cy.its.sysCfg.rest.action.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cy.its.com.util.ObjectMapUtils;
import cy.its.sysCfg.rest.action.IHomeAction;
import cy.its.sysCfg.rest.dto.DataGridResult;
import cy.its.sysCfg.rest.dto.DownloadDto;
import cy.its.sysCfg.rest.dto.DownloadQryDto;
import cy.its.sysCfg.rest.dto.FastMenuDto;
import cy.its.sysCfg.rest.dto.NoticeDto;
import cy.its.sysCfg.rest.dto.NoticeQryDto;
import cy.its.sysCfg.rest.dto.Results;
import cy.its.syscfg.domain.criteria.DownloadCriteria;
import cy.its.syscfg.domain.criteria.NoticeCriteria;
import cy.its.syscfg.domain.model.home.SysDailyMenu;
import cy.its.syscfg.domain.model.home.SysDownload;
import cy.its.syscfg.domain.model.home.SysNotice;
import cy.its.syscfg.domain.model.permission.Menu;
import cy.its.syscfg.domain.service.IDutyService;
import cy.its.syscfg.domain.service.IHomeService;
import cy.its.syscfg.domain.service.IPermissionService;

@RestController
@RequestMapping("/sysCfg/HomeAction")
public class HomeAction implements IHomeAction {

	@Autowired
	IHomeService homeService;
	@Autowired
	IPermissionService permissionService;
	@Autowired
	IDutyService dutyService;

	/**
	 * ��ѯ֪ͨ������Ϣ
	 * 
	 * @param noticeQryDto
	 * @param request
	 * @return
	 */
	@Override
	@RequestMapping(value = "/queryNotice")
	public DataGridResult<NoticeDto> queryNotice(NoticeQryDto noticeQryDto) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		NoticeCriteria noticeCriteria = new NoticeCriteria();
		noticeCriteria.noticeTitle = noticeQryDto.getTitle();
		if (noticeQryDto.getCreateTimeFr() != null && !noticeQryDto.getCreateTimeFr().equals("")) {
			try {
				noticeCriteria.createTimeFrom = sFormat.parse(noticeQryDto.getCreateTimeFr());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (noticeQryDto.getCreateTimeTo() != null && !noticeQryDto.getCreateTimeTo().equals("")) {
			try {
				noticeCriteria.createTimeTo = sFormat.parse(noticeQryDto.getCreateTimeTo());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		noticeCriteria.userOrgPrivilegeCode = noticeQryDto.getCurrentOrgPrivilegeCode();
		noticeCriteria.setPageNum(noticeQryDto.getPageNumber());
		noticeCriteria.setPageSize(noticeQryDto.getPageSize());
		noticeCriteria.setNeedTotal(true);// �ж��Ƿ�Ҫ����
		List<SysNotice> noticeLst = homeService.findNotices(noticeCriteria);
		long total = noticeCriteria.getTotal();// ��ȡ����
		List<NoticeDto> lst = domainLst2DtoLst(noticeLst);
		Results<NoticeDto> res = new Results<NoticeDto>();
		res.setRows(lst);
		res.setTotal(total);
		DataGridResult<NoticeDto> dgr = new DataGridResult<NoticeDto>();
		dgr.setError("");
		dgr.setResult(res);
		return dgr;
	}

	/**
	 * ��ѯ���µ�5��֪ͨ������Ϣ
	 * 
	 * @param request
	 * @return
	 */
	@Override
	@RequestMapping(value = "/getLatestNoticeLst")
	public List<NoticeDto> getLatestNoticeLst(String currentOrgPrivilegeCode) {
		NoticeCriteria noticeCriteria = new NoticeCriteria();
		noticeCriteria.userOrgPrivilegeCode = currentOrgPrivilegeCode;
		List<SysNotice> noticeLst = homeService.findNotices(noticeCriteria);
		if (noticeLst != null && noticeLst.size() > 5) {
			noticeLst = noticeLst.subList(0, 5);
		}
		return domainLst2DtoLst(noticeLst);
	}

	private List<NoticeDto> domainLst2DtoLst(List<SysNotice> noticeLst) {
		List<NoticeDto> lst = new ArrayList<NoticeDto>();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (noticeLst != null) {
			for (int i = 0; i < noticeLst.size(); i++) {
				NoticeDto noticeDto = new NoticeDto();
				ObjectMapUtils.parseObject(noticeDto, noticeLst.get(i));
				if (noticeLst.get(i).getCreateTime() != null) {
					noticeDto.setCreateTime(sFormat.format(noticeLst.get(i).getCreateTime()));
				}
				if (noticeLst.get(i).getUpdateTime() != null) {
					noticeDto.setUpdateTime(sFormat.format(noticeLst.get(i).getUpdateTime()));
				}
				lst.add(noticeDto);
			}
		}
		return lst;
	}

	@Override
	@RequestMapping(value = "/addNotice")
	public int addNotice(@ModelAttribute("form") NoticeDto form) throws Exception {
		SysNotice sysNotice = new SysNotice();
		ObjectMapUtils.parseObject(sysNotice, form);
		sysNotice.setUserId(form.getCurrentUserId());
		homeService.createSysNotice(sysNotice);
		// homeService.sysNoticeChanged();
		return 1;
	}

	/**
	 * ɾ��֪ͨ��Ϣ
	 */
	@Override
	@RequestMapping(value = "/removeNotice")
	public int removeNotice(@RequestParam("noticeId") String noticeId) {
		homeService.removeSysNotice(noticeId);
		// homeService.sysNoticeChanged();
		return 1;
	}

	/**
	 * �༭֪ͨ��Ϣ
	 * 
	 * @throws Exception
	 */
	@Override
	@RequestMapping(value = "/updateNotice")
	public int updateNotice(@ModelAttribute("form") NoticeDto form) throws Exception {
		SysNotice sysNotice = homeService.sysNoticeOfId(form.getNoticeId());
		sysNotice.setNoticeTitle(form.getNoticeTitle());
		sysNotice.setNoticeContent(form.getNoticeContent());
		homeService.updateSysNotice(sysNotice);
		// homeService.sysNoticeChanged();
		return 1;
	}

	/****** ����ר�� *********************************************************************/
	@Override
	@RequestMapping(value = "/queryDownload")
	public DataGridResult<DownloadDto> queryDownload(DownloadQryDto downloadQryDto) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DownloadCriteria criteria = new DownloadCriteria();
		criteria.title = downloadQryDto.getDownloadTitle();
		if (downloadQryDto.getCreateTimeFr() != null && !downloadQryDto.getCreateTimeFr().equals("")) {
			try {
				criteria.createTimeFrom = sFormat.parse(downloadQryDto.getCreateTimeFr());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (downloadQryDto.getCreateTimeTo() != null && !downloadQryDto.getCreateTimeTo().equals("")) {
			try {
				criteria.createTimeTo = sFormat.parse(downloadQryDto.getCreateTimeTo());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		criteria.setPageNum(downloadQryDto.getPageNumber());
		criteria.setPageSize(downloadQryDto.getPageSize());
		criteria.setNeedTotal(true);// �ж��Ƿ�Ҫ����
		List<SysDownload> downloadLst = homeService.findDownloads(criteria);
		long total = criteria.getTotal();// ��ȡ����
		List<DownloadDto> lst = domainDownloadLst2DtoLst(downloadLst);
		Results<DownloadDto> res = new Results<DownloadDto>();
		res.setRows(lst);
		res.setTotal(total);
		DataGridResult<DownloadDto> dgr = new DataGridResult<DownloadDto>();
		dgr.setError("");
		dgr.setResult(res);
		return dgr;
	}

	/**
	 * ��ѯ���µ�5��֪ͨ������Ϣ
	 * 
	 * @param request
	 * @return
	 */
	@Override
	@RequestMapping(value = "/getLatestDownloadLst")
	public List<DownloadDto> getLatestDownloadLst() {
		List<SysDownload> downloadLst = homeService.allDownloads();
		if (downloadLst != null && downloadLst.size() > 5) {
			downloadLst = downloadLst.subList(0, 5);
		}
		return domainDownloadLst2DtoLst(downloadLst);
	}

	private List<DownloadDto> domainDownloadLst2DtoLst(List<SysDownload> sysDownloads) {
		List<DownloadDto> lst = new ArrayList<DownloadDto>();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (sysDownloads != null) {
			for (int i = 0; i < sysDownloads.size(); i++) {
				DownloadDto downloadDto = new DownloadDto();
				ObjectMapUtils.parseObject(downloadDto, sysDownloads.get(i));
				if (sysDownloads.get(i).getCreateTime() != null) {
					downloadDto.setCreateTime(sFormat.format(sysDownloads.get(i).getCreateTime()));
				}
				if (sysDownloads.get(i).getUpdateTime() != null) {
					downloadDto.setUpdateTime(sFormat.format(sysDownloads.get(i).getUpdateTime()));
				}
				lst.add(downloadDto);
			}
		}
		return lst;
	}

	/**
	 * ��������
	 */
	@Override
	@RequestMapping(value = "/addDownload")
	public int addDownload(@ModelAttribute("form") DownloadDto form) throws Exception {
		// ���浽���ݿ�
		SysDownload sysDownload = new SysDownload();
		ObjectMapUtils.parseObject(sysDownload, form);
		homeService.createDownload(sysDownload);
		// ֪ͨ����
		// homeService.downloadChanged();
		return 1;
	}

	/**
	 * ɾ��������Ϣ
	 */
	@Override
	@RequestMapping(value = "/removeDownload")
	public int removeDownload(@RequestParam("downloadId") String downloadId) {
		homeService.removeDownload(downloadId);
		// homeService.sysNoticeChanged();
		return 1;
	}

	/**
	 * �༭������Ϣ
	 * 
	 * @throws Exception
	 */
	@Override
	@RequestMapping(value = "/updateDownload")
	public int updateDownload(@ModelAttribute("form") DownloadDto form) throws Exception {
		// ���浽���ݿ�
		SysDownload sysDownload = homeService.downLoadOfId(form.getDownloadId());
		sysDownload.setDownloadTitle(form.getDownloadTitle());
		sysDownload.setDownloadContent(form.getDownloadContent());
		sysDownload.setDownloadUrl(form.getDownloadUrl());
		homeService.updateDownload(sysDownload);
		// ֪ͨ����
		// homeService.downloadChanged();
		return 1;
	}

	@Override
	@RequestMapping(value = "/getUserMenu")
	public List<FastMenuDto> getUserMenu(String currentUserId) {
		List<FastMenuDto> fastMenuDtos = new ArrayList<FastMenuDto>();
		List<Menu> userMenus = permissionService.menusOfUser(currentUserId);
		if (userMenus == null || userMenus.size() == 0) {
			return fastMenuDtos;
		}
		List<Menu> userFirstLevelMenus = userMenus.stream().filter(p -> p.getMenuCode().length() == 2)
				.collect(Collectors.toList());
		if (userFirstLevelMenus == null || userFirstLevelMenus.size() == 0) {
			return fastMenuDtos;
		}
		for (int i = 0; i < userFirstLevelMenus.size(); i++) {
			FastMenuDto fastMenuDto = createFastMenuDto(userFirstLevelMenus.get(i));
			String mc = userFirstLevelMenus.get(i).getMenuCode();

			List<Menu> userThirdLevelMenus = userMenus.stream()
					.filter(p -> p.getMenuCode().length() == 6 && p.getMenuCode().startsWith(mc))
					.collect(Collectors.toList());
			if (userThirdLevelMenus != null && userThirdLevelMenus.size() > 0) {
				List<FastMenuDto> thirdFastMenuDtos = new ArrayList<FastMenuDto>();
				for (int j = 0; j < userThirdLevelMenus.size(); j++) {
					FastMenuDto thirdFastMenuDto = createFastMenuDto(userThirdLevelMenus.get(j));
					thirdFastMenuDtos.add(thirdFastMenuDto);
				}
				fastMenuDto.setSonMenus(thirdFastMenuDtos);
			}
			fastMenuDtos.add(fastMenuDto);
		}
		return fastMenuDtos;
	}

	private FastMenuDto createFastMenuDto(Menu menu) {
		FastMenuDto fastMenuDto = new FastMenuDto();
		String mc = menu.getMenuCode();
		fastMenuDto.setMenuCode(mc);
		fastMenuDto.setMenuName(menu.getMenuName());
		fastMenuDto.setTargetUrl(menu.getTargetUrl());
		return fastMenuDto;
	}
	
	@Override
	@RequestMapping(value = "/getUserFastMenu")
	public List<FastMenuDto> getUserFastMenu(String currentUserId) {
		List<FastMenuDto> fastMenuDtos = new ArrayList<FastMenuDto>();
		List<SysDailyMenu> userDailyMenus = homeService.dailyMenusOfUser(currentUserId);
		if (userDailyMenus == null || userDailyMenus.size() == 0) {
			return fastMenuDtos;
		}
		List<Menu> userMenus = permissionService.menusOfUser(currentUserId);
		for(int i=0;i<userDailyMenus.size();i++)
		{
			String menuCode = userDailyMenus.get(i).getMenuCode();
			FastMenuDto fastMenuDto = createFastMenuDto(getMenuByCode(userMenus,menuCode));
			fastMenuDto.setDailyMenuId(userDailyMenus.get(i).getDailyMenuId());
			fastMenuDtos.add(fastMenuDto);
		}
		return fastMenuDtos;
	}
	
	private Menu getMenuByCode(List<Menu> userMenus,String memuCode) {
		Menu menu=new Menu();
		if(userMenus!=null&&userMenus.size()>0)
		{
			List<Menu> menus = userMenus.stream().filter(p->p.getMenuCode().equals(memuCode)).collect(Collectors.toList());
			menu=menus.get(0);
		}
		return menu;
	}
	

    @Override
	@RequestMapping(value = "/saveUserFastMenu")
	public void saveUserFastMenu(String userId, String oldMenus, String newMenus) throws Exception {
		JSONArray oldMenusArry = JSONObject.parseArray(oldMenus);
		JSONArray newMenusArry = JSONObject.parseArray(newMenus);
		// ���û�оɲ˵�����ȫ���¼�
		if (oldMenusArry == null || oldMenusArry.size() == 0) {
			// ����²˵���Ϊ�գ���ȫ���¼�
			if (newMenusArry != null && newMenusArry.size() > 0) {
				createDailyMenus(userId, newMenusArry);
			}
		} else {
			// �µĲ˵�Ϊ�գ���ȫ��ɾ��
			if (newMenusArry == null || newMenusArry.size() == 0) {
				removeDailyMenus(oldMenusArry);
			} else// ���оɲ˵��������²˵�
			{
				Map<String, String> oldMenuMp=buildOldMenuMp(oldMenusArry);
				List<String> oldMenuCodes = new ArrayList<String>(oldMenuMp.keySet());
				createNewDailyMenus(userId,oldMenuCodes,newMenusArry);
				removeOldDailyMenus(oldMenuMp,newMenusArry);
			}
		}
	}

	/**
	 * �����ɲ˵�map,keyΪmenuCode��valueΪ�˵�dailyMenuId
	 * 
	 * @param oldMenusArry
	 * @return
	 */
	private Map<String, String> buildOldMenuMp(JSONArray oldMenusArry) {
		Map<String, String> oldMenuMp = new HashMap<String, String>();
		for (Object object : oldMenusArry) {
			JSONObject obj = (JSONObject) object;
			String dailyMenuId = obj.getString("dailyMenuId");
			String menuCode = obj.getString("menuCode");
			oldMenuMp.put(menuCode, dailyMenuId);
		}
		return oldMenuMp;
	}

	/**
	 * �����²˵���Ҫ�ж��ھɲ˵����пɴ��ڣ�������pass��������������
	 * 
	 * @param userId
	 * @param oldMenus
	 * @param newMenusArry
	 * @throws Exception
	 */
	private void createNewDailyMenus(String userId, List<String> oldMenus, JSONArray newMenusArry) throws Exception {
		for (Object object : newMenusArry) {
			String newMenu = object.toString();
			if (!oldMenus.contains(newMenu)) {
				createDailyMenu(userId, newMenu);
			}
		}
	}

	private void removeOldDailyMenus(Map<String, String> oldMenus, JSONArray newMenusArry) throws Exception {
		List<String> oldMenuCodes = new ArrayList<String>(oldMenus.keySet());
		for (String str : oldMenuCodes) {
           if(!newMenusArry.contains(str))
           {
        	   removeDailyMenu(oldMenus.get(str));
           }
		}
	}

	private void createDailyMenus(String userId, JSONArray newMenusArry) throws Exception {
		for (Object object : newMenusArry) {
			createDailyMenu(userId, object.toString());
		}
	}

	private void createDailyMenu(String userId, String menuCode) throws Exception {
		SysDailyMenu sysDailyMenu = new SysDailyMenu();
		sysDailyMenu.setMenuCode(menuCode);
		sysDailyMenu.setUserId(userId);
		homeService.createDailyMenu(sysDailyMenu);
	}

	private void removeDailyMenus(JSONArray oldMenusArry) throws Exception {
		for (Object object : oldMenusArry) {
			JSONObject obj = (JSONObject) object;
			String dailyMenuId = obj.getString("dailyMenuId");
			removeDailyMenu(dailyMenuId);
		}
	}

	private void removeDailyMenu(String dailyMenuId) {
		homeService.removeDailyMenu(dailyMenuId);
	}
	/**
	 * ��ѯ���û����µ�¼����
	 * @param userId
	 * @return
	 */
	@Override
	@RequestMapping(value = "/loginCountCurMonthOfUser")
	public int loginCountCurMonthOfUser(String currentUserId){
		return dutyService.loginCountCurMonthOfUser(currentUserId);
	}
	
	
	/**
	 * ��ѯָ���û���ע�������ܵĵ�½����
	 * @param userId
	 * @return
	 */
	@Override
	@RequestMapping(value = "/loginTotalOfUser")
	public int loginTotalOfUser(String currentUserId){
		return dutyService.loginTotalOfUser(currentUserId);
	}
	
	/**
	 * ��ѯ�û��ĵ�¼���ͳ����Ϣ
	 */
	@Override
	@RequestMapping(value = "/getLoginTotalOfUser")
	public Map getLoginTotalOfUser(String currentUserId) {
		Map map=new HashMap();
		int loginCountCurMonth = dutyService.loginCountCurMonthOfUser(currentUserId);
		int loginTotal = dutyService.loginTotalOfUser(currentUserId);
		map.put("loginCountCurMonth", loginCountCurMonth);
		map.put("loginTotal", loginTotal);
		return map;
	}

}
