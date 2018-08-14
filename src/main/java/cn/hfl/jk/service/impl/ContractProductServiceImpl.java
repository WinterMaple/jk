package cn.hfl.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hfl.jk.dao.ContractProductDao;
import cn.hfl.jk.dao.ExtCproductDao;
import cn.hfl.jk.domain.ContractProduct;
import cn.hfl.jk.pagination.Page;
import cn.hfl.jk.service.ContractProductService;
import cn.itcast.util.UtilFuns;

@Service
public class ContractProductServiceImpl implements ContractProductService {

	@Autowired
	ContractProductDao contractProductDao;
	@Autowired
	ExtCproductDao extCproductDao;
	
	@Override
	public List<ContractProduct> findPage(Page page) {
		return contractProductDao.findPage(page);
	}

	@Override
	public List<ContractProduct> find(Map paraMap) {
		return contractProductDao.find(paraMap);
	}

	@Override
	public ContractProduct get(Serializable id) {
		return contractProductDao.get(id);
	}

	@Override
	public void insert(ContractProduct contractProduct) {
		contractProduct.setId(UUID.randomUUID().toString());
		//自动计算总金额=数量*单价		...修改、删除；同步合同总金额
		if(UtilFuns.isNotEmpty(contractProduct.getCnumber()) && UtilFuns.isNotEmpty(contractProduct.getPrice())){
			contractProduct.setAmount(contractProduct.getCnumber()*contractProduct.getPrice());
		}
		
		contractProductDao.insert(contractProduct);
	}

	@Override
	public void update(ContractProduct contractProduct) {
		//自动计算总金额=数量*单价		...修改、删除；同步合同总金额
		contractProduct.setAmount(contractProduct.getCnumber()*contractProduct.getPrice());
		
		contractProductDao.update(contractProduct);
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCproductDao.deleteByContractProductId(ids);	//删除当前这些货物下的所有附件 
		contractProductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.deleteByContractProductId(ids);	//删除当前这些货物下的所有附件 
		contractProductDao.delete(ids);
	}
}
