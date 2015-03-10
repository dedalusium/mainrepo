'use strict';

angular.module('trackList', ['ngRoute','musicHandlerServices'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/trackList', {
            templateUrl: 'components/tracks/trackList.html',
            controller: 'TrackListCtrl'
        });
    }])

    .controller('TrackListCtrl', ['$scope', 'Track', function ($scope, Track) {
        $scope.tracks = Track.trackList();
    }]);