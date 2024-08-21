package jp.co.brightstar.model;

import lombok.Data;

@Data
public class ReservationCondition {

	private int roomtype;
	private int roomprice;
	private String petid;
	private String fromdate;
    private String todate;
//	private String totaldays;
	
}
