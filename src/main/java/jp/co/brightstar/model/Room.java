package jp.co.brightstar.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Room implements Serializable{
	private int id;
	private String roomtype;
	private int roomPrice;
//	private Date fromDate;
//	private Date toDate;
	private Date lastUpdateTime;
	
	public int getID() {
		return id;
	}
	
	public String getRoomType(){
		return roomtype;
	}
	
	public int getRoomPrice(){
		return roomPrice;
	}
	
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	
//	public String getFromDate(){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//		return this.fromDate == null ? "" : sdf.format(this.fromDate);
//	}
//	
//	public String getToDate(){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//		return this.toDate == null ? "" : sdf.format(this.toDate);
//	}
}
