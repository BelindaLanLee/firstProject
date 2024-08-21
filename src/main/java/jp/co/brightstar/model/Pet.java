package jp.co.brightstar.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Pet implements Serializable {
	private int id;
	private String ownerName;
	private String name;
	private String kind;
	private String gender;
	private String reference;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String count;

	public String getName1() {
		return this.name;
	}

	public String getBirthday1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return this.birthday == null ? "" : sdf.format(this.birthday);
	}

	public String getCount1() {
		return this.count + "回";
	}

	public String getGender1() {
		return this.gender;
	}

	public String getKind1() {
		return this.kind;
	}

	public String getReference1() {
		return this.reference;
	}

}
