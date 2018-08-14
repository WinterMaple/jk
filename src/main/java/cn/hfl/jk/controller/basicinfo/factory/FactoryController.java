package cn.hfl.jk.controller.basicinfo.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hfl.jk.controller.BaseController;
import cn.hfl.jk.domain.Factory;
import cn.hfl.jk.service.FactoryService;

@Controller
public class FactoryController extends BaseController {
	@Autowired
	FactoryService factoryService;
	
	//查询列表
	@RequestMapping("basicinfo/factory/list.action")
	public String List(Model model){
		List<Factory> dataList = factoryService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/basicinfo/factory/jFactoryList.jsp";
	}
	
	//转向新增页面
	@RequestMapping("basicinfo/factory/tocreate.action")
	public String toCreate(){
		return "/basicinfo/factory/jFactoryCreate.jsp";
	}
	
	//新增保存
	@RequestMapping("basicinfo/factory/insert.action")
	public String insert(Factory factory){
		factoryService.insert(factory);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//转向修改页面
	@RequestMapping("basicinfo/factory/toupdate.action")
	public String toUpdate(String id,Model model){
		Factory obj = factoryService.get(id);
		model.addAttribute("obj", obj);
		
		return "/basicinfo/factory/jFactoryUpdate.jsp";
	}
	
	//修改保存
	@RequestMapping("basicinfo/factory/update.action")
	public String update(Factory factory){
		factoryService.update(factory);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//删除一个
	@RequestMapping("basicinfo/factory/deleteById.action")
	public String deleteById(String id){
		factoryService.deleteById(id);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//删除一个
	@RequestMapping("basicinfo/factory/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		factoryService.delete(ids);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//查看
	@RequestMapping("basicinfo/factory/toview.action")
	public String toView(String id,Model model){
		Factory obj = factoryService.get(id);
		model.addAttribute("obj", obj);
		
		return "/basicinfo/factory/jFactoryView.jsp";
	}
	
	//批量启用
	@RequestMapping("basicinfo/factory/start.action")
	public String start(@RequestParam("id")String[] ids){
		factoryService.start(ids);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//批量停用
	@RequestMapping("basicinfo/factory/stop.action")
	public String stop(@RequestParam("id")String[] ids){
		factoryService.stop(ids);
		
		return "redirect:/basicinfo/factory/list.action";
	}
}
