app.controller('UserController', function($scope, userService){

	$scope.setUser = function() {
    userService.newUser($scope.userEmail);
  };
});