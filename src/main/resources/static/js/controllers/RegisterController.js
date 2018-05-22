app.controller('RegisterController', ['$scope', '$http', function($scope, $http){
	
	$scope.studentView = true;
	$scope.sections = [];
	$scope.saveOk = false;
	$scope.options = [{"value": 1, "text": "alumno"},{"value": 2, "text":"profesor"}];
	$scope.registerSelect = $scope.options[0];
	$scope.registerCoordinator = false;

	$scope.resetForm = function(){
		$scope.registerName = "";
		$scope.registerLastName = "";
		$scope.registerEmail = "";
		registerCoordinator = false;
		$scope.registerSection = "";
	};

	$scope.loadSections = function(){
        $http.get('http://localhost:2323/sections').then(function(response){
            $scope.sections = response.data;

        });
    };
    $scope.loadSections();

	$scope.saveStudent = function(){
		var student = {
            "name":$scope.registerName,
            "lastName":$scope.registerLastName,
            "email":$scope.registerEmail
        };

        $scope.saveOk = false;
        if( $scope.registerName != null && 
        	$scope.registerLastName != null && 
        	$scope.registerEmail != null &&
        	$scope.registerSection){
        	$scope.saveOk = true;
        	return $http.post('http://localhost:2323/students/' + $scope.registerSection.idSection, student);
    	}
    	
	};

	$scope.saveTeacher = function(){
		var teacher = {
          	"name":$scope.registerName,
            "lastName":$scope.registerLastName,
            "email":$scope.registerEmail,
            "coordinator":0
        };
        if($scope.registerCoordinator){
        	teacher.coordinator = 1;
        }

        $scope.saveOk = false;
        if( $scope.registerName != null && 
        	$scope.registerLastName != null && 
        	$scope.registerEmail != null){
        	$scope.saveOk = true;
        	return $http.post('http://localhost:2323/teachers/', teacher);
        }
	};

	$scope.saveRegister = function(){
		if($scope.registerSelect.value == 1){
			$scope.saveStudent();
		}
		else{
			$scope.saveTeacher();
		}
	};

	$scope.showOptions = function(){
		if($scope.registerSelect.value == 1){
			$scope.studentView = true;
		}

		if($scope.registerSelect.value != 1){
			$scope.studentView = false;
		}
	};
	$scope.exit = function(){
		$scope.resetForm();
		$scope.saveOk = false;
	}
}]);
