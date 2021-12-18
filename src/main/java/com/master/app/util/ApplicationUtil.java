package com.master.app.util;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.master.app.entity.Master;
import com.master.app.model.MasterDto;

@Component
public class ApplicationUtil {

	/**
	 * 
	 * @param master
	 * @return
	 */
	public MasterDto transferEntityToMasterDto(Master master) {
		MasterDto masterDto = null;
		if (master != null) {
			masterDto = new MasterDto();
			masterDto.setId(master.getId());
			masterDto.setName(master.getName());
			masterDto.setStatus(master.getStatus());
			masterDto.setDate(master.getDate());
		}

		return masterDto;
	}

	public Master transferMasterDtoToEntity(MasterDto masterDto) {

		Master master = null;
		if (masterDto != null) {
			master = new Master();
			master.setId(masterDto.getId());
			master.setName(masterDto.getName());
			master.setStatus(masterDto.getStatus());
			master.setDate(masterDto.getDate());
		}

		return master;
	}

	public List<MasterDto> transferDataFromEntityListToDtoList(List<Master> masterList) {
		List<MasterDto> masterDtoList = new LinkedList<>();
		if (!CollectionUtils.isEmpty(masterList)) {
			for (Master master : masterList) {
				if (master != null) {
					masterDtoList.add(transferEntityToMasterDto(master));
				}
			}
		}

		return masterDtoList;
	}

}
