app.config(function($urlRouterProvider, $stateProvider) {

  $stateProvider
    .state('app', {
      url: '',
      abstract: true,
      templateUrl: '/app/main.html'
    })

});