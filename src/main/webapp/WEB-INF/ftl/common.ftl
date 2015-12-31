<#macro page title header="" footer="" appName="">
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>${title}</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/bootstrap-material-design.min.css">
    <link rel="stylesheet" href="/resources/css/ripples.min.css">
    
    ${header}
</head>

<body data-ng-app="${appName}">

   <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">ZooKeeper 监控系统</a>
    </div>

    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li><a href="/cluster/view">集群列表</a></li>
          
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">集群配置<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/cluster/add">添加集群</a></li>
          </ul>
        </li>
          
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">集群监控<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/cluster/metrics">查看监控</a></li>
          </ul>
        </li>
      </ul>
      
    </div>
  </div>
</nav>
    
    <div class="container" id="body">
    	<#nested>
    </div>

    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/angular.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/ripples.min.js"></script>
    <script src="/resources/js/material.min.js"></script>
    
    <script>
      $(function () {
        $.material.init();
      });
    </script>
    
    ${footer}
</body>
</html>
</#macro>