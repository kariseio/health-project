var main = {
   init : function () {
       var _this = this;
       $('#btn-save').on('click', function () {
           _this.save();
       })
   },
   save : function () {
       var data = {
           exerciseName : $("#exerciseName").val(),
           exerciseReps : $("#exerciseReps").val(),
           exerciseSets : $("#exerciseSets").val()
       };

       $.ajax({
           type : 'POST',
           url : 'http://localhost:8080/api/v1/exercise-api/exercise',
           dataType : 'json',
           contentType : 'application/json; charset=utf-8',
           data : JSON.stringify(data)
       }).done(function () {
           alert('운동이 등록되었습니다.');
           window.location.href = '/';
       }).fail(function (error) {
           alert(JSON.stringify(error));
       })
   }
};

main.init();