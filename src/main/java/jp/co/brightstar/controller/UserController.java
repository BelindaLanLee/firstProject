package jp.co.brightstar.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jp.co.brightstar.model.UserCondition;
import jp.co.brightstar.service.UserService;

/**
 * 
 * @author 杜KH
 *ユーザ情報コントローラ
 */
@Controller
public class UserController {
	@Autowired
	private UserService service;

	/**
	 * ユーザ登録情報画面、情報をセクションスコープに保存
	 * 保存後そのまま画面遷移
	 * @param condition
	 * @param session
	 * @return
	 */
	@PostMapping("loginPage")
	public ModelAndView insertUserInfo(UserCondition condition, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		// 进行表单验证，判断是否存在错误消息
		if (hasErrorMessages(condition)) {
			// 存在错误消息，不进行页面跳转，返回错误提示
			mav.addObject("errorMessage", "入力エラーがあります。");
			mav.setViewName("errorPage"); // 可替换为你想要展示错误信息的页面
		} else {
			// 不存在错误消息，进行页面跳转
			session.setAttribute("condition", condition);
			mav.addObject("condition", condition);
			mav.setViewName("loginmsgcheck");
		}

		return mav;
	}

	// 判断是否存在错误消息的方法
	public boolean hasErrorMessages(UserCondition condition) {
		// 根据条件判断是否存在错误消息，可以根据具体的表单验证逻辑进行判断
		// 返回 true 表示存在错误消息，返回 false 表示不存在错误消息
		// 可以使用 if-else 或其他逻辑来判断
		if (condition.getUserNameError() != null || condition.getFuriganaError() != null ||
				condition.getPhoneNumberError() != null || condition.getPasswordError() != null ||
				condition.getEmailAddressError() != null || condition.getPostcodeError() != null ||
				condition.getAddressError() != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 情報登録後の確認画面
	 * 登録画面で保存した情報を出すメソッド
	 * 読み込んだ後、提出後画面遷移
	 * 
	 * @param session
	 * @return
	 */
	@PostMapping("confirmPage")
	public ModelAndView confirmUserInfo(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserCondition condition = (UserCondition) session.getAttribute("condition");
		service.insertUserInfo(condition);
		mav.addObject("condition", condition);
		mav.setViewName("redirect:login");
		return mav;
	}

	/**
	 * ユーザのマイページ画面で保存した個人情報を呼び出す
	 * @param session
	 * @return
	 */
	@GetMapping("submitPage")
	public ModelAndView userInfoDetail(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		String userid = (String) session.getAttribute("userid");
		UserCondition condition2 = service.userInfoDetail(userid);

		mav.addObject("condition", condition2);
		//String userName = (String) session.setAttribute("userName", condition2.getUSERNAME());
		mav.setViewName("submitPage");
		return mav;
	}

	@GetMapping("userInfoUpdatePage")
	public ModelAndView userInfoChange(UserCondition condition, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		String userid = (String) session.getAttribute("userid");

		UserCondition condition2 = service.userInfo(userid);
		session.setAttribute("condition", condition);
		mav.addObject("condition", condition2);

		return mav;
	}

	@PostMapping("deleteUserInfo")
	@ResponseBody
	public Map<String, Object> deleteUserInfo(String phoneNo, String userName) {
		service.deleteUserInfo(phoneNo);

		Map<String, Object> map = new HashMap<>();
		map.put("msg", userName + "様の情報削除は成功しました！");

		return map;

	}

	@PostMapping("userInfoUpdate")
	@ResponseBody
	public ModelAndView userInfoUpdate(UserCondition updateData, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		UserCondition condition2 = (UserCondition) session.getAttribute("condition");

		// 进行表单验证，判断是否存在错误消息
		if (hasErrorMessages(updateData)) {
			// 存在错误消息，不进行页面跳转，返回错误提示

			mav.setViewName("userInfocheck");
		} else {
			// 不存在错误消息，执行用户信息的更新操作
			condition2.setId(updateData.getId());
			condition2.setUserName(updateData.getUserName());
			condition2.setFurigana(updateData.getFurigana());
			condition2.setPhoneNo(updateData.getPhoneNo());
			condition2.setPassword(updateData.getPassword());
			condition2.setEmailAddress(updateData.getEmailAddress());
			condition2.setPostcode(updateData.getPostcode());
			condition2.setAddress(updateData.getAddress());

			service.userInfoUpdate(condition2);

			mav.addObject("condition", condition2);
			mav.addObject("successMessage", "情報更新成功！"); // 添加成功消息
			mav.setViewName("redirect:login"); // 根据你的实际需求设置跳转的页面路径
		}
		return mav;
	}

}
