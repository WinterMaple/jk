package cn.hfl.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.hfl.jk.dao.ExtEproductDao;
import cn.hfl.jk.domain.ExtEproduct;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class ExtEproductDaoImpl extends BaseDaoImpl<ExtEproduct> implements ExtEproductDao{
	public ExtEproductDaoImpl() {
		//设置命名空间
		super.setNs("cn.hfl.jk.mapper.ExtEproductMapper");
	}
}
