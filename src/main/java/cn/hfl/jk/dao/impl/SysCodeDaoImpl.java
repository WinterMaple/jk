package cn.hfl.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.hfl.jk.dao.SysCodeDao;
import cn.hfl.jk.domain.SysCode;

@Repository
public class SysCodeDaoImpl extends BaseDaoImpl<SysCode> implements SysCodeDao {

	//设置命名空间
	public SysCodeDaoImpl() {
		super.setNs("cn.hfl.jk.mapper.SysCodeMapper");
	}

}
