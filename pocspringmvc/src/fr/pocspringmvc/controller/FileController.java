package fr.pocspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public String createFile(@ModelAttribute("fileToCreate") File file) {
		// en ajoutant Model model en parametre de la methode, on peut
		// utiliser la ligne ci apres pour l init du model
		// model.addAttribute("fileToCreate", new File());
		return "formFile";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView saveFile(@ModelAttribute("fileToCreate") File file) {
		return new ModelAndView("fileInfo", "file", file);
	}

}