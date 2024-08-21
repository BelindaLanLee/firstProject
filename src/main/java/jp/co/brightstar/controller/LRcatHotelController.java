package jp.co.brightstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LRcatHotelController {

	@GetMapping("addRoom")
	public String addRoom() {
		return "addRoom";
	}

	@GetMapping("backendPage")
	public String backendPage() {
		return "backendPage";
	}

	@GetMapping("homePage")
	public String homePage() {
		return "homePage";
	}

	@GetMapping("hotelDetail")
	public String hotelDetail() {
		return "hotelDetail";
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("loginmsgcheck")
	public String loginmsgcheck() {
		return "loginmsgcheck";
	}

	@GetMapping("loginPage")
	public String loginPage() {
		return "loginPage";
	}

	//	@GetMapping("ManagementSystem")
	//	public String ManagementSystem() {
	//		return "ManagementSystem";
	//	}

	//	@GetMapping("PetloginPage")
	//	public String PetloginPage() {
	//		return "PetloginPage";
	//	}

	//	@GetMapping("petInfoList")
	//	public String petInfoList() {
	//		return "petInfoList";
	//	}

	//	@GetMapping("PetReset")
	//	public String PetReset() {
	//		return "PetReset";
	//	}
	//
	//	@GetMapping("PetSumbmit")
	//	public String PetSumbmit() {
	//		return "PetSumbmit";
	//	}
	//
	//	@GetMapping("reservation")
	//	public String reservation() {
	//		return "reservation";
	//	}

	@GetMapping("reservationchange")
	public String reservationchange() {
		return "reservationchange";
	}

	//	@GetMapping("reservationInfo")
	//	public String reservationInfo() {
	//		return "reservationInfo";
	//	}

	@GetMapping("reservationInfoList")
	public String reservationInfoList() {
		return "reservationInfoList";
	}

	@GetMapping("reservationManagement")
	public String reservationManagement() {
		return "reservationManagement";
	}

	//	@GetMapping("roomInfo")
	//	public String roomInfo() {
	//		return "roomInfo";
	//	}

	//	@GetMapping("submitPage")
	//	public String submitPage() {
	//		return "submitPage";
	//	}

	@GetMapping("userInfocheck")
	public String userInfocheck() {
		return "userInfocheck";
	}

	@GetMapping("userinfoList")
	public String userinfoList() {
		return "userinfoList";
	}

	//	@GetMapping("userInfoUpdatePage")
	//	public String userInfoUpdatePage() {
	//		return "userInfoUpdatePage";
	//	}
}
