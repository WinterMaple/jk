package cn.hfl.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.hfl.jk.dao.ContractHisDao;
import cn.hfl.jk.domain.Contract;
import cn.hfl.jk.vo.ContractVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class ContractHisDaoImpl extends BaseDaoImpl<Contract> implements ContractHisDao{
	public ContractHisDaoImpl() {
		//设置命名空间
		super.setNs("cn.hfl.jk.mapper.ContractHisMapper");
	}

	public ContractVO view(String contractId) {
		return super.getSqlSession().selectOne(super.getNs()+".view", contractId);
	}
}
