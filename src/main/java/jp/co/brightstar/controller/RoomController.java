package jp.co.brightstar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.brightstar.model.Room;
import jp.co.brightstar.model.RoomType;
import jp.co.brightstar.service.RoomService;

@Controller
public class RoomController {
	@Autowired
	private RoomService service;
	@PostMapping("addRoom")
	public ModelAndView insert(String roomtype, String roomprice) {
		ModelAndView mav = new ModelAndView();
		RoomType roomType = new RoomType();
		roomType.setRoomType(roomtype);
		roomType.setPrice(Integer.parseInt(roomprice));
		service.insertRoom(roomType);

//		String msg = roomtype +"型ルームを増加しました！";
//		mav.addObject("msg", msg);

		mav.setViewName("redirect:roomInfo");

		return mav;
	}
	
	@GetMapping("roomInfo")
	public ModelAndView search() {
		ModelAndView mav = new ModelAndView();
		List<Room> rooms = service.getRooms();
		mav.addObject("rooms", rooms);
		
		return mav;
	}
	
	@PostMapping("searchRoom")
	public ModelAndView search(String roomtype) {
		ModelAndView mav = new ModelAndView();

		List<Room> room = service.searchRoom(roomtype);

		mav.addObject("roomtype", roomtype);

		mav.setViewName("roomInfo");

		return mav;
	}
	
}
