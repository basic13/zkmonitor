<#import "common.ftl" as p>

<#assign footerContent>
<script>

var clusterId = window.location.pathname.replace(/\/cluster\/view/, '').replace(/\//, '');

var app = angular.module('editCluster', []);
app.controller('editClusterController', function($scope, $http) {
	
    $http.get("/rest/clusters/" + clusterId).success(function(response) {
    	var cluster = response.cluster;
    	$scope.clusterName = cluster.clusterName;
    	$scope.clusterId = cluster.clusterId;
	    $scope.clusterDescription = cluster.description;
	    $scope.servers = response.servers;
    	
    	var alarmConfig = response.alarmConfig;
    	$scope.watchingPathsThreshold = alarmConfig.watchingPathsThreshold;
	    $scope.avgLatencyThreshold = alarmConfig.avgLatencyThreshold;
	    $scope.maxLatencyThreshold = alarmConfig.maxLatencyThreshold;
	    $scope.aliveConnectionsThreshold = alarmConfig.aliveConnectionsThreshold;
	    $scope.outstandingRequestsThreshold = alarmConfig.outstandingRequestsThreshold;
	    $scope.znodeCountThreshold = alarmConfig.znodeCountThreshold;
	    $scope.watchCountThreshold = alarmConfig.watchCountThreshold;
	    $scope.openFileDescriptorCountThreshold = alarmConfig.openFileDescriptorCountThreshold;
	    $scope.receiver = alarmConfig.receiver;
	});
});

</script>
</#assign>

<@p.page title="查看集群" footer=footerContent appName="editCluster">
        <div data-ng-controller="editClusterController" name="clusterForm">
            <div>
            <h4><span class="glyphicon glyphicon-th" aria-hidden="true"></span> 集群信息</h4>
            
<div class="form-group has-info">
  <label class="control-label" for="clusterName">集群名称</label>
  <input class="form-control" id="clusterName" type="text" required data-ng-model="clusterName" name="clusterName" disabled>
</div>
            
<div class="form-group has-info">
  <label class="control-label" for="clusterDescription">集群描述</label>
  <input class="form-control" id="clusterDescription" type="text" data-ng-model="clusterDescription" disabled>
</div>
            </div>
  
            <div>
<h4><span class="glyphicon glyphicon-list" aria-hidden="true"></span> 节点配置</h4>
<div class="form-group">
              <table class="table table-bordered" id="serverTable" data-container="body" data-toggle="popover" data-placement="top">
                  <thead>
                    <tr>
                      <th>IP</th>
                      <th>端口</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<tr data-ng-repeat="server in servers">
					    <td>{{server.serverIp}}</td>
					    <td>{{server.serverPort}}</td>
					</tr>
                  </tbody>
              </table>
          </div>
            </div>

            <div>
<h4><span class="glyphicon glyphicon-bullhorn" aria-hidden="true"></span> 报警配置</h4>
<div class="form-group has-info">
  <label class="control-label" for="watchingPathsThreshold">Watching Path阈值</label>
  <input class="form-control" id="watchingPathsThreshold" type="number" min="1" required data-ng-model="watchingPathsThreshold" name="watchingPathsThreshold" disabled>
</div>

<div class="form-group has-info">
  <label class="control-label" for="avgLatencyThreshold">平均延迟阈值(ms)</label>
  <input class="form-control" id="avgLatencyThreshold" type="number" min="1" required data-ng-model="avgLatencyThreshold" name="avgLatencyThreshold" disabled>
</div>
<div class="form-group has-info">
  <label class="control-label" for="maxLatencyThreshold">最大延迟阈值(ms)</label>
  <input class="form-control" id="maxLatencyThreshold" type="number" min="1" required data-ng-model="maxLatencyThreshold" name="maxLatencyThreshold" disabled>
</div>
<div class="form-group has-info">
  <label class="control-label" for="aliveConnectionsThreshold">连接数阈值</label>
  <input class="form-control" id="aliveConnectionsThreshold" type="number" min="1" required data-ng-model="aliveConnectionsThreshold" name="aliveConnectionsThreshold" disabled>
</div>
<div class="form-group has-info">
  <label class="control-label" for="outstandingRequestsThreshold">Outstanding Request阈值</label>
  <input class="form-control" id="outstandingRequestsThreshold" type="number" min="1" required data-ng-model="outstandingRequestsThreshold" name="outstandingRequestsThreshold" disabled>
</div>
<div class="form-group has-info">
  <label class="control-label" for="znodeCountThreshold">ZNode数阈值</label>
  <input class="form-control" id="znodeCountThreshold" type="number" min="1" required data-ng-model="znodeCountThreshold" name="znodeCountThreshold" disabled>
</div>
<div class="form-group has-info">
  <label class="control-label" for="watchCountThreshold">Watch数阈值</label>
  <input class="form-control" id="watchCountThreshold" type="number" min="1" required data-ng-model="watchCountThreshold" name="watchCountThreshold" disabled>
</div>
<div class="form-group has-info">
  <label class="control-label" for="openFileDescriptorCountThreshold">最大文件描述符打开数阈值</label>
  <input class="form-control" id="openFileDescriptorCountThreshold" type="number" min="1" required data-ng-model="openFileDescriptorCountThreshold" name="openFileDescriptorCountThreshold" disabled>
</div>
<div class="form-group has-info">
  <label class="control-label" for="receiver">报警接收人</label>
  <input class="form-control" id="receiver" type="text" required data-ng-model="receiver" name="receiver" disabled>
</div>
</div>
            
</div>
</@p.page>
