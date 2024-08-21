package jp.co.brightstar.mapper;

import org.apache.ibatis.annotations.Mapper;

import jp.co.brightstar.model.Reservation;

@Mapper
public interface ReservationMapper {

//	Reservation searchReservation(ReservationCondition condition);

	int getPriceByRoomCode(String roomCode);
	
	String getPetNameByPetid(String petid);

	void insertReservation(Reservation reservation);

	
	
	
//	void insertReservation(String petname,String fromdate, String todate);

//	int getTotaldays(String Date);

}
