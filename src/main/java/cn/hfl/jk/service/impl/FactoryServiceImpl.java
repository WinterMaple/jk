package cn.hfl.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hfl.jk.dao.FactoryDao;
import cn.hfl.jk.domain.Factory;
import cn.hfl.jk.pagination.Page;
import cn.hfl.jk.service.FactoryService;

@Service
public class FactoryServiceImpl implements FactoryService {
	@Autowired
	FactoryDao factoryDao;
	
	@Override
	public List<Factory> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factory> find(Map paraMap) {
		return factoryDao.find(paraMap);
	}

	@Override
	public Factory get(Serializable id) {
		return factoryDao.get(id);
	}

	@Override
	public void insert(Factory factory) {
		factory.setId(UUID.randomUUID().toString());
		factory.setState("1");
		factoryDao.insert(factory);
	}

	@Override
	public void update(Factory factory) {
		factoryDao.update(factory);
	}

	@Override
	public void deleteById(Serializable id) {
		factoryDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		factoryDao.delete(ids);	
	}

	@Override
	public void start(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 1);
		map.put("ids", ids);
		factoryDao.updateState(map);
	}

	@Override
	public void stop(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 0);
		map.put("ids", ids);
		factoryDao.updateState(map);
	}

	@Override
	public List<Factory> getFactoryList() {
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("state", 1);
		
		return factoryDao.find(paraMap);
	}

}
