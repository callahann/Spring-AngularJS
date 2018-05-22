app.controller('DashboardController', ['$location', '$scope', '$http', 'userService', function($location, $scope, $http,userService){
	
	$scope.sections = [];
	$scope.students = [];
	$scope.coordinatorOK= true;
	$scope.idTeacher=0;
	$scope.user={};
	$scope.section={};

	$scope.getIdTeacher = function(){
        var nameEmail = userService.user.email.split("@")[0];
            console.log("email del profesor "+nameEmail);
        $http.get('http://localhost:2323/teachers/email/'+nameEmail).then(function(response){
			$scope.user = response.data;
			console.log("información del profe "+$scope.user);
			$scope.idTeacher = $scope.user.idTeacher;
			console.log("idTeacher "+$scope.idTeacher);
			userService.idUser($scope.idTeacher);
			$scope.verifyTeacher();
			
         });
	};	
	$scope.loadSections = function(){
        $http.get('http://localhost:2323/sections').then(function(response){
			$scope.sections = response.data;
			console.log($scope.sections);
        });
	};
	$scope.loadSection = function(){
		console.log($scope.idTeacher);
        $http.get('http://localhost:2323/sections/getSectionsByTeacher/'+ $scope.idTeacher).then(function(response){
			$scope.section = response.data;
			console.log("seccion del profe ",$scope.section);
			$scope.loadStudents($scope.section[0].idSection);

        });
	};

	$scope.loadStudents = function(idSection){
		$http.get('http://localhost:2323/students/getStudentsBySection/'+idSection).then(function(response){
			$scope.students = response.data;
			console.log(students);

        });
	};
	$scope.verifyTeacher =function(){
		if($scope.user.coordinator==1){
			console.log("soy coordinador");
			$scope.coordinatorOK=true;
			$scope.loadSections();
		}
		else{
			console.log("soy un profe");
			$scope.coordinatorOK=false;
			$scope.loadSection();

		}
	}
	

    $scope.getIdTeacher();
	$scope.loadStudents();
	
	

   
	
	
	

	
	/*
	$scope.statements=[];
	$scope.students=[];
	$scope.coordinadorOK = true;
	
	$scope.loadSections = function(){
        $http.get('http://localhost:2323/sections').then(function(response){
			$scope.sections = response.data;
			console.log(sections);

        });
    };
	$scope.loadSections();
	 no se si causaba conflicto
	$scope.loadSection = function(idteacher){
        $http.get('http://localhost:2323/sections/getSectionsByTeacher/'+ idteacher).then(function(response){
            $scope.sections = response.data;

        });
	};
	
	//idSection
	$scope.loadStudents = function(idSection){
		$http.get('http://localhost:2323/students/getStatementsByStudent/'+idSection).then(function(response){
			$scope.students = response.data;
			console.log(students);

        });
	};
	//idStudent
	$scope.loadStatements = function(idStudent){
		$http.get('http://localhost:2323/statements/getStatementsByStudent/'+ idStudent).then(function(response){
			$scope.statements = response.data;
			console.log(statments)

        });
	};
	$scope.showStudents = function(section){
		$scope.loadStudents(section.id);
	};

	$scope.showStatements =function(student){
		$scope.loadStatements(student.id);
	};
	*/
	

}]);
    