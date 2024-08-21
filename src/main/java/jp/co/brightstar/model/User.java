package jp.co.brightstar.model;

import lombok.Data;

/**
 * ログイン情報
 * @author 81702
 *
 */
@Data
public class User {
	/**
	 * ユーザID 携帯番号
	 */
	private String userid;

	/**
	 * パスワード
	 */
	private String password;
}
