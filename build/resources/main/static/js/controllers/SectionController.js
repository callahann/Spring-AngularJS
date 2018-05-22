app.controller('SectionController', ['$scope', '$http', function($scope, $http){

    $scope.saveOk = false;
    $scope.sections = [];
    $scope.teachers = [];    

    $scope.loadTeacher = function(){
        $http.get('http://localhost:2323/teachers').then(function(response){
            $scope.teachers = response.data;

        });
    };
    
    $scope.loadTeacher();

    $scope.saveSection = function(){
        var section = {
            "sectionCode":$scope.code
        };
        return $http.post('http://localhost:2323/sections/' + $scope.teacherSelect.idTeacher, section);
    };

    $scope.createSection = function(){
        if($scope.sectionForm.$valid){
            $scope.saveSection();
            $scope.saveOk = true;
        }
    };

    $scope.exit = function(){
        $scope.saveOk = false;
    }

}]);