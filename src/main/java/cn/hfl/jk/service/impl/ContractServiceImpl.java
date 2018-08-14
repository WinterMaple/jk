package cn.hfl.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hfl.jk.dao.ContractDao;
import cn.hfl.jk.dao.ContractProductDao;
import cn.hfl.jk.dao.ExtCproductDao;
import cn.hfl.jk.domain.Contract;
import cn.hfl.jk.pagination.Page;
import cn.hfl.jk.service.ContractService;
import cn.hfl.jk.vo.ContractVO;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	ContractDao contractDao;
	@Autowired
	ContractProductDao contractProductDao;
	@Autowired
	ExtCproductDao extCproductDao;
	
	@Override
	public List<Contract> findPage(Page page) {
		return contractDao.findPage(page);
	}

	@Override
	public List<Contract> find(Map paraMap) {
		return contractDao.find(paraMap);
	}

	@Override
	public Contract get(Serializable id) {
		return contractDao.get(id);
	}

	@Override
	public void insert(Contract contract) {
		contract.setId(UUID.randomUUID().toString());
		contract.setState(0);
		contractDao.insert(contract);
	}

	@Override
	public void update(Contract contract) {
		contractDao.update(contract);
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCproductDao.deleteByContractId(ids);			//删除当前合同下的所有附件信息
		contractProductDao.deleteByContractId(ids);		//删除当前合同下的所有货物信息
		contractDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.deleteByContractId(ids);			//删除当前合同下的所有附件信息
		contractProductDao.deleteByContractId(ids);		//删除当前合同下的所有货物信息
		contractDao.delete(ids);
	}

	@Override
	public void submit(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 1);	//1已上报
		map.put("ids", ids);
		contractDao.updateState(map);
	}

	@Override
	public void cancel(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 0);	//0草稿
		map.put("ids", ids);
		contractDao.updateState(map);
	}

	@Override
	public ContractVO view(String contractId) {
		return contractDao.view(contractId);
	}

}
