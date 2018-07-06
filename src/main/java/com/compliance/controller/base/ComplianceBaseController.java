package com.compliance.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.compliance.db.compliance_db.service.ComplianceService;
import com.compliance.db.compliance_db.entity.Compliance;

//IMPORT RELATIONS

public class ComplianceBaseController {
    
    @Autowired
	ComplianceService complianceService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/compliances", method = RequestMethod.POST, headers = "Accept=application/json")
	public Compliance insert(@RequestBody Compliance obj) {
		Compliance result = complianceService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/compliances/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		complianceService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/compliances/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Compliance get(@PathVariable Long id) {
		Compliance obj = complianceService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/compliances", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Compliance> getList() {
		return complianceService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/compliances/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Compliance update(@RequestBody Compliance obj, @PathVariable("id") Long id) {
		Compliance result = complianceService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
