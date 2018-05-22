app.controller('seeStatementController', ['$location', '$scope', '$http', '$routeParams', 'userService', function($location, $scope, $http, $routeParams, userService){
	$scope.idStudent = 1;
	$scope.statement = {};
    $scope.result1 = "";
	$scope.codee = "";
	$scope.resultCompare = 0;
	$scope.resultTeacher = "";
    $scope.user = {};

	$scope.loadStatements = function(){
        console.log("id statement: " + $routeParams.id);
        $http.get('http://localhost:2323/statements/'+$routeParams.id).then(function(response){
            $scope.statement = response.data;
            $scope.resultTeacher = $scope.statement.solution;
        });
    };
    $scope.getIdStudent = function(){
        var nameEmail = userService.user.email.split("@")[0];
            //console.log(nameEmail);
        $http.get('http://localhost:2323/students/email/'+nameEmail).then(function(response){
            $scope.user = response.data;
            $scope.idStudent = $scope.user.idStudent;
            userService.idUser($scope.idStudent);
         });
    };
    
    $scope.loadStatements();
    $scope.getIdStudent();

    $scope.sendResponse = function(){
        $scope.codee = myCodeMirror.getValue();
            var code = {
                "correct": $scope.resultCompare,
                "writenCode": $scope.codee
            };
            $http.post('http://localhost:2323/codes/'+$scope.idStudent+"/"+$routeParams.id, code);
            return Alert.render("respuesta enviada");
    };

    $scope.myCompareString = function(){
    	//Si tienen largos distintos.
    	if($scope.result1.innerHTML.length - 1 != $scope.resultTeacher.length){
    		return false;
    	}
    	//Se procede a comparar si tienen el mismo largo.
    	var i;
    	for(i = 0; i < $scope.resultTeacher.length; i++){
    		//Si hay una sola parte distinta.
    		if($scope.resultTeacher[i] != $scope.result1.innerHTML[i]){
    			return false;
    		}
    	}
    	return true;
    };

    $scope.compare = function(){
    	$scope.result1 = document.getElementById("output");
        console.log("aspdijasid:"+ $scope.result1);
        if ($scope.result1.length== null){
            return Alert.render("debes probar tu código antes de enviarlo");
        }
        else{
	    if($scope.myCompareString()){
      		$scope.resultCompare = 1;
          	console.log($scope.resultCompare+" bien");
	    }
	    else{
      		$scope.resultCompare = 0;
        	console.log($scope.resultCompare+" mal");
	    }
        $scope.sendResponse();}
    };
}]);