package cn.hfl.jk.dao;

import cn.hfl.jk.domain.Contract;
import cn.hfl.jk.vo.ContractVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface ContractHisDao extends BaseDao<Contract> {
	public ContractVO view(String contractId);	//查询某个合同
}
