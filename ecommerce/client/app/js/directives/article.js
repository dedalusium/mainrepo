'use strict';

angular.module('ecommerce')
  .directive('article', function () {
    return {
      restrict: 'E',
      templateUrl: 'html/directives/article.html'
    }
  });