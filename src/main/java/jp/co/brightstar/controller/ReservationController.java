package jp.co.brightstar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jp.co.brightstar.model.Reservation;
import jp.co.brightstar.service.ReservationService;

@Controller
public class ReservationController {
   @Autowired
	private ReservationService service;
    private String roomCode;
    private String petid;
    private String fromdate;
    private String todate;
    
    
   @GetMapping("reservation")
	public String reservation() {
		return "reservation";
	}
   
   @GetMapping("reservationInfo")
	public String reservationInfo() {
		return "reservationInfo";
   }
  
 
   
   @PostMapping("reservation")
   @ResponseBody
   public int getPriceByRoomCode(String roomCode) {
		ModelAndView mav = new ModelAndView();

		int price = service.getPriceByRoomCode(roomCode);
		
		return price;
   }
   
   @PostMapping("petidRreservation")
   @ResponseBody
   public String getPetNameByPetid(String petid) {
		ModelAndView mav = new ModelAndView();

		String petname = service.getPetNameByPetid(petid);
		
		return petname;
   }
   
   
   @PostMapping("insertReservation")
	public ModelAndView insertReservation(Reservation reservation) {
		ModelAndView mav = new ModelAndView();

		service.insertReservation(reservation);

		mav.setViewName("reservationInfo");
		
		
		return mav;
	}
   


/*
	
   @PostMapping("reservationInfo")
	public ModelAndView selectReservation(ReservationCondition condition) {
		ModelAndView mav = new ModelAndView();

		Reservation reservation= service.selectReservation(condition);
		System.out.println(reservation);

		mav.addObject("Reservation", reservation);
		mav.addObject("condition", condition);
		mav.setViewName("submitPage");
		return mav;
	}

                         */
}
  
   
/*
@PostMapping("makeReservation")
@ResponseBody
public String makeReservation( Reservation reservation) {
	   
	   LocalDateTime fromdate = reservation.getfromdate();
    LocalDateTime todate = reservation.gettodate();

    boolean canMakeReservation = reservation.canMakeReservation(fromdate, todate);

    if (canMakeReservation) {
        model.addAttribute("message", "予約成功しました！");
    } else {
        model.addAttribute("message", "他の日付を選択してください！");
    }
    return "reservationResult";
}
     */
 
        



	
   
  
   
