var app = angular.module('tingeso',['ngRoute', 'ui.bootstrap']);

app.config(function($routeProvider){
    $routeProvider

        .when('/login', {
            templateUrl: 'js/views/login.html',
            controller: 'UserController'
        })

        .when('/log', {
            templateUrl: 'js/views/logued.html',
            controller: 'LoginController'
        })

        .when('/freecode',{
            templateUrl: 'js/views/freeCode.html'
        })

        .when('/statements',{
            templateUrl: 'js/views/statements.html',
            controller: 'StatementController'
        })

        .when('/seeStatement/:id',{
            templateUrl: 'js/views/seeStatement.html',
            controller: 'seeStatementController'
        })

        .when('/upstatement',{
            templateUrl: 'js/views/upStatement.html',
            controller: 'StatementController'
        })

        .when('/register',{
            templateUrl: 'js/views/register.html',
            controller: 'RegisterController'
        })

        .when('/section',{
            templateUrl:'js/views/section.html',
            controller: 'SectionController'
        })

        .when('/tasks',{
            templateUrl:'js/views/tasks.html',
            controller: 'TasksController'
        })

        .when('/dashboard',{
            templateUrl:'js/views/dashboard.html',
            controller: 'DashboardController'
        })

        .when('/welcome',{
            templateUrl:'js/views/welcome.html',
            //controller: 'WelcomeController'
        })

        .otherwise({
            redirectTo: '/index'
        });

});

app.filter('startFrom', function(){
	return function(data, start){
		return data.slice(start);
	}
});

app.factory('userService', function(){
    var service = {
        user: {email: '',
                id: 0},
        userDefault: function() {
            service.user['email'] = '';
            service.user['id'] = 0;
        },
        logUser: function(mail) {
            service.user.email = mail;
        },
        idUser: function(id) {
            service.user.id = id;
        }
    };
  return service;
});
