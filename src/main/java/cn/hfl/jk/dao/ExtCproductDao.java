package cn.hfl.jk.dao;

import java.io.Serializable;

import cn.hfl.jk.domain.ExtCproduct;

public interface ExtCproductDao extends BaseDao<ExtCproduct> {
	public void deleteByContractProductId(Serializable[] ids);
	public void deleteByContractId(Serializable[] ids);
}
