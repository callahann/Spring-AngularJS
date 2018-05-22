app.controller('MainController', ['$scope','$location','$http','userService',function($scope,$location,$http,userService) {

	$scope.datauser = {};
    $scope.table = {};

    $scope.pages = [
        {"text":"Escribir codigo libre", "link":"#!/freecode", "condition":$scope.freecode}
    ];
    $scope.email = "";
    $scope.studentFound = 0;

    $scope.title = "App";
    $scope.studentPage = $location.path() === '/statements';
    $scope.freecode = $location.path() === '/freecode';
    $scope.upstatementPage = $location.path() === '/upstatement';
    $scope.sectionPage = $location.path() === '/section';
    $scope.registerPage = $location.path() === '/register';
    $scope.dashPage = $location.path() === 'dashboard';




    $scope.loadUser = function(){
        $http.get('http://localhost:2323/user').then(function(response){
            $scope.datauser = response.data;
            //////////////////////////////////////////////////////////////////////
            userService.logUser($scope.datauser.userAuthentication.details.email);
            $scope.email = $scope.datauser.userAuthentication.details.email;
            console.log($scope.datauser.userAuthentication.details.email);
            //console.log($scope.email);
        });
    };

		$scope.logout = function() {
				console.log("Logout correcto : ");
				console.log($scope.datauser);
				console.log("saddsa");
				$scope.datauser = null;
				document.location.href = "https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:2323";
				return $http.post('http://localhost:2323/logout',$scope.datauser = null);

		};

    $scope.loadStudent = function(){
        $http.get('http://localhost:2323/students').then(function(response){
            $scope.table = response.data;

            var i;
            for (i = 0; i < $scope.table.length; i++) {
                if($scope.email.localeCompare($scope.table[i].email) == 0){
                    console.log("student founded");
                    $scope.datauser = $scope.table[i];
                    $scope.studentFound = 1;
                    $scope.pages = [
                        {"text":"Ver enunciados", "link":"#!/statements", "condition":$scope.studentPage},
                        {"text":"Escribir codigo libre", "link":"#!/freecode", "condition":$scope.freecode}
                    ]
                    break;
                }
            }
        });
    };

    $scope.loadTeacher = function(){
        $http.get('http://localhost:2323/teachers').then(function(response){
            $scope.table = response.data;

            var i;
            for (i = 0; i < $scope.table.length; i++) {
                if($scope.email.localeCompare($scope.table[i].email) == 0){
                    console.log("teacher or coordinator founded");
                    $scope.datauser = $scope.table[i];
                    //if is coordinator.
                    if($scope.datauser.coordinator == 1){
                        console.log("coordinator");
                        $scope.pages = [
                        {"text":"Registrar Nuevo Usuario", "link":"#!/register", "condition":$scope.registerPage},
                        {"text":"Crear Sección", "link":"#!/section", "condition":$scope.sectionPage},
                        {"text":"Ingresar Nuevo Enunciado", "link":"#!/upstatement", "condition":$scope.upstatementPage},
                        {"text":"Visualizar Participación", "link":"#!/dashboard", "condition":$scope.dashPage}
                        ]
                        return;
                    }
                    else{
                        console.log("teacher");
                        $scope.pages = [
                        {"text":"Registrar un usuario", "link":"#!/register", "condition":$scope.registerPage},
                        {"text":"Crear Enunciado", "link":"#!/upstatement", "condition":$scope.upstatementPage}
                        ]
                        return;
                    }
                    break;
                }
            };
            $scope.pages = [
                {"text":"Escribir codigo libre", "link":"#!/freecode", "condition":$scope.freecode}
            ]
        });
    };

    $scope.verifyTypeUser = function(){

        $scope.loadUser();
        $scope.loadStudent();
        if($scope.studentFound == 0){
            $scope.loadTeacher();
        }
    };

    $scope.verifyTypeUser();
    //name {{datauser.userAuthentication.details.name}}
    //email {{datauser.userAuthentication.details.email}}
	$scope.title = "App";

}]);
