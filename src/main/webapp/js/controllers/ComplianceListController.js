// START - USED SERVICES
/*
 *	ComplianceService.delete
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 *	ComplianceService.list
 *		PARAMS: 
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * ComplianceService  
 */
// END - REQUIRED RESOURCES


//CRUD LIST FOR [object Object]

app.controller('ComplianceListController', ['$scope', 'ComplianceService',
    function ($scope, ComplianceService ) {
		
    	$scope.list = ComplianceService.query();
    	
}]);