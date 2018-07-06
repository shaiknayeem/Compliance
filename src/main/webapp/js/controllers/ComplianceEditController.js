// START - USED SERVICES
/*
 *	ComplianceService.create
 *		PARAMS: 
 *		
 *
 *	ComplianceService.get
 *		PARAMS: 
 *					ObjectId id - Id 
 *		
 *
 *	ComplianceService.update
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * ComplianceService  
 */
// END - REQUIRED RESOURCES

app.controller('ComplianceEditController', ['$scope', '$location', '$routeParams', '$q', 'ComplianceService',
    function ($scope, $location, $routeParams, $q, ComplianceService ) {

    	//manage create and save
		$scope.external = {};
		
    	if ($routeParams.id != 'new')
    	{
        	$scope.id = $routeParams.id;
        	$scope.obj = ComplianceService.get({_id: $scope.id});
        	
    	}
    	else{
    		$scope.obj = new ComplianceService();
        	
    	}
    	
    	$scope.save = function(){
    		$scope.obj.$save().then(function(data){
    			$scope.obj=data;
        		$location.path('/compliances/');
    		});
    	}
    	
    	$scope.remove = function(){
    		ComplianceService.remove({_id: $scope.obj._id}).$promise.then(function(){
				$('#removeModal').modal('hide');
				$('.modal-backdrop').remove();
				$('.modal-open').removeClass("modal-open");
        		$location.path('/compliances/');
    		});
    	}
    	
}]);