package cn.hfl.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.hfl.jk.dao.FactoryDao;
import cn.hfl.jk.domain.Factory;

@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {

	public FactoryDaoImpl() {
		super.setNs("cn.hfl.jk.mapper.FactoryMapper");
	}

	@Override
	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}
}
