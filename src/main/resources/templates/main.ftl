<#import "parts/common.ftl" as c>

<@c.page>
<div class="form-group row">
    <div class="form-group col-md6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" value="${filter!}">
            <button type="submit" class="btn btn-primary ml-2">Find</button>
        </form>
    </div>
</div>
<#if isAdmin>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="itemName" placeholder="Some Text"/>
        <input type="number" step="0.01" name="itemPrice"/>
        <input type="checkbox" name="inStock">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Post Item</button>
    </form>
</div>
</#if>

<div class="card-columns">
        <#list items as item>gi
        <div class="card my-3">
            <#if item.filename??>
            <img src="/img/${item.filename}" class="card-img-top">
        </#if>
        <div class="m-2">
            <span>${item.itemName}</span>
            <i>${item.itemPrice}</i>
        </div>
        <div class="card-footer text-muted">
            ${item.authorName}
        </div>
    </div>
    <#else>
    No items
    </#list>
</div>
</@c.page>