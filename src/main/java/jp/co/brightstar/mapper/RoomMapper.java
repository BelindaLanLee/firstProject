package jp.co.brightstar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.brightstar.model.Room;

@Mapper
public interface RoomMapper {
		void insertRoom(String roomtype, int roomPrice);

		List<Room> searchRoom(Integer id,String roomtype);
		
		Room getRoomById(Integer id);
		
		void deleteRoomById(Integer id);
		
		List<Room> getRooms(); 	
}
