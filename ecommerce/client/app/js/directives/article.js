'use strict';

angular.module('ecommerce')
  .directive('article', function () {
    return {
      restrict: 'E',
      templateUrl: 'html/directives/article.html',
      controllerAs: 'articleVM',
      scope: {},
      bindToController: {
        article: "="
      },
      //TODO: get article from a list
      controller: function () {
        this.article = {
          title: "Article title",
          description: "This is a description"
        }
      }
    }
  });