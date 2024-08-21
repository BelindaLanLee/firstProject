package jp.co.brightstar.model;

import lombok.Data;

/**
 * ユーザ新規登録画面
 * @author 杜KH
 */
@Data
public class UserCondition {
	/**
	 * id データベース
	 */
	private String id;
	/**
	 * userName お名前（漢字）
	 */

	private String userName;

	/**
	 * furigara お名前（フリガナ）
	 */
	private String furigana;

	/**
	 * userid 電話/携帯番号phoneNumber
	 */
	private String phoneNo;

	/**
	 * password 暗証番号
	 */
	private String password;

	/**
	 * emailAddress メールアドレス
	 */
	private String emailAddress;

	/**
	 * postcode 郵便番号
	 */
	private String postcode;

	/**
	 * address 住所
	 */
	private String address;

	// 用户名错误消息

	private String userNameError;
	private String furiganaError;
	private String phoneNumberError;
	private String passwordError;
	private String emailAddressError;
	private String postcodeError;
	private String addressError;

}
