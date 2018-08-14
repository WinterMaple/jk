package cn.hfl.jk.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cn.hfl.jk.dao.ExtCproductDao;
import cn.hfl.jk.domain.ExtCproduct;

@Repository
public class ExtCproductDaoImpl extends BaseDaoImpl<ExtCproduct> implements ExtCproductDao {

	//设置命名空间
	public ExtCproductDaoImpl() {
		super.setNs("cn.hfl.jk.mapper.ExtCproductMapper");
	}

	@Override
	public void deleteByContractProductId(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractProductId",ids);
	}

	@Override
	public void deleteByContractId(Serializable[] contractIds) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractId",contractIds);
	}
}
