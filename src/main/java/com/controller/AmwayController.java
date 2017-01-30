package com.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.model.SyncJobDetail;
import com.model.SyncJobRunStatus;
import com.model.User;
import com.service.SyncJobDetailService;



@Controller
public class AmwayController{
	
	@Autowired
	private SyncJobDetailService detailService;
	
	private Logger logger = LoggerFactory.getLogger(AmwayController.class);
	
	@RequestMapping(value={"/","/home"})
	public ModelAndView getAllSyncJob(HttpServletRequest request,
			HttpSession session,
			Authentication auth)
	{	
		if(session.getAttribute("user") == null)
		{
			User user = null;
			if(!(auth instanceof AnonymousAuthenticationToken))
			{
				user =(User)auth.getPrincipal();
				session.setAttribute("user", user);
				logger.info("User login {}",user.getUserName());
			}
		}
		try {
			request.setAttribute("SyncJobDetails",detailService.getAllSyncJob());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return new ModelAndView("home","syncJobDetail",new SyncJobDetail());
	}
	
	@RequestMapping(value="/detail")
	public String detailsOfSyncJob(@RequestParam(value="jobId",required=false) Long jobId,
			@RequestParam(value="jobType",required=false) String jobType,
			HttpServletRequest request)
	{
		logger.info("Showing details For JOB ID {}",jobId);
		try {
			List<SyncJobRunStatus> list = detailService.getRunStatus(jobId);
			if(!list.isEmpty())
			{
				request.setAttribute("JobDetails",list);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("JobId",jobId);
		request.setAttribute("JobType",jobType);
			return "detail";
	}
	
	@RequestMapping(value="/show",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView showSyncJobForm(@Valid SyncJobDetail syncJobDetail,
			BindingResult result,
			HttpServletRequest request)
	{
		System.out.println("called hi");
		logger.info("Showing JOB ID {}",syncJobDetail.getJobId());
		return new ModelAndView("edit","syncJobDetail",syncJobDetail);
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String editSyncJob(@Valid SyncJobDetail syncJobDetail,
			BindingResult result,
			RedirectAttributes redirectAttributes)
	{
		if(result.hasErrors())
		{
			logger.info("Not Valid Model {}",syncJobDetail);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.syncJobDetail",result);
			redirectAttributes.addFlashAttribute("syncJobDetail",syncJobDetail);
			return "redirect:show";
		}
		
		logger.info("Edit JOB ID {}",syncJobDetail.getJobId());
		try {
			detailService.editUser(syncJobDetail);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
			
			return "redirect:home";
	}
	
	@RequestMapping(value="/start")
	public String startProcess()
	{
		detailService.startProcess();
		return "redirect:home";
	}
	
	@RequestMapping(value="/stop")
	public String stopProcess()
	{
		return "redirect:home";
	}
	
	@RequestMapping(value="/rescedule")
	public String resceduleProcess()
	{
		return "redirect:home";
	}
	
	@RequestMapping(value="/restart")
	public String restartProcess()
	{
		return "redirect:home";
	}
	
}
