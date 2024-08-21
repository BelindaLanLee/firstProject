package jp.co.brightstar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.brightstar.model.User;
import jp.co.brightstar.service.LoginService;

/**
 * @author 杜KH
 *ログイン画面のコントローラ
 */
@Controller
public class LoginController {
	@Autowired
	private LoginService service;

	@PostMapping("login")
	public ModelAndView login(User userF, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		// ユーザ認証チェックを行う
		// サーバ側でDBのユーザ管理情報テーブルと連携し、認証を行う
		User userB = service.getUserByUserid(userF.getUserid());

		// ◆1.レコード取得できる場合
		if (userB != null) {
			// プログラムでPSW認証を行う
			String passwordB = userB.getPassword();
			String passwordF = userF.getPassword();

			// ◆DB.パスワード＜＞画面.パスワード
			if (!passwordB.equals(passwordF)) {
				// PSW認証エラー
				// ◆登録されたユーザID、パスワードの組み合わせに誤りがある場合
				// ユーザ情報保持用セッション情報をクリアする
				session.removeAttribute("userid");

				// エラーメッセージを表示しつつ自画面遷移
				mav.addObject("msg", "パスワードが間違っています。");
				mav.setViewName("login");
			} else {
				// ◆登録されたユーザID、パスワードの組み合わせがあっている場合
				// ユーザIDを保持用セッションに格納（あれば差し替え）
				session.setAttribute("userid", userF.getUserid());

				// DVD検索画面へ遷移
				mav.setViewName("redirect:submitPage");
			}

		}
		// ◆0レコードの場合
		else {
			// ユーザID認証エラー
			// ◆登録されたユーザID、パスワードの組み合わせに誤りがある場合
			// ユーザ情報保持用セッション情報をクリアする
			session.removeAttribute("userid");

			// エラーメッセージを表示しつつ自画面遷移
			mav.addObject("msg", "該当ユーザーが存在しません。");
			mav.setViewName("login");
		}
		return mav;
	}

}
