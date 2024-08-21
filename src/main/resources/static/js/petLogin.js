/**
 * Submit画面
 */
$(function() {
	// ログインボタンクリック
	$("#submit").click(petloginCheck);
})

// 入力チェックを行う
function petloginCheck() {
	// 出力パラメータ
	var name = "ペットネーム";
	var kind = "種類";
	var birthday = "誕生日";
	var gender = "性別";
	var count = "回";
	var reference = "1000文字";

	// 入力した値
	var name = $("#name").val();
	var kind= $("#kind").val();
	var birthday= $("#birthday").val();
	var gender = $("#gender ").val();
	var count= $("#count").val();
	var reference= $("#reference").val();


	// エラーメッセージ



	// エラーがある場合はエラーメッセージをJSアラートで表示しつつ自画面遷移
	if (name < 0) {
	}
	// エラーがない場合は、ユーザ認証チェックを行う
	else {
		$("#petSubmit").submit();
	}
}