'use strict';

angular.module('track', ['ngRoute', 'ngResource'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/track/:trackId', {
            templateUrl: 'components/track/track.html',
            controller: 'TrackCtrl'
        });
    }])

    .controller('TrackCtrl', ['$scope','$routeParams', 'Track', function ($scope, $routeParams ,Track) {
        $scope.track = Track.get({trackId:$routeParams.trackId});
        $scope.editInfoMode = false;
        $scope.editTabsMode = false;
        $scope.editLyricsMode = false;
        $scope.infoButtonText = "Edit";
        $scope.tabsButtonText = "Edit";
        $scope.lyricsButtonText = "Edit";
        $scope.switchInfoMode = function(){
            $scope.editInfoMode = !$scope.editInfoMode;
            $scope.infoButtonText == "Save" ? $scope.infoButtonText = "Edit" : $scope.infoButtonText = "Save";
        }
        $scope.switchTabsMode = function(){
            $scope.editTabsMode = !$scope.editTabsMode;
            //$scope.readMode = !$scope.readMode;
            $scope.tabsButtonText == "Save" ? $scope.tabsButtonText = "Edit" : $scope.tabsButtonText = "Save";
        }
        $scope.switchLyricsMode = function(){
            $scope.editLyricsMode = !$scope.editLyricsMode;
            //$scope.readMode = !$scope.readMode;
            $scope.lyricsButtonText == "Save" ? $scope.lyricsButtonText = "Edit" : $scope.lyricsButtonText = "Save";
        }
    }])