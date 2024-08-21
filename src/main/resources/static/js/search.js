/**
 * 検索PET画面
 */

function updatePet(id){
	open("/brightstar/LRcatHotel/petReset?id=" + id, "_blank","width = 800px, height=600px,left= 400px")
}
function deletePet(id, name, nowTr) {
	var result = confirm("ペット「" + name + "」を削除してもよろしいですか？");

	if (result) {
		// location.href = "/brightstar/dvd/delete?id=" + id + "&name=" + name;
		//AJAX通信を開始
	  $.ajax({
		// データの送信先
			url: "/brightstar/LRcatHotel/deletePet",
		 //メソッド
			type: "post",
			// 送信するデータ
			data: {
				"id": id,
				"name": name
			}
		})
			// AJAXリクエストが成功（ステータスコード200）した場合の処理
			.done(function(msg) {
				alert(msg);
				$(nowTr).parent().parent().remove();
			})
			// リクエストが失敗した場合の処理
			.fail(function() { })
	}
}