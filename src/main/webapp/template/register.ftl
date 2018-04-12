<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>注册</title>
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="../js/jquery-3.3.1.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../css/login.css">
  <style>
    .title a[title=register] {
      color: #e88645;
      border-bottom: solid 3px #e88645;
    }
  </style>
</head>
<body>
<div class="sign hidden-xs">
  <h1><b><a href="/">Blog</a></b></h1>
</div>
<div class="main">
    <div class="title text-center">
      <h4>
        <span><a href="login" title="login">登录</a></span>
        <b>|</b>
        <span><a href="#" title="register">注册</a></span>
      </h4>
    </div>
  <div class="sign-container">
    <div class="container-fluid">
      <form action="">
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
          <input type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
          <input type="text" class="form-control" placeholder="密码" aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
          <input type="text" class="form-control" placeholder="确认密码" aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="row">
          <div class="col-xs-7" style="padding-right: 0">
            <input type="text" class="form-control input-lg" placeholder="验证码">
          </div>
          <div class="col-xs-5" style="padding-left: 10px">
            <img src="1.png" class="img-rounded" alt="加载验证码失败" width="99px" height="44px"/>
          </div>
        </div>
        <div class="radio">
          <label class="radio-inline">
            <input type="radio" name="sex" value="0"> 男
          </label>
          <label class="radio-inline">
            <input type="radio" name="sex" value="1"> 女
          </label>
        </div>
        <br>
        <button class="btn btn-lg btn-success btn-block" type="submit">注册</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>