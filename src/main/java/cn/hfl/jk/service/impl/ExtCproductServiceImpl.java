package cn.hfl.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hfl.jk.dao.ExtCproductDao;
import cn.hfl.jk.dao.SysCodeDao;
import cn.hfl.jk.domain.ExtCproduct;
import cn.hfl.jk.domain.SysCode;
import cn.hfl.jk.pagination.Page;
import cn.hfl.jk.service.ExtCproductService;
import cn.itcast.util.UtilFuns;

@Service
public class ExtCproductServiceImpl implements ExtCproductService {

	@Autowired
	ExtCproductDao ExtCproductDao;
	@Autowired
	SysCodeDao sysCodeDao;
	
	@Override
	public List<ExtCproduct> findPage(Page page) {
		return ExtCproductDao.findPage(page);
	}

	@Override
	public List<ExtCproduct> find(Map paraMap) {
		return ExtCproductDao.find(paraMap);
	}

	@Override
	public ExtCproduct get(Serializable id) {
		return ExtCproductDao.get(id);
	}

	@Override
	public void insert(ExtCproduct extcproduct) {
		extcproduct.setId(UUID.randomUUID().toString());
		//自动计算总金额=数量*单价		...修改、删除；同步合同总金额
		if(UtilFuns.isNotEmpty(extcproduct.getCnumber()) && UtilFuns.isNotEmpty(extcproduct.getPrice())){
			extcproduct.setAmount(extcproduct.getCnumber()*extcproduct.getPrice());
		}
		
		ExtCproductDao.insert(extcproduct);
	}

	@Override
	public void update(ExtCproduct extcproduct) {
		//自动计算总金额=数量*单价		...修改、删除；同步合同总金额
		if(UtilFuns.isNotEmpty(extcproduct.getCnumber()) && UtilFuns.isNotEmpty(extcproduct.getPrice())){
			extcproduct.setAmount(extcproduct.getCnumber()*extcproduct.getPrice());
		}
		
		ExtCproductDao.update(extcproduct);
	}

	@Override
	public void deleteById(Serializable id) {
		ExtCproductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		ExtCproductDao.delete(ids);
	}

	@Override
	public List<SysCode> getCtypeList() {
		Map paraMap = new HashMap();
		paraMap.put("parentId", "0104");	//sys_code_b 0104附件分类
		
		return sysCodeDao.find(paraMap);
	}
}
