package cn.hfl.jk.controller.cargo.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hfl.jk.domain.Contract;
import cn.hfl.jk.service.ContractService;
import cn.hfl.jk.vo.ContractVO;

@Controller
public class ContractController {
	@Autowired
	ContractService contractService;
	
	@RequestMapping("cargo/contract/list.action")
	public String list(Model model){
		List<Contract> dataList = contractService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/contract/jContractList.jsp";
	}
	
	@RequestMapping("cargo/contract/tocreate.action")
	public String toCreate(){
		return "/cargo/contract/jContractCreate.jsp";
	}
	
	@RequestMapping("cargo/contract/insert.action")
	public String insert(Contract contract){
		contractService.insert(contract);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("cargo/contract/toupdate.action")
	public String toUpdate(String id, Model model){
		Contract obj = contractService.get(id);
		model.addAttribute("obj", obj);
		
		return "/cargo/contract/jContractUpdate.jsp";
	}
	
	@RequestMapping("cargo/contract/update.action")
	public String update(Contract contract){
		contractService.update(contract);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("cargo/contract/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		contractService.delete(ids);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("cargo/contract/toview.action")
	public String toView(String id, Model model){
		ContractVO obj = contractService.view(id);
		model.addAttribute("obj", obj);
		
		return "/cargo/contract/jContractView.jsp";
	}
	
	@RequestMapping("cargo/contract/submit.action")
	public String submit(@RequestParam("id")String[] ids){
		contractService.submit(ids);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("cargo/contract/cancel.action")
	public String cancel(@RequestParam("id")String[] ids){
		contractService.cancel(ids);
		
		return "redirect:/cargo/contract/list.action";
	}
}
