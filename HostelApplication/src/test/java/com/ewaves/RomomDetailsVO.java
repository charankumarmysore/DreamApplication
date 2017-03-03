package com.ewaves;

import java.util.ArrayList;
import java.util.List;

import com.ewaves.domain.RoomDetailsVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.entities.SharingDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RomomDetailsVO {

	public static void main(String[] args) {

		RoomDetailsVO detailsVO = new RoomDetailsVO();
		HostelDetails hostelDetails = new HostelDetails();
		hostelDetails.setHostelId(1L);
		List<SharingDetails> sharingDetailsList = new ArrayList<>();
		SharingDetails sharingDetails = new SharingDetails();
		sharingDetails.setId(1);
		sharingDetails.setNoOfPersonAvailability(3);
		sharingDetails.setSharingType(4);

		sharingDetails.setHostelDetails(hostelDetails);

		detailsVO.setSharingDetails(sharingDetailsList);

		sharingDetailsList.add(sharingDetails);

		System.out.println(detailsVO);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(detailsVO);
			System.out.println(jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
