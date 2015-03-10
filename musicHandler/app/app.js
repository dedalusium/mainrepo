'use strict';

// Declare app level module which depends on views, and components
var musicHandler = angular.module('musicHandler', [
    'ngRoute',
    'trackList',
    'track'
]);

musicHandler.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $routeProvider.otherwise({redirectTo: '/trackList'});
    //$locationProvider.html5Mode(true);
}]);

musicHandler
    .controller('Controller', ['$scope', function ($scope) {
    $scope.name = 'Tobias';
}])
    .directive('myDialog', function () {
        return {
            restrict: 'E',
            transclude: true,
            scope: {},
            templateUrl: 'my-dialog.html',
            link: function (scope, element) {
                scope.name = 'Jeff';
            }
        };
    });