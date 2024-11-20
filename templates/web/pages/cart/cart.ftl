<#import "/templates/system/common/crafter.ftl" as crafter />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Cart</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

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
                      <@crafter.renderRepeatGroup $field="${component.item_o.item}"
                      item, index>
                        <tr>
                            <td class="align-middle">
                                <img src="${item.include}" alt="${item.value}" style="width: 50px;">
                                ${item.value}
                            </td>
                            <td class="align-middle">
                                $${item.price_s}
                            </td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-minus">
                                            <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control form-control-sm bg-secondary border-0 text-center" value="${component.quantity_s}">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-plus">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle">
                                $${item.price_s?number * item.quantity_s?number}
                            </td>
                            <td class="align-middle">
                                <button class="btn btn-sm btn-danger"><i class="fa fa-times"></i></button>
                            </td>
                        </tr>
                    </@crafter.renderRepeatGroup>
                </tbody>
            </table>
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