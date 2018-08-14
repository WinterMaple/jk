package cn.hfl.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hfl.jk.controller.BaseController;
import cn.hfl.jk.domain.ExtCproduct;
import cn.hfl.jk.domain.Factory;
import cn.hfl.jk.domain.SysCode;
import cn.hfl.jk.service.ExtCproductService;
import cn.hfl.jk.service.FactoryService;

@Controller
public class ExtCproductController extends BaseController {
	@Autowired
	ExtCproductService extCproductService;
	@Autowired
	FactoryService factoryService;
	
	@RequestMapping("cargo/extcproduct/tocreate.action")
	public String toCreate(String contractProductId, Model model){
		model.addAttribute("contractProductId", contractProductId);		//传递主表id
		
		//某个货物下的附件信息
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("contractProductId", contractProductId);
		List<ExtCproduct> dataList = extCproductService.find(paraMap);
		model.addAttribute("dataList", dataList);
		
		//准备生产厂家的下拉列表
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//准备分类下拉列表
		List<SysCode> ctypeList = extCproductService.getCtypeList();
		model.addAttribute("ctypeList", ctypeList);
		
		return "/cargo/contract/jExtCproductCreate.jsp";
	}
	
	@RequestMapping("cargo/extcproduct/insert.action")
	public String insert(ExtCproduct extcproduct, Model model){
		extCproductService.insert(extcproduct);
		model.addAttribute("contractProductId", extcproduct.getContractProductId());	//传递主表id
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@RequestMapping("cargo/extcproduct/toupdate.action")
	public String toUpdate(String id, Model model){
		ExtCproduct obj = extCproductService.get(id);
		model.addAttribute("obj", obj);
		
		//准备生产厂家的下拉列表
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//准备分类下拉列表
		List<SysCode> ctypeList = extCproductService.getCtypeList();
		model.addAttribute("ctypeList", ctypeList);
		
		return "/cargo/contract/jExtCproductUpdate.jsp";
	}
	
	@RequestMapping("cargo/extcproduct/update.action")
	public String update(ExtCproduct extcproduct, Model model){
		extCproductService.update(extcproduct);
		model.addAttribute("contractProductId", extcproduct.getContractProductId());	//传递主表id
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@RequestMapping("cargo/extcproduct/delete.action")
	public String deleteById(String id, String contractProductId, Model model){
		extCproductService.deleteById(id);
		model.addAttribute("contractProductId", contractProductId);			//传递主表id
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
}
