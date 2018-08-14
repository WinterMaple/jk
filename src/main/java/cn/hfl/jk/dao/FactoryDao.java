package cn.hfl.jk.dao;

import java.util.Map;

import cn.hfl.jk.domain.Factory;

public interface FactoryDao extends BaseDao<Factory> {
	public void updateState(Map map);
}
