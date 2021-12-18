package com.master.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.app.constants.MasterAppConstants;
import com.master.app.entity.Master;
import com.master.app.model.MasterDto;
import com.master.app.repository.MasterRepository;
import com.master.app.service.MasterService;
import com.master.app.util.ApplicationUtil;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private MasterRepository masterRepository;
	
	@Autowired
	private ApplicationUtil applicationUtil;

	@Override
	public MasterDto createMasterRecord(MasterDto masterDto) {
		Master master = applicationUtil.transferMasterDtoToEntity(masterDto);
		if (master != null) {
			master = masterRepository.saveAndFlush(master);
			masterDto = applicationUtil.transferEntityToMasterDto(master);
		}
		return masterDto;
	}

	@Override
	public MasterDto updateMasterRecord(MasterDto masterDto) {
		Master master = applicationUtil.transferMasterDtoToEntity(masterDto);
		if (master != null) {
			master = masterRepository.saveAndFlush(master);
			masterDto = applicationUtil.transferEntityToMasterDto(master);
		}
		return masterDto;

	}

	@Override
	public String deleteMasterRecordById(Long id) {
		masterRepository.deleteById(id);
		return MasterAppConstants.MASTER_RECORD_DELETED + id;
	}

	@Override
	public List<MasterDto> getMasterList() {
		List<Master> masterList = masterRepository.findAll();
		return applicationUtil.transferDataFromEntityListToDtoList(masterList);
	}

}
