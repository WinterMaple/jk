package cn.hfl.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.hfl.jk.dao.ContractDao;
import cn.hfl.jk.domain.Contract;
import cn.hfl.jk.vo.ContractVO;

@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {

	//设置命名空间
	public ContractDaoImpl() {
		super.setNs("cn.hfl.jk.mapper.ContractMapper");
	}

	@Override
	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}

	@Override
	public ContractVO view(String contractId) {
		return super.getSqlSession().selectOne(super.getNs()+".view", contractId);
	}

}
