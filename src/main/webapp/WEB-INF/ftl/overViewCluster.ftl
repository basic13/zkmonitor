<#import "common.ftl" as p>

<#assign footerContent>
<script>
    var clusterId = window.location.pathname.replace(/\/cluster\/overview/, '').replace(/\//, '');

    var app = angular.module('overviewCluster',[]).config(

    function($sceProvider) {
      // Completely disable SCE.  For demonstration purposes only!
      // Do not use in new projects.
      $sceProvider.enabled(false);
    }
    );

    app.controller('overviewClusterController',function($scope,$http){
        $http.get("/rest/clusters/overview/" + clusterId).success(function(response){
            var cluster = response.cluster;
            $scope.clusterName = cluster.clusterName;
            $scope.clusterId = cluster.clusterId;
            $scope.clusterDescription = cluster.description;

            $scope.servers = response.servers;

            $scope.serverId2serverName = {};
            for(i in $scope.servers){
                var tmpserver = $scope.servers[i]
                $scope.serverId2serverName[tmpserver.serverId] = tmpserver.serverIp +":" + tmpserver.serverPort;
            }


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
            $scope.latestMetrics = response.latestServerMetricses;

        });
        $scope.server = {};
        $scope.server.show = false;
        $scope.showConfig = function(){
            var ip_port = $scope.serverId2serverName[this.metric.serverId];
            var ip = ip_port.split(':')[0];
            var port = ip_port.split(':')[1];
            if($scope.server.show && $scope.server.ip == ip){
                            $scope.server.show = false;
                            return;
            }
            $scope.server.ip = ip;
            $http.get("/rest/servers/config/?ip=" + ip + "&port=" + port).success(function(response){
                $scope.server.show = true;
                $scope.server.config = response;
            });
            $http.get("/rest/servers/connection/?ip=" + ip + "&port=" + port).success(function(response){
                            $scope.server.show = true;
                            $scope.server.connection = response;
                    });
            $http.get("/rest/servers/path/?ip=" + ip + "&port=" + port).success(function(response){
                            $scope.server.show = true;
                            $scope.server.path = response;
                    });
            $http.get("/rest/servers/session/?ip=" + ip + "&port=" + port).success(function(response){
                            $scope.server.show = true;
                            $scope.server.session = response;
                    });


            };
        });

    app.filter('checkAlive', function() {
          return function(input,threshold) {
            return input > threshold? '\u2713' : '\u2718';
          };
        });

    app.filter('checkThreshold',function(){
        return function(input,threshold){
            return input < threshold? ''+input : '<font color=\'red\'>' + input +'</font>';
        }
    });


</script>

</#assign>

<@p.page title="集群概况" footer=footerContent appName="overviewCluster">
        <div data-ng-controller="overviewClusterController">

             <div>
                 <h3><span class="glyphicon glyphicon-th" aria-hidden="true"></span> 集群概况</h3>
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
                 <h3><span class="glyphicon glyphicon-list" aria-hidden="true"></span> 节点概况</h3>
                 <p>更新时间:{{ latestMetrics[0].collectTime * 1000 | date:'yyyy-MM-dd HH:mm:ss'}}</p>
                 <h5>红色指示超出报警阈值</h5>
                <div class="form-group">
                    <table class="table table-bordered" id="serverTable" data-container="body" data-toggle="popover" data-placement="top">
                        <thead>
                            <tr>
                                <th>服务器</th>
                                <th>状态</th>
                                <th>角色</th>
                                <th>avgLatency</th>
                                <th>maxLatency</th>
                                <th>watchingPaths</th>
                                <th>packetsReceived</th>
                                <th>packetsSent</th>
                                <th>aliveConns</th>
                                <th>znodeCount</th>
                                <th>watchCount</th>
                                <th>临时节点</th>
                                <th>数据大小</th>
                                <th>文件描述数</th>
                            </tr>
                        </thead>
                        <tbody>
                  	        <tr data-ng-repeat="metric in latestMetrics">
					            <td><a class = "btn btn-link btn-xs" ng-click="showConfig()">{{serverId2serverName[metric.serverId]}}</a></td>
					            <td>{{metric.serverStatus | checkAlive:0}}</td>
					            <td>{{metric.serverMode}}</td>
					            <td><span ng-bind-html="metric.avgLatency | checkThreshold:avgLatencyThreshold"></span></td>
					            <td><span ng-bind-html="metric.maxLatency | checkThreshold:maxLatencyThreshold"></span></td>
					            <td><span ng-bind-html="metric.watchingPaths | checkThreshold:watchingPathsThreshold"></span></td>
					            <td>{{metric.packetsReceived}}</td>
					            <td>{{metric.packetsSent}}</td>
					            <td><span ng-bind-html="metric.aliveConnections | checkThreshold:aliveConnectionsThreshold"></span></td>
					            <td><span ng-bind-html="metric.znodeCount | checkThreshold:znodeCountThreshold"></span></td>
					            <td><span ng-bind-html="metric.watchCount | checkThreshold:watchCountThreshold"></span></td>
					            <td>{{metric.ephemeralsCount}}</td>
					            <td>{{metric.approximateDataSize}}</td>
					            <td><span ng-bind-html="metric.openFileDescriptorCount | checkThreshold:openFileDescriptorCountThreshold"></span></td>
					        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <h5>点击服务器↑可查看详细配置信息</h5>
            <br>
            <div ng-show="server.show">
                <h4>{{server.ip}}</h4>
                <span class="label ">点击{{configShow?'收起':'展开'}}→ </span>
                <button class = "btn  btn-success btn-lg" ng-click="configShow = !configShow " ng-init="configShow=true">
                    Config:
                </button>

                <pre ng-show="configShow">
                    {{server.config | json}}
                </pre>

                <br>
                <span class="label ">点击{{consShow?'收起':'展开'}}→ </span>
                <button class = "btn  btn-success btn-lg" ng-click="consShow = !consShow " ng-init="consShow=true">
                     Cons
                </button>

                <pre ng-show="consShow">
                     {{server.connection | json}}
                </pre>

                <br>
                <span class="label ">点击{{pathShow?'收起':'展开'}}→ </span>
                <button class = "btn  btn-success btn-lg" ng-click="pathShow = !pathShow " ng-init="pathShow=true">
                     Path
                </button>

                <pre ng-show="pathShow">
                     {{server.path | json}}
                </pre>

                <br>
                <span class="label">点击{{sessionShow?'收起':'展开'}}→ </span>
                <button class = "btn  btn-success btn-lg" ng-click="sessionShow = !sessionShow " ng-init="sessionShow=true">
                    Session:
                </button>

                <pre ng-show="sessionShow">
                     {{server.session | json}}
                </pre>
            </div>
        </div>

</@p.page>