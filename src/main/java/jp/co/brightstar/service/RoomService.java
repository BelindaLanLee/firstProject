package jp.co.brightstar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.brightstar.mapper.RoomMapper;
import jp.co.brightstar.model.Room;
import jp.co.brightstar.model.RoomType;

@Service
public class RoomService {
	@Autowired
	private RoomMapper mapper;
	
	public void insertRoom(RoomType roomtype){
		mapper.insertRoom(roomtype.getRoomType(), roomtype.getRoomPrice());
	}

	public List<Room> searchRoomById(Integer id, String roomtype) {
		return mapper.searchRoom(id, roomtype);
	}

	public void deleteRoomById(Integer id) {
		 mapper.deleteRoomById(id);
	}

	public Room getRoomById(Integer id) {
		return mapper.getRoomById(id);
	}

	public List<Room> searchRoom(String roomtype) {
		return null;
	}
	
	public List<Room> getRooms() {
		return mapper.getRooms();
	}
}
