/*package kr.co.beany.sample.web;

import java.util.List;

import javax.annotation.Resource;

import kr.co.beany.sample.service.SampleService;
import kr.co.beany.sample.vo.SampleVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import kr.co.beany.sample.vo.SampleVo;

@Controller
@RequestMapping("/sample")
public class RestController {

	@RequestMapping(value = "/message/{name}", method = RequestMethod.GET)
	public String getMessage(@PathVariable String name, ModelMap model) {
		model.addAttribute("message", name);
		return "list";
	}

}

*/