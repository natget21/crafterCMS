<#import "/templates/system/common/crafter.ftl" as crafter />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>MultiShop - Online Shop Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
    <#include "/templates/web/fragments/head.ftl">
    <#include "/templates/web/fragments/header.ftl">
    <@crafter.head />
    </head>

<body>
<@crafter.body_top/>
	    <!-- Shop Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
           <!-- Shop Sidebar Start -->
            <div class="col-lg-3 col-md-4">
    <h5 class="section-title position-relative text-uppercase mb-3">
    <span class="bg-secondary pr-3">Filter by Tags</span>
</h5>
<div class="bg-light p-4 mb-30">
    <form>
        <#assign tagsTaxonomy = siteItemService.getSiteItem('/site/components/taxonomy/c75e804a-1180-fd59-31b8-43b415f10bcb.xml') />
        <#assign tags = tagsTaxonomy.values_o.item />
        
        <#assign smallTags = []>
        <#assign largeTags = []>
        
        <#-- Separate tags into small and large categories -->
        <#list tags as tag>
            <#if tag.value_s?trim?length <= 15>
                <#assign smallTags = smallTags + [tag]>
            <#else>
                <#assign largeTags = largeTags + [tag]>
            </#if>
        </#list>
        
        <#-- Display smaller tags (length <= 30) two per row -->
        <#assign counter = 0>
        <#list smallTags as tag>
            <#assign counter = counter + 1>
            <#if counter % 2 == 1>
                <div class="row mb-3">
            </#if>
            
            <div class="col-6">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="tag-${tag.key_s}">
                    <label class="custom-control-label" for="tag-${tag.key_s}">
                        ${tag.value_s}
                    </label>
                </div>
            </div>

            <#if counter % 2 == 0 || counter == smallTags?size>
                </div> <!-- End row for tags with length <= 30 -->
            </#if>
        </#list>

        <#-- Display larger tags (length > 30), each on its own row -->
        <#list largeTags as tag>
            <div class="row mb-3">
                <div class="col-12">
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="tag-${tag.key_s}">
                        <label class="custom-control-label" for="tag-${tag.key_s}">
                            ${tag.value_s}
                        </label>
                    </div>
                </div>
            </div>
        </#list>
    </form>
</div>
                <!-- Price Start -->
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by price</span></h5>
                <div class="bg-light p-4 mb-30">
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" checked id="price-all">
                            <label class="custom-control-label" for="price-all">All Price</label>
                            <span class="badge border font-weight-normal">1000</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-1">
                            <label class="custom-control-label" for="price-1">$0 - $100</label>
                            <span class="badge border font-weight-normal">150</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-2">
                            <label class="custom-control-label" for="price-2">$100 - $200</label>
                            <span class="badge border font-weight-normal">295</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-3">
                            <label class="custom-control-label" for="price-3">$200 - $300</label>
                            <span class="badge border font-weight-normal">246</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-4">
                            <label class="custom-control-label" for="price-4">$300 - $400</label>
                            <span class="badge border font-weight-normal">145</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                            <input type="checkbox" class="custom-control-input" id="price-5">
                            <label class="custom-control-label" for="price-5">$400 - $500</label>
                            <span class="badge border font-weight-normal">168</span>
                        </div>
                    </form>
                </div>
                <!-- Price End -->
                
            </div>
            <!-- Shop Sidebar End -->


            <!-- Shop Product Start -->
            <div class="col-lg-9 col-md-8">
                <div class="row pb-3">
                    <div class="col-12 pb-1">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <div>
                                <button class="btn btn-sm btn-light"><i class="fa fa-th-large"></i></button>
                                <button class="btn btn-sm btn-light ml-2"><i class="fa fa-bars"></i></button>
                            </div>
                            <div class="ml-2">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Sorting</button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#">Latest</a>
                                        <a class="dropdown-item" href="#">Popularity</a>
                                        <a class="dropdown-item" href="#">Best Rating</a>
                                    </div>
                                </div>
                                <div class="btn-group ml-2">
                                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Showing</button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#">10</a>
                                        <a class="dropdown-item" href="#">20</a>
                                        <a class="dropdown-item" href="#">30</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                  <#assign courseTree = siteItemService.getSiteTree('/site/components/items/course', 1)>
<#if courseTree?has_content>
    <#list courseTree.childItems as course>
        <#assign courseItem = siteItemService.getSiteItem(course.storeUrl) />
       <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
    <div class="product-item bg-light mb-4">
        <div class="product-img position-relative overflow-hidden">
            <img class="img-fluid w-100" src="/static-assets/images/techimage.jpg" alt="${courseItem.queryValue('nome_s')}">
            <div class="product-action">
                <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
            </div>
        </div>
        <div class="text-center py-4">
            <a class="h6 text-decoration-none" href="">${courseItem.queryValue('nome_s')}</a>
           <div class="d-flex align-items-center justify-content-center mt-2">
    <h5>&euro;${courseItem.queryValue('costo_s')}</h5>
    <#if courseItem.queryValue('extra_costo_t')?trim?length <= 15>
        <span> ${courseItem.queryValue('extra_costo_t')}</span>
    </#if>
</div>
            <div class="d-flex align-items-center justify-content-center mb-1">
                (${courseItem.queryValue('durata_s')})
            </div>
        </div>
    </div>
</div>
    </#list>
<#else>
    <p>No courses available.</p>
</#if>
                   
                    <div class="col-12">
                        <nav>
                          <ul class="pagination justify-content-center">
                            <li class="page-item disabled"><a class="page-link" href="#">Previous</span></a></li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                          </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- Shop Product End -->
        </div>
    </div>
    <!-- Shop End -->
	  <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


	<#include "/templates/web/fragments/footer.ftl">

    <#include "/templates/web/fragments/scripts.ftl">
    <@crafter.body_bottom/>

	</body>
</html>
