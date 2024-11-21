<#import "/templates/system/common/crafter.ftl" as crafter />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>MultiShop - Online Shop Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/static-assets/css/style.css" rel="stylesheet">

    <@crafter.head />
</head>

<body>
<@crafter.body_top/>
    <!-- Cart Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
    <#assign cartTree = siteItemService.getSiteTree('/site/components/Cart', 1)>
<#if cartTree?has_content>
    <ul>
        <#list cartTree.childItems as item>
             <#assign cartItem = siteItemService.getSiteItem(item.storeUrl) />
            <li>
                <p>Quantity: ${cartItem.queryValue('quantity_s')}</p>
              <#assign item_o = cartItem.queryValues('item_o') />
               <p>testt: ${item_o}</p>
<#if item_o?? && item_o.item?size > 0>
    <#assign courseUrl = item_o.item[0].key />
    <#assign courseModel = siteItemService.getSiteItem(courseUrl) />
    <p>Course Name: ${courseModel.queryValue('nome_s')}</p>
    <!-- You can now use courseModel to access the fields of the course -->
</#if>
                </li>
        </#list>
    </ul>
<#else>
    <p>No items found in the Cart component.</p>
</#if>
               </div>
        </div>
    </div>
    <!-- Cart End -->

    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

    <#include "/templates/web/fragments/scripts.ftl">
    <@crafter.body_bottom/>

</body>
</html>