<div class="content">
    <div class="text-right">
        <span>${authorName!"authorName"}</span>
    </div>
    <div class="media">
        <div class="media-body">
            <div class="media-heading">${title!"title"}</div>
            <div class="content-p">
                <p>${content!"文章信息无法显示"}...</p>
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
            <button class="btn btn-default btn-sm center-block"><span class="glyphicon glyphicon-heart" style="color: red"></span> 关注</button>
        </div>
    </div>
    <div.content-info>
        收藏&nbsp;<span class="label label-primary">${collection!0}</span> &nbsp;|&nbsp;<span class="label label-info">${createTime!"2018-01-01"}</span>
    </div.content-info>
</div>