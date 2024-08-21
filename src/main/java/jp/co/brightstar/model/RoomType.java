package jp.co.brightstar.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class RoomType implements Serializable {
	private int id;
	private String roomType;
	private int price;
	private Date createTime;
	private Date updateTime;
	private Boolean deleteFlag;
	
	public String getRoomType() {
		return roomType;
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public int getRoomPrice() {
		return price;
	}
	
	public void setRoomPrice(int roomPrice) {
		this.price = roomPrice;
	}
	
}