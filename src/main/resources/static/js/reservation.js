
$(function(){
	$('#roomSelect').change(function() {
		var selectedRoomCode = $(this).val();
		
		$.ajax({
			// データの送信先
			url: "/brightstar/LRcatHotel/reservation",
    		method: 'post', 			
   			// 送信するデータ 
    		data: { roomCode: selectedRoomCode },
  			// AJAXリクエストが成功（ステータスコード200）した場合の処理
    		success: function(response) {
      			$('#priceDisplay').text(response);
    		},
 			// リクエストが失敗した場合の処理   
    		fail: function() {}
		})
	})
})



$(function(){
	$('#petnameSelect').option(function() {
		var selectedPetname = $(this).val();
		
		$.ajax({
			// データの送信先
			url: "/brightstar/LRcatHotel/reservation",
			// メソッド
			type: "post",
			// 送信するデータ
    		data: { petName: selectedPetName },
			// AJAXリクエストが成功（ステータスコード200）した場合の処理
			success: function(response) {
      			$('#petNameDisplay').select(response);
			},
			// リクエストが失敗した場合の処理   
    		fail: function() {}
		})
	})
})
   
/*
document.getElementById('fromdate').addEventListener('change', calculateTotalDays);
document.getElementById('todate').addEventListener('change', calculateTotalDays);

function calculateTotalDays() {
  var checkinDate = new Date(document.getElementById('fromdate').value);
  var checkoutDate = new Date(document.getElementById('todate').value);
  
  // 宿泊日数
  var timeDiff = todate.getTime() - fromdate.getTime();
  var totalDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
  
  // 日数を表示
  document.getElementById('totalDays').textContent = totalDays;
}
   */

   
   