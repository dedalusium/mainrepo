'use strict';

// Declare app level module which depends on views, and components
var myapp = angular.module('ecommerce', ['ui.router']);
myapp.config(function ($stateProvider, $urlRouterProvider) {

  // For any unmatched url, redirect to /index
  $urlRouterProvider.otherwise("/");

  $stateProvider.state({
    name: 'home',
    url: "/",
    views: {
      '': {templateUrl: 'html/views/main.html'},
      'header@home': {
        templateUrl: "html/views/home/header.html",
        controller: function ($scope) {

        }
      },
      'leftSidebar@home': {
        templateUrl: "html/views/home/leftSidebar.html",
        controller: function ($scope) {
          $scope.shelfList = {};
        }
      },
      'content@home': {
        templateUrl: "html/views/home/content.html",
        controller: function ($scope) {
          $scope.articleList = [
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}
          ];
        }
      },
      'rightSidebar@home': {
        templateUrl: "html/views/home/rightSidebar.html",
        controller: function ($scope) {

        }
      },
      'footer@home': {
        templateUrl: "html/views/home/footer.html",
        controller: function ($scope) {

        }
      }
    }
  });


  $stateProvider.state({
    name: 'shelf',
    url: "/shelf",
    views: {
      '': {templateUrl: 'html/views/main.html'},
      'header@shelf': {
        templateUrl: "html/views/shelf/header.html",
        controller: function ($scope) {

        }
      },
      'leftSidebar@shelf': {
        templateUrl: "html/views/shelf/leftSidebar.html",
        controller: function ($scope) {
          $scope.shelfList = {};
        }
      },
      'content@shelf': {
        templateUrl: "html/views/shelf/content.html",
        controller: function ($scope) {
          $scope.articleList = [
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}
          ];
        }
      },
      'rightSidebar@shelf': {
        templateUrl: "html/views/shelf/rightSidebar.html",
        controller: function ($scope) {

        }
      },
      'footer@shelf': {
        templateUrl: "html/views/shelf/footer.html",
        controller: function ($scope) {

        }
      }
    }
  });

});

myapp.run(function ($rootScope) {
  $rootScope.$on("$stateChangeError", console.log.bind(console));
});