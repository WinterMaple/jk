package cn.hfl.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.hfl.jk.dao.ExportDao;
import cn.hfl.jk.domain.Export;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class ExportDaoImpl extends BaseDaoImpl<Export> implements ExportDao{
	public ExportDaoImpl() {
		//设置命名空间
		super.setNs("cn.hfl.jk.mapper.ExportMapper");
	}

	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}
}
