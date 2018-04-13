<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/home.css">
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <title>blog</title>
</head>
<body>
<!--导航栏-->
<#include "navbar.ftl">
<div class="container">
    <div class="row">
        <div class="col-md-8 col-xs-12">
            <#--巨幕-->
            <#include "thumbnail.ftl">
            <#--首页内容-->
            <#include "content.ftl">
        </div>
        <div class="col-md-4 hidden-sm hidden-xs">
            <#--右侧-->
            <#include "sider.ftl">
        </div>
    </div>
</div>
</body>
</html>