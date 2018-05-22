app.controller('TasksController', ['$scope','$http', function($scope,$http) {

    $scope.pageSize = 10;
    $scope.currentPage = 1;
    $scope.tasks = [];
    $scope.saveOk = false;

    $scope.loadCodes = function(){
        $http.get('http://localhost:2323/codes').then(function(response){
            $scope.codes = response.data;
        });
    };

    $scope.loadCodes();

    $scope.saveCode = function(){
        var code = {
            "codeText":$scope.textArea
        }

        return $http.post('http://localhost:2323/codes/1', code);
    };


    $scope.createCodes = function(){
        if($scope.sectionForm.$valid){
            $scope.saveCode();
            $scope.saveOk = true;
            $scope.textArea = '';
        }
    };
    
    $scope.exit = function(){
        $scope.saveOk = false;
    }
    
}]);
