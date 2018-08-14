package cn.hfl.jk.service;

import java.util.List;
import java.util.Map;

import cn.hfl.jk.domain.Contract;
import cn.hfl.jk.pagination.Page;
import cn.hfl.jk.vo.ContractVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月20日
 */

public interface ContractHisService {
	public List<Contract> findPage(Page page);		//分页查询
	public List<Contract> find(Map paraMap);		//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public ContractVO view(String contractId);		//关联对象的查询一个
	
	public void pigeinhole(String[] contractIds);		//归档
	public void pigeouthole(String[] contractIds);		//取消归档
}
