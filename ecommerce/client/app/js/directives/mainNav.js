'use strict';

angular.module('ecommerce')
  .directive('mainNav', function () {
    return {
      restrict: 'E',
      templateUrl: 'html/directives/mainNav.html'
    }
  });