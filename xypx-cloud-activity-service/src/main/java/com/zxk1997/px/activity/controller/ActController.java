package com.zxk1997.px.activity.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.activity.service.ActService;
import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.interfaces.OpType;
import com.zxk1997.px.common.models.PxAct;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxLctr;
import com.zxk1997.px.common.models.PxUserPartake;

@RestController
@RequestMapping("/act")
public class ActController {
	
	@Autowired
	ActService act;
	
	@Autowired
	Validator v;

	@PostMapping("/")
	public Integer add(@RequestBody PxActivity a) {
		if(a!=null) {
			if(a.getType()==PxActType.ACTIVITY) {
				Set<ConstraintViolation<PxAct>>set= v.validate(a.getAct());
				if(set.size()>0) {
					return -1;
				}
			}else {
				Set<ConstraintViolation<PxLctr>>set= v.validate(a.getLctr());
				if(set.size()>0) {
					return -1;
				}
			}
			
		}
		return this.act.addAct(a);
	}
	
	@PutMapping("/")
	public Integer edit(@RequestBody PxActivity a) {
		if(a!=null) {
			if(a.getType()==PxActType.ACTIVITY) {
				Set<ConstraintViolation<PxAct>>set= v.validate(a.getAct(),OpType.U.class);
				if(set.size()>0) {
					return -1;
				}
			}else {
				Set<ConstraintViolation<PxLctr>>set= v.validate(a.getLctr(),OpType.U.class);
				if(set.size()>0) {
					return -1;
				}
			}
		}
		return this.act.editAct(a);
	}
	
	@DeleteMapping("/{id}")
	public Integer del(@PathVariable("id") String id,PxActType type) {
		if(id!=null && type!=null) {
			return act.delAct(id, type);
		}
		return -1;
	}
	
	@PostMapping("/partake")
	public Integer join( @RequestBody @Validated PxUserPartake partake,BindingResult bindingResult) {
		if(!bindingResult.hasErrors() ) {
			return act.joinAct(partake);
		}
		return -1;
	}
	
	@DeleteMapping("/partake/{id}")
	public Integer unJoin(@PathVariable("id") Integer id) {
		if(id!=null ) {
			PxUserPartake p=new PxUserPartake();
			p.setId(id);
			return act.unJoinAct(p);
		}
		return -1;
	}
	
}
