package com.csipl.controller;

import java.sql.SQLException;
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
	public String home(Model model) throws SQLException {

		return "home";
	}

	@RequestMapping(value = { "/advertiser/list" }, method = RequestMethod.GET)
	public String advertiser(Model model) throws SQLException {

		List<String> list = dataDAO.queryAdvertisers();
		model.addAttribute("advertisers", list);

		return "advertiser";
	}

	@RequestMapping(value = { "/publisher/list" }, method = RequestMethod.GET)
	public String publisher(Model model) throws SQLException {

		List<String> list = dataDAO.queryPublishers();
		model.addAttribute("publishers", list);

		return "publisher";
	}

}