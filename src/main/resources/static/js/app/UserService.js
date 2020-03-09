'use strict'

angular.module('demo.services', []).factory('DeviceService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getDevicesById = function(deviceId) {
				var url = CONSTANTS.getDevicesById + userId;
				return $http.get(url);
			}
			service.getAllDevices = function() {
				return $http.get(CONSTANTS.getAllUsers);
			}
			service.createOrUpdateDevice = function(userDto) {
				return $http.post(CONSTANTS.getDevices, userDto);
			}
			return service;
		} ]);