angular.module('app.controllers', ['chart.js'])
  
.controller('homeCtrl', function($scope) {
           
    var map, heatmap;
    $scope.initMap = function(){
        map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: {lat: 39.8282, lng: -98.5795},
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

        heatmap = new google.maps.visualization.HeatmapLayer({
          data: $scope.getPoints(),
          map: map
        }); 
    }
    
    $scope.toggleHeatmap = function(){
        heatmap.setMap(heatmap.getMap() ? null : map);
    }
    
    $scope.changeGradient = function(){
        var gradient = [
          'rgba(0, 255, 255, 0)',
          'rgba(0, 255, 255, 1)',
          'rgba(0, 191, 255, 1)',
          'rgba(0, 127, 255, 1)',
          'rgba(0, 63, 255, 1)',
          'rgba(0, 0, 255, 1)',
          'rgba(0, 0, 223, 1)',
          'rgba(0, 0, 191, 1)',
          'rgba(0, 0, 159, 1)',
          'rgba(0, 0, 127, 1)',
          'rgba(63, 0, 91, 1)',
          'rgba(127, 0, 63, 1)',
          'rgba(191, 0, 31, 1)',
          'rgba(255, 0, 0, 1)'
        ]
        heatmap.set('gradient', heatmap.get('gradient') ? null : gradient);
    }
    
    $scope.changeRadius = function(){
        heatmap.set('radius', heatmap.get('radius') ? null : 20);
    }
    
    $scope.changeOpacity = function(){
        heatmap.set('opacity', heatmap.get('opacity') ? null : 0.2);
    }
    
    $scope.getPoints = function(){
        return[
          new google.maps.LatLng(37.782551, -122.445368),
          new google.maps.LatLng(37.782745, -122.444586),
          new google.maps.LatLng(37.782842, -122.443688),           
        ];
    }
    
    $scope.initMap();
})
   
.controller('aboutCtrl', function($scope) {

})
   
.controller('contactCtrl', function($scope) {

})

.controller('chartJS', function($scope){
    $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
    $scope.series = ['Series A', 'Series B'];
    $scope.data = [
        [65, 59, 80, 81, 56, 55, 40],
        [28, 48, 40, 19, 86, 27, 90]
    ];
})
    