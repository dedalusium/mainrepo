'use strict';

// Declare app level module which depends on views, and components
var myapp = angular.module('ecommerce', ['ui.router']);
myapp.config(function ($stateProvider, $urlRouterProvider) {
  //
  // For any unmatched url, redirect to /
  $urlRouterProvider.otherwise("/index");
  //
  // Now set up the states
  $stateProvider
    .state('index', {
      url: "/index",
      templateUrl: "main.html"
    })
});

myapp.run(function ($rootScope) {
  $rootScope.$on("$stateChangeError", console.log.bind(console));
});