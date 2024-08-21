/**
 * ユーザ情報登録認証
 */


//メッセージの定義
var message = new Object();
message["error001"] = "$1を入力してください。";
message["error002"] = "$1は$2で入力してください。";
message["error003"] = "$1の入力が間違った！もう一度入力してください。"
//メッセージの呼び出し
function getMessage(id, param1, param2) {
	var m = message[id];
	if (param1 != undefined) {
		m = m.replace("$1", param1);
	}
	if (param2 != undefined) {
		m = m.replace("$2", param2);
	}
	return m;
}

// 出力パラメータ
    var userNameItem = "お名前";
	var furiganaItem = "フリガナ";
	var phoneNumberItem = "電話番号";
	var passwordItem = "パスワード";
	var emailAddressItem = "メールアドレス";
	var postcodeItem = "郵便番号";
	var addressItem = "ご住所";
////	
	var phoneNumberType = "数字のみ";
	var passwordType = "[a-z]、[A-Z]、[0-9]のみ";
	

////		
	var userNameLen = "15文字以内";
	var phoneNumberLen = "10~11文字以内";
	var passwordLen = "８～15文字";
	var emailAddressLen = "50文字以内";
	var postcodeLen= "7文字のみ";
	var addressLen = "50文字以内"

//// 正規表現
//// [\\w-]
	var phoneNumberRegExp = /^[0-9]+$/;
	var passwordRegExp = /^[a-zA-Z0-9]+$/;
　　var emailAddressRegExp = /^[a-zA-Z0-9]+[-|a-zA-Z0-9._]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
////
//// エラーメッセージ
	var errorMsg = new Array();
	
//フォーム検証

$(document).ready(function() {
	//  errorMsgリスト
		var errorMsg = []; // 声明空的 errorMsg 数组
	//	お名前チェック
	$("#userName").blur(function(){
		
		var userName = $("#userName").val();
		
		if(userName == null || userName.length == 0){
			$("#userNameError").text(getMessage("error001", userNameItem)).css("color","rgb(233, 79, 107)")	
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(userName.length > 15){
			$("#userNameError").text(getMessage("error002", userNameItem,userNameLen)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else {
			$("#userNameError").text('')	
			var index = errorMsg.indexOf("エラー");
      if (index != -1) {
        errorMsg.splice(index, 1); // 从数组中移除错误消息
      }	
		}
	});	
	// フリガナチェック
		$("#furigana").blur(function(){
		
		var furigana = $("#furigana").val();
		
		if(furigana == null || furigana.length == 0){
			$("#furiganaError").text(getMessage("error001", furiganaItem)).css("color","rgb(233, 79, 107)")	
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(furigana.length > 15){
			$("#furiganaError").text(getMessage("error002", furiganaItem,userNameLen)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else {
			$("#furiganaError").text('')	
			var index = errorMsg.indexOf("エラー");
      if (index != -1) {
        errorMsg.splice(index, 1); // 从数组中移除错误消息
      }		
		}
	});
	
	//電話番号検証

	$("#phoneNumber").blur(function(){
		
		var phoneNumber = $("#phoneNumber").val();
		
		if(phoneNumber == null || phoneNumber.length == 0){
			$("#phoneNumberError").text(getMessage("error001", phoneNumberItem)).css("color","rgb(233, 79, 107)")	
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(phoneNumber.length <10 || phoneNumber.length > 11){
			$("#phoneNumberError").text(getMessage("error002", phoneNumberItem,phoneNumberLen)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(!phoneNumberRegExp.test(phoneNumber)){
			$("#phoneNumberError").text(getMessage("error002", phoneNumberItem,phoneNumberType)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else {
			$("#phoneNumberError").text('')
			var index = errorMsg.indexOf("エラー");
      if (index != -1) {
        errorMsg.splice(index, 1); // 从数组中移除错误消息
      }			
		}
	});
//パスワード
	$("#password").blur(function(){
		
		var password = $("#password").val();
		
		if(password == null || password.length == 0){
			$("#passwordError").text(getMessage("error001", passwordItem)).css("color","rgb(233, 79, 107)")	
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(password.length <8 || password.length > 15){
			$("#passwordError").text(getMessage("error002", passwordItem,passwordLen)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(!passwordRegExp.test(password)){
			$("#passwordError").text(getMessage("error002", passwordItem,passwordType)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else {
			$("#passwordError").text('')
			var index = errorMsg.indexOf("エラー");
      if (index != -1) {
        errorMsg.splice(index, 1); // 从数组中移除错误消息
      }				
		}
	});
//メールアドレス
$("#emailAddress").blur(function(){
		
		var emailAddress = $("#emailAddress").val();
		
		if(emailAddress == null || emailAddress.length == 0){
			$("#emailAddressError").text(getMessage("error001", emailAddressItem)).css("color","rgb(233, 79, 107)")	
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(emailAddress.length > 50){
			$("#emailAddressError").text(getMessage("error002", emailAddressItem,emailAddressLen)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(!emailAddressRegExp.test(emailAddress)){
			$("#emailAddressError").text(getMessage("error003", emailAddressItem)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else {
			$("#emailAddressError").text('')	
			var index = errorMsg.indexOf("エラー");
      if (index != -1) {
        errorMsg.splice(index, 1); // 从数组中移除错误消息
      }			
		}
	});
//郵便番号
$("#postcode").blur(function(){
		
		var postcode = $("#postcode").val();
		
		if(postcode == null || postcode.length == 0){
			$("#postcodeError").text(getMessage("error001", postcodeItem)).css("color","rgb(233, 79, 107)")	
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(postcode.length != 7 ){
			$("#postcodeError").text(getMessage("error002", postcodeItem,postcodeLen)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(!phoneNumberRegExp.test(postcode)){
			$("#postcodeError").text(getMessage("error002", postcodeItem,phoneNumberType)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else {
			$("#postcodeError").text('')
			var index = errorMsg.indexOf("エラー");
      if (index != -1) {
        errorMsg.splice(index, 1); // 从数组中移除错误消息
      }					
		}
	});
//アドレス
$("#address").blur(function(){
		
		var address = $("#address").val();
		
		if(address == null || address.length == 0){
			$("#addressError").text(getMessage("error001", addressItem)).css("color","rgb(233, 79, 107)")	
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else if(address.length > 50){
			$("#addressError").text(getMessage("error002", addressItem,addressLen)).css("color","rgb(233, 79, 107)")
			errorMsg.push("エラー"); // 将错误消息添加到数组中
		}else {
			$("#addressError").text('')
			var index = errorMsg.indexOf("エラー");
      if (index != -1) {
        errorMsg.splice(index, 1); // 从数组中移除错误消息
      }					
		}
	});
//
 // 登录按钮点击事件
  $("#checkButton").click(function() {
    if (errorMsg.length > 0) {
      // 存在错误消息，禁止提交
      alert("入力エラーがあります。");
      event.preventDefault();
    } else {
      // 没有错误消息，执行提交操作
      $("#loginForm").submit();
    }
  });

});



