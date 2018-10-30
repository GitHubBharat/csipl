package com.csipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csipl.dao.DataDAO;

@Controller
public class MainController {

	@Autowired
	private DataDAO dataDAO;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) throws Exception {

System.out.println("MainController.home()");
		return "home";
	}

	@RequestMapping(value = "employees/list", method = RequestMethod.GET)
	public String employee(Model model) throws Exception {
System.out.println("MainController.employee()");
		List<String> list = dataDAO.queryEmployees();
		model.addAttribute("employees", list);

		return "employees";
	}

	@RequestMapping(value = { "company/list" }, method = RequestMethod.GET)
	public String company(Model model) throws Exception {
System.out.println("MainController.company()");
		List<String> list = dataDAO.queryCompany();
		model.addAttribute("campany", list);

		return "company";
	}

}