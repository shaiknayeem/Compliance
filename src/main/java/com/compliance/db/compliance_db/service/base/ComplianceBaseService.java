package com.compliance.db.compliance_db.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.compliance.db.compliance_db.entity.Compliance;
import com.compliance.db.compliance_db.service.ComplianceService;

//IMPORT RELATIONS

@Service
public class ComplianceBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Compliance insert(Compliance obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `compliance`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `compliance` (`_id`, `ApprovedDate`,`AprroverName`,`Compliance_id`,`CreatedBy`,`IsActive`,`LawType`,`Penalty`,`PublishedBy`,`PublishedOn`,`Regulator`,`Section`,`Version`,`createdDate`) VALUES (:id,:ApprovedDate,:AprroverName,:Compliance_id,:CreatedBy,:IsActive,:LawType,:Penalty,:PublishedBy,:PublishedOn,:Regulator,:Section,:Version,:createdDate)";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("ApprovedDate", obj.getApprovedDate())
			.addValue("AprroverName", obj.getAprroverName())
			.addValue("Compliance_id", obj.getCompliance_id())
			.addValue("CreatedBy", obj.getCreatedBy())
			.addValue("IsActive", obj.getIsActive())
			.addValue("LawType", obj.getLawType())
			.addValue("Penalty", obj.getPenalty())
			.addValue("PublishedBy", obj.getPublishedBy())
			.addValue("PublishedOn", obj.getPublishedOn())
			.addValue("Regulator", obj.getRegulator())
			.addValue("Section", obj.getSection())
			.addValue("Version", obj.getVersion())
			.addValue("createdDate", obj.getCreatedDate());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `Compliance` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - GET ONE
    	
	public Compliance get(Long id) {
	    
		String sql = "select * from `Compliance` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Compliance) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Compliance.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Compliance> getList() {
	    
		String sql = "select * from `Compliance`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Compliance.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Compliance update(Compliance obj, Long id) {

		String sql = "UPDATE `Compliance` SET `ApprovedDate` = :ApprovedDate,`AprroverName` = :AprroverName,`Compliance_id` = :Compliance_id,`CreatedBy` = :CreatedBy,`IsActive` = :IsActive,`LawType` = :LawType,`Penalty` = :Penalty,`PublishedBy` = :PublishedBy,`PublishedOn` = :PublishedOn,`Regulator` = :Regulator,`Section` = :Section,`Version` = :Version,`createdDate` = :createdDate  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("ApprovedDate", obj.getApprovedDate())
			.addValue("AprroverName", obj.getAprroverName())
			.addValue("Compliance_id", obj.getCompliance_id())
			.addValue("CreatedBy", obj.getCreatedBy())
			.addValue("IsActive", obj.getIsActive())
			.addValue("LawType", obj.getLawType())
			.addValue("Penalty", obj.getPenalty())
			.addValue("PublishedBy", obj.getPublishedBy())
			.addValue("PublishedOn", obj.getPublishedOn())
			.addValue("Regulator", obj.getRegulator())
			.addValue("Section", obj.getSection())
			.addValue("Version", obj.getVersion())
			.addValue("createdDate", obj.getCreatedDate());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    


    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in ComplianceService.java
     */
    

}
