package com.compliance.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;

import com.compliance.controller.base.ComplianceBaseController;

@RestController
@PropertySource("classpath:${configfile.path}/Compliance.properties")
@RequestMapping(value="${endpoint.api}", headers = "Accept=application/json")
public class ComplianceController extends ComplianceBaseController {

	//OVERRIDE HERE YOUR CUSTOM CONTROLLER

}
