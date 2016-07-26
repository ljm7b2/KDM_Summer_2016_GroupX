angular.module('app.controllers', ['PointService'])
  
.controller('homeCtrl', function($scope, Points) {
           
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
        return Points.pts();
    }
    
    $scope.initMap();
})
   
.controller('aboutCtrl', function($scope) {

})
   
.controller('contactCtrl', function($scope, $http) {
    
    $scope.queryText1 = "";
    $scope.queryText2 = "";
    $scope.queryText3 = "";
    $scope.queryText4 = "";
    $scope.userQuery = "";
    
    
    
    $scope.getSelect1 = function(select){
        console.log(select)
        $scope.queryText2 = select
        $scope.queryText1 = select + " " + $scope.queryText3 + " " + $scope.queryText4 + "?"
    }

    $scope.getSelect2 = function(select){
        console.log(select)
        $scope.queryText3 = select
        $scope.queryText1 = $scope.queryText2 + " " + select + " " + $scope.queryText4 + "?"
    }
    $scope.getSelect3 = function(select){
        console.log(select)
        $scope.queryText4 = select
        $scope.queryText1 = $scope.queryText2 + " " + $scope.queryText3 + " " + select + "?"
    }
    
    $scope.buildQuery = function(){
        console.log("hello world")
        
        $scope.select1 = "SELECT ?i WHERE { "
        $scope.select2 = ""
        $scope.select3 = ""
        $scope.selectType = ""
        console.log($scope.queryText2)
        $scope.sparqlQuery = ""
        
        if($scope.queryText3 == "are the symptoms of"){
            $scope.select2 = " d:" + $scope.queryText4 
            $scope.select3 = " d:hasSymptoms ?i} "
            console.log($scope.select1 + $scope.select2 + $scope.select3)
            $scope.sparqlQuery = $scope.select1 + $scope.select2 + $scope.select3
            $scope.getAnswer( $scope.select1 + $scope.select2 + $scope.select3 )
            
            
        }else if($scope.queryText3 == "body parts are affected by"){
            $scope.select2 = " d:" + $scope.queryText4
            $scope.select3 = " d:isAffected ?i} "
            console.log($scope.select1 + $scope.select2 + $scope.select3)
            $scope.sparqlQuery = $scope.select1 + $scope.select2 + $scope.select3
            $scope.getAnswer( $scope.select1 + $scope.select2 + $scope.select3 )
            
        }else if($scope.queryText3 == "is the cause of"){
            $scope.select2 = " d:" + $scope.queryText4
            $scope.select3 = " d:CausesOf ?i} "
            console.log($scope.select1 + $scope.select2 + $scope.select3)
            $scope.sparqlQuery = $scope.select1 + $scope.select2 + $scope.select3
            $scope.getAnswer( $scope.select1 + $scope.select2 + $scope.select3 )
            
        }else if($scope.queryText3 == "are the types of"){
            $scope.selectType = "?i rdf:type d:" + $scope.queryText4 + "} "
            $scope.sparqlQuery = $scope.select1 + $scope.selectType
            $scope.getAnswer( $scope.select1 + $scope.selectType )
            
        }else{
            console.log("There is an error in query 1")
        }
        
    }
    
    $scope.getAnswer = function(query){
        var link = "http://localhost:8080/QAServer/QueryOntology?query=" + query
        console.log(link)
        $scope.answers = []
        $http.get(link).then(function (response){
            
            for(var i = 0; i <= response.data.total; i++){
                var item = {
                    answer: response.data["Result_" + i]
                };
                $scope.answers.push(item)
            }
            console.log($scope.answers)
        });       
    }
    
})

.controller('chartJS', function($scope){
    $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
    $scope.series = ['Series A', 'Series B'];
    $scope.data = [
        [65, 59, 80, 81, 56, 55, 40],
        [28, 48, 40, 19, 86, 27, 90]
    ];
})
    