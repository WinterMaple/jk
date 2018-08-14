package cn.hfl.jk.dao;

import java.io.Serializable;

import cn.hfl.jk.domain.ContractProduct;

public interface ContractProductDao extends BaseDao<ContractProduct> {
	public void deleteByContractId(Serializable[] ids);
}
