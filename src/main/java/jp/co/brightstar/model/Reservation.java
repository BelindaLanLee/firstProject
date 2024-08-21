package jp.co.brightstar.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class Reservation implements Serializable  {
	private int roomtype;
	private int roomprice;
	private String petid;
	private String fromdate;
    private String todate;
//	private String totaldays;


	
	public String getPetId1() {
		return  this.petid ;
	}
	

	
	public String getFromDate1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return this.fromdate == null ? "" : sdf.format(this.fromdate);
	}

	
	public String getToDate1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return this.todate == null ? "" : sdf.format(this.todate);
	}
	   
	
	
	
	
  /*  public String getTotaldays1() {
		return this.totaldays ;
	  }     */
}
