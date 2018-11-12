package com.action;

import java.util.List;

import com.entity.Show;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.ShowService;
import com.service.ShowServiceImpl;

public class ShowAction {
	private Show show;
	private ShowService showService=new ShowServiceImpl();
	
	public Show getShow() {
		return show;
	}


	public void setShow(Show show) {
		this.show = show;
	}


	public ShowService getShowService() {
		return showService;
	}


	public void setShowService(ShowService showService) {
		this.showService = showService;
	}

	//查所有员工
	public String showAllEms(){
		List<Show> lists=showService.queryEmployees();
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.setValue("#session.list", lists);
		return "showAll";
	}
	
	public String deleteEm(){
		showService.delete(show.getId());
		return "delete";
	}
	
	public String insertEm(){
		showService.insert(show);
		return "insert";
	}
	
	public String updateEm(){
		showService.update(show);
		System.out.println("============"+show);
		return "update";
	}
}
