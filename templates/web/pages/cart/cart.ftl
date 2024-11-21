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
    <link href="/static-assets/css/style.css" rel="stylesheet">
   <#include "/templates/web/fragments/scripts.ftl">
<#include "/templates/web/fragments/header.ftl">
    <@crafter.head />
</head>

<body>
<@crafter.body_top/>
    <!-- Cart Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-light table-borderless table-hover text-center mb-0">
                    <thead class="thead-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                        <#assign cartTree = siteItemService.getSiteTree('/site/components/Cart', 1)>
                        <#if cartTree?has_content>
                            <#list cartTree.childItems as item>
                                <#assign cartItem = siteItemService.getSiteItem(item.storeUrl) />
                                <#assign relatedItem = siteItemService.getSiteItem(cartItem.item_o.item[0].key) />
                                
                                <tr>
                                    <td class="align-middle">
                                        <img src="/static-assets/images/course.jpg" alt="" style="width: 50px;">
                                        ${relatedItem.queryValue('nome_s')}
                                    </td>
                                    <td class="align-middle">${relatedItem.queryValue('costo_s')}</td>
                                    <td class="align-middle">
                                        <div class="input-group quantity mx-auto" style="width: 100px;">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-minus">
                                                    <i class="fa fa-minus"></i>
                                                </button>
                                            </div>
                                            <input type="text" class="form-control form-control-sm bg-secondary border-0 text-center" value="${cartItem.queryValue('quantity_s')}">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-plus">
                                                    <i class="fa fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="align-middle">
                                        <#assign total = (relatedItem.queryValue('costo_s')?number) * (cartItem.queryValue('quantity_s')?number)>
                                        ${total}
                                    </td>
                                    <td class="align-middle">
                                        <button class="btn btn-sm btn-danger">
                                            <i class="fa fa-times"></i>
                                        </button>
                                    </td>
                                </tr>
                            </#list>
                        <#else>
                            <tr>
                                <td colspan="5">No items found in the Cart component.</td>
                            </tr>
                        </#if>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                <form class="mb-30" action="">
                    <div class="input-group">
                        <input type="text" class="form-control border-0 p-4" placeholder="Coupon Code">
                        <div class="input-group-append">
                            <button class="btn btn-primary">Apply Coupon</button>
                        </div>
                    </div>
                </form>
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Cart Summary</span></h5>
             <div class="bg-light p-30 mb-5">
    <div class="border-bottom pb-2">
   <#-- Calculate Subtotal dynamically by adding all item totals -->
        <#assign subtotal = 0>
        <#list cartTree.childItems as item>
            <#assign cartItem = siteItemService.getSiteItem(item.storeUrl) />
            <#assign relatedItem = siteItemService.getSiteItem(cartItem.item_o.item[0].key) />
            <#-- Sum the total for each item -->
            <#assign subtotal = subtotal + (relatedItem.queryValue('costo_s')?number * cartItem.queryValue('quantity_s')?number)>
        </#list>

        <div class="d-flex justify-content-between mb-3">
            <h6>Subtotal</h6>
            <h6>${subtotal?string}</h6>
        </div>

        <div class="d-flex justify-content-between">
            <h6 class="font-weight-medium">Shipping</h6>
            <h6 class="font-weight-medium">$10</h6>
        </div>
    </div>
    <div class="pt-2">
        <#-- Calculate Total -->
        <#assign shipping = 10>
        <#assign total = subtotal + shipping>

        <div class="d-flex justify-content-between mt-2">
            <h5>Total</h5>
            <h5>${total?string}</h5>
        </div>
        <button class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed To Checkout</button>
    </div>
</div>
            </div>
        </div>
    </div>
    <!-- Cart End -->

    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

	<#include "/templates/web/fragments/footer.ftl">

    <#include "/templates/web/fragments/scripts.ftl">
    <@crafter.body_bottom/>
</body>
</html>