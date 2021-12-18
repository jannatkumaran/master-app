package com.master.app.service;

import java.util.List;

import com.master.app.model.MasterDto;

public interface MasterService {
	
	public MasterDto createMasterRecord(MasterDto master);
	
	public MasterDto updateMasterRecord(MasterDto master);
	
	public String deleteMasterRecordById(Long id);
	
	public List<MasterDto> getMasterList();
	
	

}
