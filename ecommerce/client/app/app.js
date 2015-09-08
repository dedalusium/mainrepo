'use strict';

// Declare app level module which depends on views, and components
var myapp = angular.module('ecommerce', ['ui.router']);
myapp.config(function ($stateProvider, $urlRouterProvider) {

  // For any unmatched url, redirect to /index
  $urlRouterProvider.otherwise("/index");

  $stateProvider.state({
    name: 'index',
    url: "/index",
    views: {
      '': {templateUrl: 'html/views/main.html'},
      'header@index': {
        templateUrl: "html/views/header.html",
        controller: function ($scope) {

        }
      },
      'leftSidebar@index': {
        templateUrl: "html/views/leftSidebar.html",
        controller: function ($scope) {
          $scope.shelfList = {};
        }
      },
      'content@index': {
        templateUrl: "html/views/content.html",
        controller: function ($scope) {
          $scope.articleList = [
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}
          ];
        }
      },
      'rightSidebar@index': {
        templateUrl: "html/views/rightSidebar.html",
        controller: function ($scope) {

        }
      },
      'footer@index': {
        templateUrl: "html/views/footer.html",
        controller: function ($scope) {

        }
      }
    }
  });

});

myapp.run(function ($rootScope) {
  $rootScope.$on("$stateChangeError", console.log.bind(console));
});