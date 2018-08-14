package cn.hfl.jk.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cn.hfl.jk.dao.ContractProductDao;
import cn.hfl.jk.domain.ContractProduct;

@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {

	//设置命名空间
	public ContractProductDaoImpl() {
		super.setNs("cn.hfl.jk.mapper.ContractProductMapper");
	}

	@Override
	public void deleteByContractId(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractId",ids);
	}
}
