package cn.hfl.jk.service;

import java.util.List;
import java.util.Map;

import cn.hfl.jk.domain.SysCode;

public interface SysCodeService {
	public List<SysCode> find(Map paraMap);		//带条件查询，条件可以为null，既没有条件；返回list对象集合
}
