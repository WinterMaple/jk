package cn.hfl.jk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hfl.jk.dao.SysCodeDao;
import cn.hfl.jk.domain.SysCode;
import cn.hfl.jk.service.SysCodeService;

@Service
public class SysCodeServiceImpl implements SysCodeService {
	@Autowired
	SysCodeDao sysCodeDao;
	
	@Override
	public List<SysCode> find(Map paraMap) {
		return sysCodeDao.find(paraMap);
	}

}
