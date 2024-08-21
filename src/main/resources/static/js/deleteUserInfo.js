/**
 * マイページの情報削除
 * deleteUserInfo
 * 		url:"/brightstar/LRcatHotel/deleteUserInfo",
// AJAX通信を開始
		
 */

function deleteUserInfo(phoneNo,userName){
	var result = confirm(userName + "様を削除してもよろしいでしょうか。");
	
	if(result){
		// AJAX通信を開始
		$.ajax({
			// データの送信先
			url:"/brightstar/LRcatHotel/deleteUserInfo",
			// メソッド
			type: "post",
			// 送信するデータ
			data: {
				"phoneNo": phoneNo,
				"userName": userName
			},
			// AJAXリクエストが成功（ステータスコード200）した場合の処理
			success: function(map){
				alert(map.msg);
				// 请求成功后跳转到login.html页面
                window.location.href = "/brightstar/LRcatHotel/homePage";
			},
			// リクエストが失敗した場合の処理
			fail: function(){
				alert("リクエスト失敗しました!");
			}
		})
	}
}

//$(function() {
//	// ログインボタンクリック
//	$("#userInfo").click(function(){
//		$("userInfo").submit();
//	});
//})

