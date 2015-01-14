package fr.pocspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.pocspringmvc.model.File;

@Controller
@RequestMapping("/file")
public class FileController {

	/**
	 * simple exemple of @ModeleAttribute Mapping of one item
	 * 
	 * @return
	 */
	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public File getOneModel() {
		return new File(1, "file name");
	}

	// /**
	// * simple exemple of @ModeleAttribute Mapping of multiple item
	// *
	// */
	// @ModelAttribute
	// @RequestMapping(method = RequestMethod.GET)
	// public void getMultipleModel(Model model) {
	// model.addAttribute(new File(1, "file name"));
	// }

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createFile() {
		return "formFile";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveFile(@ModelAttribute("fileToCreate") File file) {
		return "fileInfo";
	}

}