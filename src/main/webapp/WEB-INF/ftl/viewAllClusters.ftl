<#import "common.ftl" as p>

<#assign footerContent>
<script>
var app = angular.module('viewAllClusters', []);
app.controller('viewAllClustersController', function($scope, $http) {
	$scope.viewCluster = function() {
		var clusterId = this.record.cluster.clusterId;
		document.location.href = "/cluster/view/" + clusterId;
	};
	
	$scope.editCluster = function() {
		var clusterId = this.record.cluster.clusterId;
		document.location.href = "/cluster/edit/" + clusterId;
	};
	
	$scope.deleteCluster = function() {
		if(confirm('确定要删除 ' + this.record.cluster.clusterName + ' 吗？') == true)
		{
	    	var clusterId = this.record.cluster.clusterId;
	    	$http.delete("/rest/clusters/" + clusterId).success(function(response) {
	    		document.location.href = "/cluster/view";
			});
		}
	};
	$scope.overViewCluster = function() {
	    var clusterId = this.record.cluster.clusterId;
	    document.location.href = "/cluster/overview/" + clusterId;
	};

    $http.get("/rest/clusters").success(function(response) {
    	$scope.records = response;
	});
});

</script>
</#assign>

<@p.page title="集群列表" footer=footerContent appName="viewAllClusters">
	<h1><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> 集群列表</h1>
	<div data-ng-controller="viewAllClustersController">
        <table class="table table-bordered" id="clusterTable" data-container="body" data-toggle="popover" data-placement="top">
          <thead>
            <tr>
              <th>ID</th>
              <th>名称</th>
              <th>描述</th>
              <th>节点数</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
          	<tr data-ng-repeat="record in records">
			    <td >{{record.cluster.clusterId}}</a></td>
			    <td><a class="btn btn-link btn-xs" data-ng-click="overViewCluster()"> {{record.cluster.clusterName}}</a></td>
			    <td>{{record.cluster.description}}</td>
			    <td>{{record.servers.length}}</td>
			    <td>
			    	<button type="button" class="btn btn-info btn-raised" data-ng-click="viewCluster()"><span class="glyphicon glyphicon-search"></span> 查看</button>
			    	<button type="button" class="btn btn-primary btn-raised" data-ng-click="editCluster()"><span class="glyphicon glyphicon-pencil"></span> 编辑</button>
			    	<button type="button" class="btn btn-danger btn-raised" data-ng-click="deleteCluster()"><span class="glyphicon glyphicon-trash"></span> 删除</button>
			    </td>
			</tr>
          </tbody>
      </table>
    </div>

</@p.page>
