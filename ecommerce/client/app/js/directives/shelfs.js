'use strict';

angular.module('ecommerce')
  .directive('shelfs', function () {
    return {
      restrict: 'E',
      templateUrl: 'html/directives/shelfs.html',
      controllerAs: 'shelfsVM',
      scope : {},
      bindToController: {
        shelfList : '='
      },
      controller: function () {
        //TODO: get from future shelf service
        this.shelfList = [
          {
            name: "shelf 1",
          },
          {
            name: "shelf 2",
          },
          {
            name: "shelf 3",
          },
          {
            name: "shelf 4",
          }
        ]
      }
    }
  });