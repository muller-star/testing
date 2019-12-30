package com.ssi.controllers;

import java.util.List;
import java.util.Set;

import com.ssi.dao.TransporterDAO;
import com.ssi.entities.Transporter;
import com.ssi.utility.DataProvider;

@Controller
public class TransporterController {

	@Autowired
	private TransporterDAO transporterDAO;

	@RequestMapping("savetransporter")
	public ModelAndView saveTransporter(@ModelAttribute("transporter") Transporter transporter) {
		transporterDAO.saveTransporter(transporter);
		ModelAndView mv = new ModelAndView("transportersaveconfirm");
		return mv;
	}

	@RequestMapping("transporterentry")
	public ModelAndView showTransporterEntryForm() {
		ModelAndView mv = new ModelAndView("transporterentry");
		mv.addObject("transporter", new Transporter());
		List<String> cities = DataProvider.getCityNames();
		List<String> states = DataProvider.getStateNames();
		mv.addObject("cities", cities);
		mv.addObject("states", states);
		return mv;
	}

	@RequestMapping("transporterhome")
	public String showTransporterHome() {
		return "transporterhome";
	}

}
