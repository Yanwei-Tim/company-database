package com.zhang.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.zhang.dao.OrderDao;
import com.zhang.entity.Order;
import com.zhang.service.OrderService;

/**
 * ����Serviceʵ����
 * @author Administrator
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderDao orderDao;
	
	@Override
	public List<Order> find(Map<String, Object> map) {
		return orderDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return orderDao.getTotal(map);
	}

	@Override
	public Order findById(Integer id) {
		return orderDao.findById(id);
	}

}
