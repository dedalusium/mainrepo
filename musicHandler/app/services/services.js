'use strict';

angular.module('musicHandlerServices', ['ngResource'])

    .factory('Track', ['$resource',
        function ($resource) {
            return $resource('/app/components/track/:trackId.json', {}, {
                //params contient la liste des valeurs par defaut des parametres de l url
                trackList: {
                    method: 'GET',
                    params: {
                        trackId: "trackList"
                    },
                    isArray: true
                }
            })
                ;
        }])
;