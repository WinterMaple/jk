package cn.hfl.jk.dao;

import java.util.Map;

import cn.hfl.jk.domain.Contract;
import cn.hfl.jk.vo.ContractVO;

public interface ContractDao extends BaseDao<Contract> {
	public void updateState(Map map);			//修改状态
	public ContractVO view(String contractId);	//查询某个合同
}
