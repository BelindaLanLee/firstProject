package jp.co.brightstar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.brightstar.mapper.UserMapper;
import jp.co.brightstar.model.UserCondition;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	public void insertUserInfo(UserCondition condition) {
		mapper.insertUserInfo(condition);
	}

	public UserCondition userInfoDetail(String phoneNo) {
		return mapper.userInfoDetail(phoneNo);
	}

	public UserCondition userInfo(String phoneNo) {
		return mapper.userInfo(phoneNo);
	}

	public void deleteUserInfo(String phoneNo) {
		mapper.deleteUserInfo(phoneNo);
	}

	public UserService() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void userInfoUpdate(UserCondition condition2) {
		mapper.userInfoUpdate(condition2);
	}
}
