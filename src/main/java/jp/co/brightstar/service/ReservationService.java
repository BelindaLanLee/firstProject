package jp.co.brightstar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.brightstar.mapper.ReservationMapper;
import jp.co.brightstar.model.Reservation;

@Service
public class ReservationService {
	@Autowired
	private ReservationMapper mapper;

	public int getPriceByRoomCode(String roomCode) {
		return mapper.getPriceByRoomCode(roomCode);
	}

	
	public String getPetNameByPetid(String petid) {
		return mapper.getPetNameByPetid(petid);
	}
	
	public void insertReservation(Reservation reservation) {
		mapper.insertReservation(reservation);

	}

	public boolean canMakeReservation(String fromdate, String todate) {

		return true;
	}


	

}
	/*
	public Reservation selectReservation(ReservationCondition condition) {
		return mapper.searchReservation(condition);
	}   */

	/*	public int getTotalDays(String date) {
			return mapper.getTotaldays(date);
		}  */


