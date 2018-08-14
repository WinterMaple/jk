package cn.hfl.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hfl.jk.controller.BaseController;
import cn.hfl.jk.domain.ContractProduct;
import cn.hfl.jk.domain.Factory;
import cn.hfl.jk.service.ContractProductService;
import cn.hfl.jk.service.FactoryService;

@Controller
public class ContractProductController extends BaseController {
	@Autowired
	ContractProductService contractProductService;
	@Autowired
	FactoryService factoryService;
	
	//转向新增页面
	@RequestMapping("cargo/contractproduct/tocreate.action")
	public String toCreate(String contractId, Model model){
		model.addAttribute("contractId", contractId);
		
		//准备生产厂家的下拉列表
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//某个合同下的列表
		Map paraMap = new HashMap();
		paraMap.put("contractId", contractId);
		List<ContractProduct> dataList = contractProductService.find(paraMap);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/contract/jContractProductCreate.jsp";	//货物的新增页面
	}
	
	//新增
	@RequestMapping("cargo/contractproduct/insert.action")
	public String insert(ContractProduct contractProduct, Model model){
		contractProductService.insert(contractProduct);
		
		model.addAttribute("contractId", contractProduct.getContractId());
		
		return "redirect:/cargo/contractproduct/tocreate.action";	//新增完转向新增页面
	}
	
	//转向修改页面
	@RequestMapping("/cargo/contractproduct/toupdate.action")
	public String toUpdate(String id,Model model){
		ContractProduct obj = contractProductService.get(id);
		model.addAttribute("obj", obj);
		
		//准备生产厂家的下拉列表
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		return "/cargo/contract/jContractProductUpdate.jsp";
	}
	
	@RequestMapping("/cargo/contractproduct/update.action")
	public String update(ContractProduct contractProduct){
		contractProductService.update(contractProduct);
		
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
	
	//删除一条
	@RequestMapping("/cargo/contractproduct/delete.action")
	public String deleteById(String id, String contractId, Model model){
		contractProductService.deleteById(id);
		model.addAttribute("contractId", contractId);		//传递主表id
		
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
}
