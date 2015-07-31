app = angular.module('app', ['ui.router']);

app.config(function($urlRouterProvider) {
  $urlRouterProvider.otherwise('/');
});