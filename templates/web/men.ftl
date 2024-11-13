<section class="section" id="${section.id}">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="${section.class}-item-carousel">
                    <div class="owl-carousel">
                        <#list products as product>
                            <div class="item">
                                <img src="${product.image}" alt="${product.title}">
                                <h4>${product.title}</h4>
                                <span>${product.price}</span>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
