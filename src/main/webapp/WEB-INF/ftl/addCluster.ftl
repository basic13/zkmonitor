<#import "common.ftl" as p>

<#assign footerContent>
<script>
var app = angular.module('addCluster', []);
app.controller('addClusterController', function($scope) {
    $scope.watchingPathsThreshold = 300;
    $scope.avgLatencyThreshold = 1000;
    $scope.maxLatencyThreshold = 5000;
    $scope.aliveConnectionsThreshold = 500;
    $scope.outstandingRequestsThreshold = 20;
    $scope.znodeCountThreshold = 2000;
    $scope.watchCountThreshold = 500;
    $scope.openFileDescriptorCountThreshold = 500;
});

//验证IP
function isValidIP(ip){
    return  /^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)$/.test(ip);
}

//验证端口
function isValidPort(port){
    if(isNaN(port)){
        return false;
    }
    
    var portNum = parseInt(port);
    if(portNum >= 1 && portNum <= 65535){
        return true;
    }
    
    return false;
}

$(document).ready(function(){
//添加Server
$('#addServer').click(function(){
    var rownum = $('#serverTable tbody tr').length + 1;
    var row = '<tr>';
    row += '<th scope="row">' + rownum + '</th>';
    row += '<td><input type="text" placeholder="IP"></td>';
    row += '<td><input type="number" placeholder="端口"></td>';
    row += '<td><button type="button" class="btn btn-danger btn-delete btn-raised"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除</button></td>';
    row += '</tr>';
    $('#serverTable tbody').append(row);
    
    $('.btn-delete').click(function(){
        var rowIndex = this.parentNode.parentNode.rowIndex - 1;
        var trs = $('#serverTable tbody tr');
        this.parentNode.parentNode.parentNode.deleteRow(rowIndex);
        var ths = $('#serverTable tbody tr th');
        for(var i = 0, len = ths.length; i < len; i++){
            $(ths[i]).text(i + 1);
        }
    });
 });
 
$('#submit').click(function(){
	var postData = {};
    var cluster = {};
	var clusterName = $('#clusterName').val().trim();
	if(clusterName == ""){
		$('#clusterName').focus();
		return;
	}
	
	cluster.clusterName = clusterName; 
	cluster.description = $('#clusterDescription').val().trim(); 
	postData.cluster = cluster;
	
	postData.servers = [];
	var serverTable = $('#serverTable tbody tr');
	if(serverTable.length == 0){
		alert('节点列表不能为空');
		return;
	}
	
    for (var i = 0, len = serverTable.length; i < len; i++) {
        var ip = $(serverTable[i]).find('input:eq(0)').val();
        var port = $(serverTable[i]).find('input:eq(1)').val();
        var server = {};
        server.serverIp = ip;
        server.serverPort = port;
        
        if(ip.trim() == ''){
        	alert('IP不能为空');
            return;
        }
        else if(!isValidIP(ip)){
            alert('无效的IP: ' + ip);
            return;
        }
        
        if(port.trim() == ''){
        	alert('端口不能为空');
            return;
        }
        else if(!isValidPort(port)){
            alert('无效的端口: ' + port);
            return;
        }
        
        postData.servers.push(server);
    };
	
	var alarmConfig = {};
	var watchingPathsThreshold = $('#watchingPathsThreshold').val().trim();
	if(watchingPathsThreshold == ""){
		$('#watchingPathsThreshold').focus();
		return;
	}
	alarmConfig.watchingPathsThreshold = watchingPathsThreshold;
	
	var avgLatencyThreshold = $('#avgLatencyThreshold').val().trim();
	if(avgLatencyThreshold == ""){
		$('#avgLatencyThreshold').focus();
		return;
	}
	alarmConfig.avgLatencyThreshold = avgLatencyThreshold;
	
	
	var maxLatencyThreshold = $('#maxLatencyThreshold').val().trim();
	if(maxLatencyThreshold == ""){
		$('#maxLatencyThreshold').focus();
		return;
	}
	alarmConfig.maxLatencyThreshold = maxLatencyThreshold;
	
	var aliveConnectionsThreshold = $('#aliveConnectionsThreshold').val().trim();
	if(aliveConnectionsThreshold == ""){
		$('#aliveConnectionsThreshold').focus();
		return;
	}
	alarmConfig.aliveConnectionsThreshold = aliveConnectionsThreshold;
	
	var outstandingRequestsThreshold = $('#outstandingRequestsThreshold').val().trim();
	if(outstandingRequestsThreshold == ""){
		$('#outstandingRequestsThreshold').focus();
		return;
	}
	alarmConfig.outstandingRequestsThreshold = outstandingRequestsThreshold;
	
	var znodeCountThreshold = $('#znodeCountThreshold').val().trim();
	if(znodeCountThreshold == ""){
		$('#znodeCountThreshold').focus();
		return;
	}
	alarmConfig.znodeCountThreshold = znodeCountThreshold;
	
	var watchCountThreshold = $('#watchCountThreshold').val().trim();
	if(watchCountThreshold == ""){
		$('#watchCountThreshold').focus();
		return;
	}
	alarmConfig.watchCountThreshold = watchCountThreshold;
	
	var openFileDescriptorCountThreshold = $('#openFileDescriptorCountThreshold').val().trim();
	if(openFileDescriptorCountThreshold == ""){
		$('#openFileDescriptorCountThreshold').focus();
		return;
	}
	alarmConfig.openFileDescriptorCountThreshold = openFileDescriptorCountThreshold;
	
	var receiver = $('#receiver').val().trim();
	if(receiver == ""){
		$('#receiver').focus();
		return;
	}
	alarmConfig.receiver = receiver;
    postData.alarmConfig = alarmConfig;
    
    $.ajax({
    	url: '/rest/clusters',
    	type: "POST",
    	data: JSON.stringify(postData),
    	contentType:"application/json; charset=utf-8",
  		dataType:"json",
	    success: function (data) {
			if(data.success){
				document.location.href = "/cluster/view";
			} else {
				alert(data.message);
			}
	    }
	});
});

 	$('#addServer').click();
 });
</script>
</#assign>

<@p.page title="添加集群" footer=footerContent appName="addCluster">
        <form data-ng-controller="addClusterController" name="clusterForm" novalidate>
            <div>
            <legend>1、创建集群</legend>
            
<div class="form-group label-floating has-info">
  <label class="control-label" for="clusterName">集群名称</label>
  <input class="form-control" id="clusterName" type="text" required data-ng-model="clusterName" name="clusterName">
  <span style="color:red" ng-show="clusterForm.clusterName.$dirty && clusterForm.clusterName.$invalid">
  <span ng-show="clusterForm.clusterName.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>
            
<div class="form-group label-floating has-info">
  <label class="control-label" for="clusterDescription">集群描述</label>
  <input class="form-control" id="clusterDescription" type="text" data-ng-model="clusterDescription">
</div>
            </div>
  
            <div>
<legend>2、添加节点</legend>
    <div class="form-group" id="form-2">
        <button type="button" class="btn btn-info btn-raised" id="addServer"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加</button>
    </div>
<div class="form-group">
              <table class="table table-bordered" id="serverTable" data-container="body" data-toggle="popover" data-placement="top">
                  <thead>
                    <tr>
                      <th>NO.</th>
                      <th>IP</th>
                      <th>端口</th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                  </tbody>
              </table>
          </div>
            </div>

            <div>
<legend>3、配置报警</legend>
<div class="form-group label-floating has-info">
  <label class="control-label" for="watchingPathsThreshold">Watching Path阈值</label>
  <input class="form-control" id="watchingPathsThreshold" type="number" min="1" required data-ng-model="watchingPathsThreshold" name="watchingPathsThreshold">
  <span style="color:red" data-ng-show="clusterForm.watchingPathsThreshold.$dirty && clusterForm.watchingPathsThreshold.$invalid">
  <span data-ng-show="clusterForm.watchingPathsThreshold.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>

<div class="form-group label-floating has-info">
  <label class="control-label" for="avgLatencyThreshold">平均延迟阈值(ms)</label>
  <input class="form-control" id="avgLatencyThreshold" type="number" min="1" required data-ng-model="avgLatencyThreshold" name="avgLatencyThreshold">
  <span style="color:red" data-ng-show="clusterForm.avgLatencyThreshold.$dirty && clusterForm.avgLatencyThreshold.$invalid">
  <span data-ng-show="clusterForm.avgLatencyThreshold.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>
<div class="form-group label-floating has-info">
  <label class="control-label" for="maxLatencyThreshold">最大延迟阈值(ms)</label>
  <input class="form-control" id="maxLatencyThreshold" type="number" min="1" required data-ng-model="maxLatencyThreshold" name="maxLatencyThreshold">
  <span style="color:red" data-ng-show="clusterForm.maxLatencyThreshold.$dirty && clusterForm.maxLatencyThreshold.$invalid">
  <span data-ng-show="clusterForm.maxLatencyThreshold.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>
<div class="form-group label-floating has-info">
  <label class="control-label" for="aliveConnectionsThreshold">连接数阈值</label>
  <input class="form-control" id="aliveConnectionsThreshold" type="number" min="1" required data-ng-model="aliveConnectionsThreshold" name="aliveConnectionsThreshold">
  <span style="color:red" data-ng-show="clusterForm.aliveConnectionsThreshold.$dirty && clusterForm.aliveConnectionsThreshold.$invalid">
  <span data-ng-show="clusterForm.aliveConnectionsThreshold.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>
<div class="form-group label-floating has-info">
  <label class="control-label" for="outstandingRequestsThreshold">Outstanding Request阈值</label>
  <input class="form-control" id="outstandingRequestsThreshold" type="number" min="1" required data-ng-model="outstandingRequestsThreshold" name="outstandingRequestsThreshold">
  <span style="color:red" data-ng-show="clusterForm.outstandingRequestsThreshold.$dirty && clusterForm.outstandingRequestsThreshold.$invalid">
  <span data-ng-show="clusterForm.outstandingRequestsThreshold.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>
<div class="form-group label-floating has-info">
  <label class="control-label" for="znodeCountThreshold">ZNode数阈值</label>
  <input class="form-control" id="znodeCountThreshold" type="number" min="1" required data-ng-model="znodeCountThreshold" name="znodeCountThreshold">
  <span style="color:red" data-ng-show="clusterForm.znodeCountThreshold.$dirty && clusterForm.znodeCountThreshold.$invalid">
  <span data-ng-show="clusterForm.znodeCountThreshold.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>
<div class="form-group label-floating has-info">
  <label class="control-label" for="watchCountThreshold">Watch数阈值</label>
  <input class="form-control" id="watchCountThreshold" type="number" min="1" required data-ng-model="watchCountThreshold" name="watchCountThreshold">
  <span style="color:red" data-ng-show="clusterForm.watchCountThreshold.$dirty && clusterForm.watchCountThreshold.$invalid">
  <span data-ng-show="clusterForm.watchCountThreshold.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>
<div class="form-group label-floating has-info">
  <label class="control-label" for="openFileDescriptorCountThreshold">最大文件描述符打开数阈值</label>
  <input class="form-control" id="openFileDescriptorCountThreshold" type="number" min="1" required data-ng-model="openFileDescriptorCountThreshold" name="openFileDescriptorCountThreshold">
  <span style="color:red" data-ng-show="clusterForm.openFileDescriptorCountThreshold.$dirty && clusterForm.openFileDescriptorCountThreshold.$invalid">
  <span data-ng-show="clusterForm.openFileDescriptorCountThreshold.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>
<div class="form-group label-floating has-info">
  <label class="control-label" for="receiver">报警接收人(填写花名汉字，多个联系人之间用";"分隔)</label>
  <input class="form-control" id="receiver" type="text" required data-ng-model="receiver" name="receiver">
  <span style="color:red" data-ng-show="clusterForm.receiver.$dirty && clusterForm.receiver.$invalid">
  <span data-ng-show="clusterForm.receiver.$error.required"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> 必填</span>
</div>
</div>
            
            
 <div class="form-group">
      <div class="col-md-20 col-md-offset-5">
        <button type="submit" id="submit" class="btn btn-lg btn-success btn-raised"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 提交</button>
      </div>
    </div>
</form>
</@p.page>
