package com.master.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.master.app.constants.MasterAppConstants;
import com.master.app.model.MasterDto;
import com.master.app.service.MasterService;

@RestController
@RequestMapping("/master")
public class MasterController {
	
	@Autowired private MasterService masterService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createMasterRecord(@RequestBody MasterDto masterDto) {
		ResponseEntity<?> responseEntity = null;
		MasterDto master = masterService.createMasterRecord(masterDto);
		if (master != null) {
			responseEntity = new ResponseEntity<MasterDto>(master, HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>(MasterAppConstants.MASTER_RECORD_NOT_CREATED, HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> masterList() {
		ResponseEntity<?> responseEntity = null;
		List<MasterDto> masterList = masterService.getMasterList();
		if (!CollectionUtils.isEmpty(masterList)) {
			responseEntity = new ResponseEntity<List<MasterDto>>(masterList, HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>(MasterAppConstants.NO_MASTER_RECORDS_FOUND, HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateMasterRecord(@RequestBody MasterDto masterDto) {
		ResponseEntity<?> responseEntity = null;
		MasterDto master = masterService.createMasterRecord(masterDto);
		if (master != null) {
			responseEntity = new ResponseEntity<MasterDto>(master, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>(MasterAppConstants.FAILED_TO_UPDATE_MASTER_RECORD, HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteMasterRecord(@RequestParam("id") Long id) {
		ResponseEntity<?> responseEntity = null;
		String message = masterService.deleteMasterRecordById(id);
		if (message != null) {
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>(MasterAppConstants.FAILED_TO_DELETE_MASTER_RECORD, HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

}
