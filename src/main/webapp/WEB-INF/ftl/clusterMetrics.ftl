<#import "common.ftl" as p>

<#assign headerContent>

</#assign>

<#assign footerContent>

    <script src="/resources/js/echarts-all.js"></script>

<script>

    var app = angular.module('clusterMetric',[]);

    app.controller('clusterMetricController',function($scope,$http){

    //获取集群信息
    $http.get("/rest/clusters").success(function(response) {
          $scope.clusters = response;
      });

    $scope.legend = [];
    //监听select变化,同时获取特定cluster metric数据
    $scope.clusterChange = function(selectedCluster){

        var alarmConfig = selectedCluster.alarmConfig;

      $scope.watchingPathsThreshold = alarmConfig.watchingPathsThreshold;
      $scope.avgLatencyThreshold = alarmConfig.avgLatencyThreshold;
      $scope.maxLatencyThreshold = alarmConfig.maxLatencyThreshold;
      $scope.aliveConnectionsThreshold = alarmConfig.aliveConnectionsThreshold;
      $scope.outstandingRequestsThreshold = alarmConfig.outstandingRequestsThreshold;
      $scope.znodeCountThreshold = alarmConfig.znodeCountThreshold;
      $scope.watchCountThreshold = alarmConfig.watchCountThreshold;
      $scope.openFileDescriptorCountThreshold = alarmConfig.openFileDescriptorCountThreshold;

        $scope.legend = [];
        // 监控指标的时间轴
        $scope.timeSeries = [];
        // 监控指标 {metricName:{ip1:[],
        //                     ip2:[]} }
        $scope.metricsSeriesDict = {};

         $scope.serverId2serverName = {};
         for(i in selectedCluster.servers){
             var tmpserver = selectedCluster.servers[i];
             $scope.serverId2serverName[tmpserver.serverId] = tmpserver.serverIp;
         }
        //获取数据
        $http.get("/rest/clusters/metrics/" + selectedCluster.cluster.clusterId).success(
            function(response){
              var metrics = response.serverMetricses;
              // 选取某一特定serverId server作为timeSeries
              var standTime_serverId = metrics[0].serverId;
              for( i in metrics){
                  var t_metric = metrics[i];
                // 收集时间
                  if(t_metric.serverId == standTime_serverId)
                    $scope.timeSeries.push(t_metric.collectTime);

                  for( key in t_metric){
                        var t_ip =  $scope.serverId2serverName[t_metric.serverId];
                        if ($scope.metricsSeriesDict.hasOwnProperty(key)){
                              // 监控指标 {metricName:{ip1:[],
                              //                     ip2:[]} }
                          if($scope.metricsSeriesDict[key].hasOwnProperty(t_ip)){
                            $scope.metricsSeriesDict[key][t_ip].push(t_metric[key]);
                          }else{
                            $scope.metricsSeriesDict[key][t_ip] = [];
                            $scope.metricsSeriesDict[key][t_ip].push(t_metric[key]);
                          }
                        }else{
                          $scope.metricsSeriesDict[key] = {};
                          $scope.metricsSeriesDict[key][$scope.serverId2serverName[t_metric.ServerId]] = [];
                          $scope.metricsSeriesDict[key][$scope.serverId2serverName[t_metric.ServerId]].push(t_metric[key]);

                        }
                    }
              }
              console.log("metricsSeriesDict:");
              console.log($scope.metricsSeriesDict);
              for(key in  $scope.serverId2serverName){
                $scope.legend.push($scope.serverId2serverName[key]);
              }
              var timeArray = new Array();
              for( var i in $scope.timeSeries){
                  var date = new Date($scope.timeSeries[i] * 1000);
                  // Hours part from the timestamp
                  var hours = date.getHours();
                  // Minutes part from the timestamp
                  var minutes = "0" + date.getMinutes();
                  // Seconds part from the timestamp
                  var seconds = "0" + date.getSeconds();
                  if(seconds.length > 2)
                    seconds = seconds.substr(-2);

                  var year = date.getFullYear();
                  var month = date.getMonth() + 1;
                  var day = date.getDate();
                  // Will display time in 10:30:23 format
                  var formattedTime = year + '/'+month + '/'+ day + ' ' + hours + ':' + minutes.substr(-2)+":"+seconds;

                  timeArray.push(formattedTime);
              }


              var ids = ['watchingPaths','avgLatency','maxLatency','packetsReceived','packetsSent','aliveConnections','outstandingRequests',
              'znodeCount','ephemeralsCount','approximateDataSize','openFileDescriptorCount','maxFileDescriptorCount'];
              for(i in ids){
                var id = ids[i];
                console.log(id);
                 var option = {
                      // 提示框，鼠标悬浮交互时的信息提示
                      title: {
                        text:id
                      },
                      tooltip: {
                          trigger: 'axis'
                      },
                      // 图例
                      legend: {
                          data: $scope.legend
                      },
                      toolbox: {
                          show : true,
                          feature : {
                              mark : {show: true},
                              dataView : {show: true, readOnly: false},
                              magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                              restore : {show: true},
                              saveAsImage : {show: false}
                          }
                      },
                      // 横轴坐标轴
                     dataZoom : {
                        show : true,
                        realtime: true,
                        start : 30,
                        end : 100
                      },
                      calculable : true,
                      xAxis : [
                      {
                        type : 'category',
                        boundaryGap : false,
                        data:timeArray
                      }
                      ],
                      // 纵轴坐标轴
                      yAxis: [{
                          type: 'value'
                      }],
                      // 数据内容数组
                      series: function(){
                          var serie=[];
                          for(var i=0;i<$scope.legend.length;i++){
                              var item = {
                                  name : $scope.legend[i],
                                  type: 'line',
                                  data: $scope.metricsSeriesDict[id][$scope.legend[i]]
                              };
                              serie.push(item);
                              // console.log(item.name);
                              // console.log(item.data);
                          }
                          return serie;
                      }()
                  };
                   var myChart = echarts.init(document.getElementById(id));
                   myChart.setOption(option);

                }



        });
     };

    $scope.formcheckBox = {};
    $scope.allMetric = true;
    $scope.displayThreshold = false;
    $scope.allOrNone = function(){
        if($scope.allMetric){
           for( key in $scope.formcheckBox)
                $scope.formcheckBox[key] = true;
        }else{
           for( key in $scope.formcheckBox)
                $scope.formcheckBox[key] = false;
        }
    };

   });

/*
    app.directive('myline',function() {
      
        return {
            scope: {
                id: "@",
                legend: "=",
                item: "=",
                metricsSeriesDict: "=",
                timeSeries:"="
            },
            restrict: 'E',
            template: '<div style="height:400px;"></div>',
            replace: true,
            link: function(scope,element, attrs, controller) {

                console.log(scope);
                var option = {
                    // 提示框，鼠标悬浮交互时的信息提示
                    tooltip: {
                        show: true,
                        trigger: 'item'
                    },
                    // 图例
                    legend: {
                        data: scope.legend
                    },
                    // 横轴坐标轴
                    xAxis: [{
                        type: 'category',
                        data:  scope.timeSeries
                    }],
                    // 纵轴坐标轴
                    yAxis: [{
                        type: 'value'
                    }],
                    // 数据内容数组
                    series: function(){
                        var serie=[];
                        for(var i=0;i<scope.legend.length;i++){
                            var item = {
                                name : scope.legend[i],
                                type: 'line',
                                data: scope.metricsSeriesDict[scope.id][scope.legend[i]]
                            };
                            serie.push(item);
                            console.log(item.name);
                            console.log(item.data);
                        }
                        return serie;
                    }()
                };
                var myChart = echarts.init(document.getElementById(scope.id),'macarons');
                myChart.setOption(option);
            }
        };
    });
*/


</script>

</#assign>

<@p.page title="查看监控" header=headerContent footer=footerContent appName="clusterMetric">
<div data-ng-controller="clusterMetricController">
    <h2>集群监控</h2>

        <div class="form-group label-floating has-infos">
          <label class="control-label" for="clusterName" >选择集群:</label>
                <select  id = "clusterName" class="form-control" ng-change="clusterChange(selectedCluster)"" data-style="btn-info" ng-model="selectedCluster" ng-options="cluster.cluster.clusterName for cluster in clusters"></select>
        </div>

        <h4><span class="glyphicon glyphicon-list" aria-hidden="true"></span>监控指标</h4>


         <div class="checkbox">
            <label><input type="checkbox" ng-model="formcheckBox.watchingPaths" ng-init="formcheckBox.watchingPaths=true">watchingPaths</label>
            <label><input type="checkbox" ng-model="formcheckBox.avgLatency" ng-init="formcheckBox.avgLatency=true">avgLatency</label>
            <label><input type="checkbox" ng-model="formcheckBox.maxLatency" ng-init="formcheckBox.maxLatency=true">maxLatency</label>
            <label><input type="checkbox" ng-model="formcheckBox.packetsReceived" ng-init="formcheckBox.packetsReceived=true">packetsReceived</label>
            <label><input type="checkbox" ng-model="formcheckBox.packetsSent" ng-init="formcheckBox.packetsSent=true">packetsSent</label>
            <label><input type="checkbox" ng-model="formcheckBox.aliveConnections" ng-init="formcheckBox.aliveConnections=true">aliveConnections</label>
            <label><input type="checkbox" ng-model="formcheckBox.outstandingRequests" ng-init="formcheckBox.outstandingRequests=true">outstandingRequests</label>
            <label><input type="checkbox" ng-model="formcheckBox.znodeCount" ng-init="formcheckBox.znodeCount=true">znodeCount</label>
            <label><input type="checkbox" ng-model="formcheckBox.ephemeralsCount" ng-init="formcheckBox.ephemeralsCount=true">ephemeralsCount</label>
            <label><input type="checkbox" ng-model="formcheckBox.approximateDataSize" ng-init="formcheckBox.approximateDataSize=true">approximateDataSize</label>
            <label><input type="checkbox" ng-model="formcheckBox.openFileDescriptorCount" ng-init="formcheckBox.openFileDescriptorCount=true">openFileDescriptorCount</label>
            <label><input type="checkbox" ng-model="formcheckBox.maxFileDescriptorCount" ng-init="formcheckBox.maxFileDescriptorCount=true">maxFileDescriptorCount</label>

            <label><input type="checkbox" ng-model="allMetric" ng-click="allOrNone()">All/None</label>
         </div>

         <br>
         <div class="togglebutton">
              <label>
                 <input type="checkbox" ng-model="displayThreshold"> {{displayThreshold?'关闭':'显示'}}报警阈值
              </label>
         </div>

    <h2>{{selectedCluster.cluster.clusterName}}</h2>

    <br>

        <div id = "metricGraph" class="container">
            <div class="row">
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.watchingPaths">
                <div id="watchingPaths" style="height:500px" ></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.avgLatency">
                <div id="avgLatency" style="height:500px" ></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.maxLatency">
                <div id="maxLatency" style="height:500px" ></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.packetsReceived">
                <div id="packetsReceived" style="height:500px"></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.packetsSent">
                <div id="packetsSent" style="height:500px"></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.aliveConnections">
                <div id="aliveConnections" style="height:500px"></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.outstandingRequests">
                <div id="outstandingRequests" style="height:500px"></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.znodeCount">
                <div id="znodeCount" style="height:500px"></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.ephemeralsCount">
                <div id="ephemeralsCount" style="height:500px"></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.approximateDataSize">
                <div id="approximateDataSize" style="height:500px"></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.openFileDescriptorCount">
                <div id="openFileDescriptorCount" style="height:500px"></div>
              </div>
              <div class="col-md-12" style="height:600px;" ng-show="formcheckBox.maxFileDescriptorCount">
                <div id="maxFileDescriptorCount" style="height:500px"></div>
              </div>

            </div>
        </div>




</div>


</@p.page>