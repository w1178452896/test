<#if blogVoList ? exists>
    <#list blogVoList as blogVo>
<div class="content">
    <div class="text-right">
        <span>${(blogVo.user.username)!}</span>
    </div>
    <div class="media">
        <div class="media-body">
            <div class="media-heading"><a href="/blog/${blogVo.blog.id}">${(blogVo.blog.title)!}</a></div>
            <div class="content-p">
                <p>${(blogVo.blog.content?substring(0, 100))!"获取数据失败"}......</p>
            </div>
        </div>
        <div class="media-right media-middle">
            <a href="#">
                <!--<img class="media-object" src="..." alt="...">-->
                <div class="media-object authorHead">
                    <img src="/resources/head.png" alt="图像无法显示">
                </div>
            </a>
            <br>
            <button class="btn btn-default btn-sm center-block">
                <span class="glyphicon glyphicon-heart" style="color: red"></span> 关注
            </button>
        </div>
    </div>
    <div.content-info>
        收藏&nbsp;<span class="label label-primary">${(blogVo.userCount)!0}</span> &nbsp;|&nbsp;<span
            class="label label-info">${(blogVo.blog.createTime)!"2018-01-01"}</span>
    </div.content-info>
</div>
    </#list>
</#if>
