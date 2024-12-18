<#import "/templates/system/common/crafter.ftl" as crafter />

<@crafter.header id="header">
     <!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
            <div class="col-lg-4">
                <a href="" class="text-decoration-none">
                    <span class="h2 text-uppercase text-primary bg-dark px-2">Hub</span>
                    <span class="h2 text-uppercase text-dark bg-primary px-2 ml-n1">Managment</span>
                </a>
            </div>
            <div class="col-lg-4 col-6 text-left">
                <form action="">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for products">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-4 text-right">
        <a href="/loginuser" class="btn btn-primary text-uppercase px-4">Login/Register</a>
    </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid bg-dark mb-30">
        <div class="row px-xl-5">
            <div class="col-lg-5 d-none d-lg-block">
                <a class="btn d-flex align-items-center justify-content-between bg-primary w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; padding: 0 30px;">
                    <h6 class="text-dark m-0"><i class="fa fa-bars mr-2"></i>Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
                    <div class="navbar-nav w-100">
                        <#assign categoriesTree = siteItemService.getSiteTree('/site/components/categories', 1)>
                        <#assign subCategoriesTree = siteItemService.getSiteTree('/site/components/sub_categories', 1)>
                            <#if categoriesTree?has_content>
                            <#list categoriesTree.childItems as category>
                            <#assign categoryItem = siteItemService.getSiteItem(category.storeUrl) />
                            <div class="nav-item dropdown dropright">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                ${categoryItem.queryValue('categoryname_s')}
                                <i class="fa fa-angle-right float-right mt-1"></i>
                            </a>
                           <#-- Match subcategories for this category -->
                  <#assign relatedSubcategories = subCategoriesTree.childItems?filter(subcategory -> 
    siteItemService.getSiteItem(subcategory.storeUrl).category_o.item[0].key == category.storeUrl) />
                        <div class="dropdown-menu position-absolute rounded-0 border-0 m-0">
                            <#list relatedSubcategories as subcategory>
                                <#assign subCategoryItem = siteItemService.getSiteItem(subcategory.storeUrl) />
                                <a href="" class="dropdown-item">
                                    ${subCategoryItem.queryValue('subCategoryName_s')}
                                </a>
                            </#list>
                        </div>
                </div>
                             </#list>
                            <#else>
                                <p>No categories found.</p>
                            </#if>
                        </div>
                </nav>
            </div>
            <div class="col-lg-7">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <span class="h1 text-uppercase text-dark bg-light px-2">Multi</span>
                        <span class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="index.html" class="nav-item nav-link active">Home</a>
                            <a href="shop.html" class="nav-item nav-link">Shop</a>
                            <a href="detail.html" class="nav-item nav-link">Shop Detail</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages <i class="fa fa-angle-down mt-1"></i></a>
                                <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                    <a href="/cart" class="dropdown-item">Shopping Cart</a>
                                    <a href="/checkout" class="dropdown-item">Checkout</a>
                                </div>
                            </div>
                            <a class="nav-item nav-link" href="/contact">Contact</a>
                        </div>
                        <div class="navbar-nav ml-auto py-0 d-none d-lg-block">
                            <a href="" class="btn px-0">
                                <i class="fas fa-heart text-primary"></i>
                                <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">0</span>
                            </a>
                            <a href="" class="btn px-0 ml-3">
                                <i class="fas fa-shopping-cart text-primary"></i>
                                <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">0</span>
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->
</@crafter.header>
