app.controller('StatementController', ['$location', '$scope','$http', 'userService', function($location, $scope, $http, userService) {

    $scope.pageSize = 10;
    $scope.currentPage = 1;
    $scope.statements = [];
    $scope.saveOk = false;
    $scope.statement = {};

    $scope.dateUpdate = function()
    {
        var year, month, day;
        year = new Date().getFullYear().toString();
        month = (new Date().getMonth() + 1).toString()
        if(month.length == 1){
            month = "0" + month;
        }
        day = new Date().getDate().toString()
        if (day.length == 1) {
            day = "0" + day;
        }

        return year + "-" + month + "-" + day;   
    };


    $scope.loadStatements = function(){
        $http.get('http://localhost:2323/statements').then(function(response){
            $scope.statements = response.data;
        });
    };

    $scope.loadStatements();

    $scope.saveStatement = function(){
        var date = $scope.dateUpdate();
        var statement = {
            "statementText":$scope.textArea,
            "title": $scope.titleStatement,
            "input": $scope.inputStatement,
            "solution": $scope.solutionStatement,
            "date":date
        }
        $http.post('http://localhost:2323/statements/2', statement);
        return Alert.render("¡¡Enunciado grabado con exito!!");
    };


    $scope.createStatement = function(){
        if($scope.sectionForm.$valid){
            $scope.saveStatement();
            $scope.saveOk = true;
            $scope.textArea = '';
        }
        else{
            return Alert.render("se deben rellenar todos los campos");
        }
    };
    
    $scope.exit = function(){
        $scope.saveOk = false;
    };
    
    $scope.setIdStatement = function(){
        userService.valueNew($scope.id_statement);
    };

    $scope.seeStat = function(){
        $scope.idStatement = idStatementService;
    };
}]);
