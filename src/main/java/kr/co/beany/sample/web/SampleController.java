package kr.co.beany.sample.web;
 
import java.util.List;

import javax.annotation.Resource;


import kr.co.beany.sample.service.SampleService;
import kr.co.beany.sample.vo.Body;
import kr.co.beany.sample.vo.SampleVo;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
@ResponseStatus(value = HttpStatus.ACCEPTED)
@RequestMapping("/sample")
@Controller(value = "sampleController")
public class SampleController {
 
    @Resource(name = "sampleService")
    private SampleService sampleService;
 
    @RequestMapping(value = "/list")
    public String list(ModelMap model) throws Exception {
        List<SampleVo> list = this.sampleService.getAll();
        model.addAttribute("list", list);
 
        return "sample/SampleList";
    }
 
   
    @RequestMapping(value = "/form")
    public String form(@RequestParam(value = "sampleNo", required = false, defaultValue="0") int sampleNo,
                       ModelMap model) throws Exception {
        SampleVo sampleVo = null;
 
        if (sampleNo > 0) {
            sampleVo = this.sampleService.get(sampleNo);
            model.addAttribute("commandUrl", "editsave");
        } else {
            model.addAttribute("commandUrl", "addsave");
        }
 
        model.addAttribute("result", sampleVo);
 
        return "sample/SampleView";
    }
 
    @RequestMapping(value = "/addsave", method = RequestMethod.POST)
    public String add(@ModelAttribute("sampleVo") SampleVo sampleVo,
                      RedirectAttributes redirectAttributes) {
        this.sampleService.add(sampleVo);
        redirectAttributes.addFlashAttribute("message", "추가되었습니다.");
 
        return "redirect:list";
    }
 
    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String update(@ModelAttribute("sampleVo") SampleVo sampleVo,
                         RedirectAttributes redirectAttributes) {
        this.sampleService.update(sampleVo);
        redirectAttributes.addFlashAttribute("message", "수정되었습니다.");
 
        return "redirect:list";
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String update(@RequestParam(value = "sampleNo", required = false) int sampleNo,
                         RedirectAttributes redirectAttributes) {
        this.sampleService.delete(sampleNo);
        redirectAttributes.addFlashAttribute("message", "삭제되었습니다.");
 
        return "redirect:list";
    }
    
    
/*레스트 방식 시작    */
    @ResponseStatus(value=HttpStatus.FOUND)
	@RequestMapping(value = "/rest/{sampleNo}", method = RequestMethod.GET)
	public ResponseEntity<SampleVo> selectOne(@PathVariable int sampleNo) {
		SampleVo currentVo = null;
		currentVo = sampleService.get(sampleNo);
		
        if(currentVo==null){
        	System.out.println("A Vo with name " +sampleNo + " not exist");
            return new ResponseEntity<SampleVo>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		
		return new ResponseEntity<SampleVo>(currentVo, HttpStatus.OK);
		
	}
	
	   @ResponseStatus(value=HttpStatus.FOUND)
	   @RequestMapping(value = "/rest/", method = RequestMethod.GET)
	    public ResponseEntity<List<SampleVo>> listAll() {
		   
	        List<SampleVo> sampleVos = sampleService.getAll();
	        System.out.println(sampleVos);
	        if(sampleVos==null){
	        	System.out.println("Sd");
	            return new ResponseEntity<List<SampleVo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<SampleVo>>(sampleVos, HttpStatus.OK);
	    }
	

	   @ResponseStatus(value=HttpStatus.FOUND)
       @RequestMapping(value = "/rest/add/", method = RequestMethod.POST)
       /*public ResponseEntity<Void> create(@RequestBody SampleVo sampleVo,   UriComponentsBuilder ucBuilder) {*/
	   public ResponseEntity<List<SampleVo>> create(@RequestBody SampleVo sampleVo,   UriComponentsBuilder ucBuilder) {
           System.out.println("Creating Vo " + sampleVo.getSampleNo());
    
           if (sampleService.get(sampleVo.getSampleNo())!= null) {
               System.out.println("A Vo with name " + sampleVo.getSampleNo() + " already exist");
               return new ResponseEntity<List<SampleVo>>(HttpStatus.CONFLICT);
               
               /*return new ResponseEntity<Void>(HttpStatus.CONFLICT);*/
           }
    
           sampleService.add(sampleVo);
    
/*           HttpHeaders headers = new HttpHeaders();
           headers.setLocation(ucBuilder.path("/rest/add/{sampleNo}").buildAndExpand(sampleVo.getSampleNo()).toUri());
           return new ResponseEntity<Void>(headers, HttpStatus.OK);*/
           
           
           
           List<SampleVo> sampleVos = sampleService.getAll();
           return new ResponseEntity<List<SampleVo>>(sampleVos, HttpStatus.OK);
       }
       
       
	   @ResponseStatus(value=HttpStatus.FOUND)
       @RequestMapping(value = "/rest/update/{sampleNo}", method = RequestMethod.PUT)
       public ResponseEntity<List<SampleVo>> update( @PathVariable int sampleNo, @RequestBody SampleVo sampleVo,  UriComponentsBuilder ucBuilder) {
           System.out.println("Updating Vo " + sampleVo.getSampleNo());
           SampleVo currentVo = sampleService.get(sampleVo.getSampleNo());
           
           if (currentVo == null) {
               System.out.println("A Vo with name " + sampleVo.getSampleNo() + " not exist");
               return new ResponseEntity<List<SampleVo>>(HttpStatus.NO_CONTENT);
           }
           currentVo.setTitle(sampleVo.getTitle());
           currentVo.setDescription(sampleVo.getDescription());
           currentVo.setSampleNo(sampleVo.getSampleNo());
                                           
           
           sampleService.update(currentVo);
           List<SampleVo> sampleVos = sampleService.getAll();
    
           HttpHeaders headers = new HttpHeaders();
           headers.setLocation(ucBuilder.path("/rest/update/{sampleNo}").buildAndExpand(sampleVo.getSampleNo()).toUri());
      
           
           return new ResponseEntity<List<SampleVo>>(sampleVos, headers, HttpStatus.OK);
       }
       
	   @ResponseStatus(value=HttpStatus.FOUND)
       @RequestMapping(value = "/rest/delete/{sampleNo}", method = RequestMethod.DELETE)
       public ResponseEntity<SampleVo> delete( @PathVariable int sampleNo,  UriComponentsBuilder ucBuilder) {
           System.out.println("deleting Vo :" + sampleNo);
          
           
           SampleVo sampleVo = sampleService.get(sampleNo);
           if (sampleVo == null) {
               System.out.println("Unable to delete. Vo with id " + sampleNo + " not found");
               return new ResponseEntity<SampleVo>(HttpStatus.NOT_FOUND);
           }
           
           System.out.println("ASdasdasd");
    
           sampleService.delete(sampleNo);
           return new ResponseEntity<SampleVo>(HttpStatus.OK);
       }
	   
	   
	   
	   
	   @RequestMapping(value = "/rest/xml/{message}", method = RequestMethod.GET)
	   @ResponseBody
	   public Body getMessageBody(@PathVariable String message, ModelMap model) {
	   Body body = new Body();
	   body.setMessage(message);
	   return body;
	   }






	   
	   
	   
}




